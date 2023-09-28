package fr.inria.main.evolution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.ParseException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import fr.inria.astor.approaches.cardumen.CardumenApproach;
import fr.inria.astor.approaches.deeprepair.DeepRepairEngine;
import fr.inria.astor.approaches.jgenprog.JGenProg;
import fr.inria.astor.approaches.jgenprog.extension.TibraApproach;
import fr.inria.astor.approaches.jkali.JKaliEngine;
import fr.inria.astor.approaches.jmutrepair.jMutRepairExhaustive;
import fr.inria.astor.approaches.scaffold.ScaffoldRepairEngine;
import fr.inria.astor.core.faultlocalization.entity.SuspiciousCode;
import fr.inria.astor.core.ingredientbased.ExhaustiveIngredientBasedEngine;
import fr.inria.astor.core.manipulation.MutationSupporter;
import fr.inria.astor.core.setup.ConfigurationProperties;
import fr.inria.astor.core.setup.ProjectRepairFacade;
import fr.inria.astor.core.solutionsearch.AstorCoreEngine;
import fr.inria.main.AbstractMain;
import fr.inria.main.ExecutionMode;
import fr.inria.main.ExecutionResult;

/**
 * Astor main
 * 
 * @author Matias Martinez, matias.martinez@inria.fr
 *
 */
public class AstorMain extends AbstractMain {

	protected Logger log = Logger.getLogger(AstorMain.class.getName());

	protected AstorCoreEngine core = null;

	/**
	 * It creates a repair engine according to an execution mode.
	 * 
	 * 
	 * @param removeMode
	 * @return
	 * @throws Exception
	 */

	public AstorCoreEngine createEngine(ExecutionMode mode) throws Exception {
		core = null;
		MutationSupporter mutSupporter = new MutationSupporter();

		if (ExecutionMode.DeepRepair.equals(mode)) {
			core = new DeepRepairEngine(mutSupporter, projectFacade);

		} else if (ExecutionMode.CARDUMEN.equals(mode)) {
			core = new CardumenApproach(mutSupporter, projectFacade);

		} else if (ExecutionMode.jKali.equals(mode)) {
			core = new JKaliEngine(mutSupporter, projectFacade);

		} else if (ExecutionMode.jGenProg.equals(mode)) {
			core = new JGenProg(mutSupporter, projectFacade);

		} else if (ExecutionMode.MutRepair.equals(mode)) {
			core = new jMutRepairExhaustive(mutSupporter, projectFacade);

		} else if (ExecutionMode.EXASTOR.equals(mode)) {
			core = new ExhaustiveIngredientBasedEngine(mutSupporter, projectFacade);

		} else if (ExecutionMode.TIBRA.equals(mode)) {
			core = new TibraApproach(mutSupporter, projectFacade);

		} else if (ExecutionMode.SCAFFOLD.equals(mode)) {
			core = new ScaffoldRepairEngine(mutSupporter, projectFacade);

		} else {
			// If the execution mode is any of the predefined, Astor
			// interpretes as
			// a custom engine, where the value corresponds to the class name of
			// the engine class
			String customengine = ConfigurationProperties.getProperty(ExtensionPoints.NAVIGATION_ENGINE.identifier);
			core = createEngineFromArgument(customengine, mutSupporter, projectFacade);

		}

		// Loading extension Points
		core.loadExtensionPoints();

		core.initModel();

		if (ConfigurationProperties.getPropertyBool("skipfaultlocalization")) {
			// We dont use FL, so at this point the do not have suspicious
			core.initPopulation(new ArrayList<SuspiciousCode>());
		} else {
			List<SuspiciousCode> suspicious = core.calculateSuspicious();

			if (suspicious == null || suspicious.isEmpty()) {
				throw new IllegalStateException("No suspicious line detected by the fault localization");
			}

			core.initPopulation(suspicious);
		}

		return core;

	}

