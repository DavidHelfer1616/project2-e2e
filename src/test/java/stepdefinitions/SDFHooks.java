package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.UnhandledAlertException;
import poms.RegisterPOM;

public class SDFHooks {
	//runs once before everything
	@BeforeAll
	public static void setUp () {
		try {
			RegisterPOM registerPOM = new RegisterPOM (DriverSingleton.getInstance ());
			
			DriverSingleton.getInstance ().get ("http://localhost:4200/register");
			
			registerPOM.firstNameInput ("John");
			registerPOM.lastNameInput ("Smith");
			registerPOM.emailInput ("johnsmith@example.com");
			registerPOM.usernameInput ("johnsmith");
			registerPOM.passwordInput ("password");
			registerPOM.confirmPasswordInput ("password");
			registerPOM.clickRegisterBtn ();
			
			registerPOM.waitForSuccessfulRegister ();
			
			DriverSingleton.getInstance ().get ("http://localhost:4200/register");
			
			registerPOM.firstNameInput ("Dr. Sarah");
			registerPOM.lastNameInput ("Smith");
			registerPOM.emailInput ("sarahsmith@example.com");
			registerPOM.usernameInput ("sarahsmith");
			registerPOM.passwordInput ("password");
			registerPOM.confirmPasswordInput ("password");
			registerPOM.clickRegisterBtn ();
			
			registerPOM.waitForSuccessfulRegister ();
		}
		
		//if user already exists, do nothing
		catch (UnhandledAlertException ignored) {}
	}
	
	//runs after every scenario
	@After
	public void tearDown () {
		DriverSingleton.quitInstance ();
	}
}
