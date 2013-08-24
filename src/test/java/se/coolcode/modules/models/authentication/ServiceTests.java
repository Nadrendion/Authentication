package se.coolcode.modules.models.authentication;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServiceTests {

	private AuthenticationReadService authenticationReadService;
	private AuthenticationWriteService authenticationWriteService;
	
	@Before
	public void setup(){
		this.authenticationReadService = new AuthenticationReadService();
		this.authenticationWriteService = new AuthenticationWriteService();
	}
	
	@Test
	public void canCreateAnAccountWithUsernameAndPassword() {
//		Given: an accountservice, a username and a password
		Username username = new Username("CoolCode");
		Password password = new Password("secret");
		
//		When: invoking the accountservice.createAccount and providing the username and password
		authenticationWriteService.createAccount(username, password);

//		Then: the username should not be available
		boolean available = authenticationReadService.isUsernameAvailable(username);
				
	}

}