	/**
	 * We create an instance of the Engine which name is passed as argument.
	 * 
	 * @param customEngineValue
	 * @param mutSupporter
	 * @param projectFacade
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected AstorCoreEngine createEngineFromArgument(String customEngineValue, MutationSupporter mutSupporter,
			ProjectRepairFacade projectFacade) throws Exception {
		Object object = null;
		try {
			Class classDefinition = Class.forName(customEngineValue);
			object = classDefinition.getConstructor(mutSupporter.getClass(), projectFacade.getClass())
					.newInstance(mutSupporter, projectFacade);
		} catch (Exception e) {
			log.error("Loading custom engine: " + customEngineValue + " --" + e);
			throw new Exception("Error Loading Engine: " + e);
		}
		if (object instanceof AstorCoreEngine)
			return (AstorCoreEngine) object;
		else
			throw new Exception(
					"The strategy " + customEngineValue + " does not extend from " + AstorCoreEngine.class.getName());

	}

	@Override
	public ExecutionResult run(String location, String projectName, String dependencies, String packageToInstrument,
			double thfl, String failing) throws Exception {

		long startT = System.currentTimeMillis();
		initProject(location, projectName, dependencies, packageToInstrument, thfl, failing);

		String mode = ConfigurationProperties.getProperty("mode").toLowerCase();
		String customEngine = ConfigurationProperties.getProperty(ExtensionPoints.NAVIGATION_ENGINE.identifier);

		if (customEngine != null && !customEngine.isEmpty())
			core = createEngine(ExecutionMode.custom);
		else {
			for (ExecutionMode executionMode : ExecutionMode.values()) {
				for (String acceptedName : executionMode.getAcceptedNames()) {
					if (acceptedName.equals(mode)) {
						core = createEngine(executionMode);
						break;
					}
				}
			}

			if (core == null) {
				System.err.println("Unknown mode of execution: '" + mode + "',  modes are: "
						+ Arrays.toString(ExecutionMode.values()));
				return null;
			}

		}

		ConfigurationProperties.print();

		core.startSearch();

		ExecutionResult result = core.atEnd();

		long endT = System.currentTimeMillis();
		log.info("Time Total(s): " + (endT - startT) / 1000d);

		return result;
	}

	/**
	 * @param args
	 * @throws Exception
	 * @throws ParseException
	 */
	public static void main(String[] args) throws Exception {
		AstorMain m = new AstorMain();
		args = new String[14];
		args[0] = "-mode";
		args[1] = "jgenprog";
		args[2] = "-srcjavafolder";
		args[3] = "/src/main/java/";
		args[4] = "-srctestfolder";
		args[5] = "/src/test/java/";
		args[6] = "-binjavafolder";
		args[7] = "/build/classes/java/main/";
		args[8] = "-bintestfolder";
		args[9] = "/build/classes/java/test/";
		args[10] = "-location";
		args[11] = "/Users/ruizhengu/Experiments/APR-as-AAT/com1003_cafe_8";
		args[12] = "-dependencies";
		args[13] = "/Users/ruizhengu/Experiments/APR-as-AAT/dependency";

		m.execute(args);
	}

	public ExecutionResult execute(String[] args) throws Exception {
		boolean correct = processArguments(args);

		log.info("Running Astor on a JDK at " + System.getProperty("java.home"));

		if (!correct) {
			System.err.println("Problems with commands arguments");
			return null;
		}
		if (isExample(args)) {
			executeExample(args);
			return null;
		}

		String dependencies = ConfigurationProperties.getProperty("dependenciespath");
		dependencies += (ConfigurationProperties.hasProperty("extendeddependencies"))
				? (File.pathSeparator + ConfigurationProperties.hasProperty("extendeddependencies"))
				: "";
		String failing = ConfigurationProperties.getProperty("failing");
		String location = ConfigurationProperties.getProperty("location");
		String packageToInstrument = ConfigurationProperties.getProperty("packageToInstrument");
		double thfl = ConfigurationProperties.getPropertyDouble("flthreshold");
		String projectName = ConfigurationProperties.getProperty("projectIdentifier");

		setupLogging();

		ExecutionResult result = run(location, projectName, dependencies, packageToInstrument, thfl, failing);
		return result;
	}

	public AstorCoreEngine getEngine() {
		return core;
	}

	public void setupLogging() throws IOException {

		if (ConfigurationProperties.getPropertyBool("nolog")) {

			LogManager.getRootLogger().setLevel(Level.FATAL);
		} else {
			String patternLayout = "";
			if (ConfigurationProperties.getPropertyBool("disablelog")) {
				patternLayout = "%m%n";
			} else {
				patternLayout = ConfigurationProperties.getProperty("logpatternlayout");
			}

			Logger.getRootLogger().getLoggerRepository().resetConfiguration();
			ConsoleAppender console = new ConsoleAppender();
			console.setLayout(new PatternLayout(patternLayout));
			console.activateOptions();
			Logger.getRootLogger().addAppender(console);

			String loglevelSelected = ConfigurationProperties.properties.getProperty("loglevel");
			if (loglevelSelected != null)
				LogManager.getRootLogger().setLevel(Level.toLevel(loglevelSelected));

			if (ConfigurationProperties.hasProperty("logfilepath")) {
				FileAppender fa = new FileAppender();
				String filePath = ConfigurationProperties.getProperty("logfilepath");
				File fileLog = new File(filePath);
				if (!fileLog.exists()) {
					fileLog.getParentFile().mkdirs();
					fileLog.createNewFile();
				}

				fa.setName("FileLogger");
				fa.setFile(fileLog.getAbsolutePath());
				fa.setLayout(new PatternLayout(patternLayout));
				fa.setThreshold(LogManager.getRootLogger().getLevel());
				fa.setAppend(true);
				fa.activateOptions();
				Logger.getRootLogger().addAppender(fa);
				this.log.info("Log file at: " + filePath);

			}
		}
	}
}
