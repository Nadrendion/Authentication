package se.coolcode.modules.models.authentication;

import org.mindrot.jbcrypt.BCrypt;

public class Password {

	public final String password;

	public Password(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

}
