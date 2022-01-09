package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.UnhandledAlertException;
import poms.RegisterPOM;

public class SDFHooks {
	//runs once before everything
	@BeforeAll
	public static void setUp () {
		RegisterPOM registerPOM = new RegisterPOM (DriverSingleton.getInstance ());
		
		try {
			DriverSingleton.getInstance ().get ("http://localhost:4200/register");
			
			registerPOM.firstNameInput ("John");
			registerPOM.lastNameInput ("Smith");
			registerPOM.emailInput ("johnsmith@example.com");
			registerPOM.usernameInput ("johnsmith");
			registerPOM.passwordInput ("password");
			registerPOM.confirmPasswordInput ("password");
			registerPOM.clickRegisterBtn ();
			
			registerPOM.waitForSuccessfulRegister ();
		}
		
		//if user already exists, do nothing
		catch (UnhandledAlertException ignored) {}
		
		finally {
			DriverSingleton.quitInstance ();
		}
		
		try {
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
		
		finally {
			DriverSingleton.quitInstance ();
		}
		
		try {
			DriverSingleton.getInstance ().get ("http://localhost:4200/register");
			
			registerPOM.firstNameInput ("D");
			registerPOM.lastNameInput ("d");
			registerPOM.emailInput ("player1foreverr@gmail.com");
			registerPOM.usernameInput ("d");
			registerPOM.passwordInput ("d");
			registerPOM.confirmPasswordInput ("d");
			registerPOM.clickRegisterBtn ();
		}
		
		//if user already exists, do nothing
		catch (UnhandledAlertException ignored) {}
		
		finally {
			DriverSingleton.quitInstance ();
		}
	}
	
	//runs after every scenario
	@After
	public void tearDown () {
		DriverSingleton.quitInstance ();
	}
}
