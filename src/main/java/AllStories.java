import java.text.Format;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.Embeddable;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class AllStories extends JUnitStories {
	private final Selenium selenium = new DefaultSelenium("127.0.0.1", 4444,
			"*firefox", "http://localhost:8080");

	private final SeleniumContext seleniumContext = new SeleniumContext();

	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		selenium.setContext("A real test, using the real Selenium on the browser side served by jetty, driven from java");
		return new SeleniumConfiguration()
		.useSelenium(selenium)
		.useSeleniumContext(seleniumContext)
		.useStepMonitor(
				new SeleniumStepMonitor(selenium, seleniumContext,
						new SilentStepMonitor()))
						.useStoryLoader(new LoadFromClasspath(embeddableClass))
						.useStoryReporterBuilder(
								new StoryReporterBuilder()
								.withFormats(org.jbehave.core.reporters.StoryReporterBuilder.Format.CONSOLE));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {

		return new InstanceStepsFactory(configuration(),
				new jbehave.test.steps.PanierSteps(selenium))
		.createCandidateSteps();
	}

	@Before
	public void setUp() throws Exception {

		selenium.start();

	}

	@Override
	@Test
	public void run() throws Throwable {

		super.run();
	}

	@Override
	protected List<String> storyPaths() {

		return new StoryFinder().findPaths(
				CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
				Arrays.asList("**/" + System.getProperty("storyFilter", "*")
						+ ".story"), null);

	}

	@After
	public void stop() {

	}

}
