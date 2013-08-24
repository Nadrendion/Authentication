package se.coolcode.modules.models.authentication;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
	private static String SECRET_PASSWORD = "secret";
	private AuthenticationReadService authenticationReadService;
	private AuthenticationWriteService authenticationWriteService;
	
	@Before
	public void setup(){
		this.authenticationReadService = new DefaultAuthenticationReadService();
		this.authenticationWriteService = new DefaultAuthenticationWriteService();
	}
	
	@Test
	public void canCreateAnAccountWithUsernameAndPassword() {
//		Given: an accountservice, a username and a password
		Username username = new Username("CoolCode");
		Password password = new Password(SECRET_PASSWORD);
		
//		When: invoking the accountservice.createAccount and providing the username and password
		authenticationWriteService.createAccount(username, password);

//		Then: the username should not be available
		boolean available = authenticationReadService.isUsernameAvailable(username);
		assertTrue(available == false);

//		And: the password is not equal to the password-string used as password
		assertNotEquals(SECRET_PASSWORD, password.password);
		
	}
	
}
