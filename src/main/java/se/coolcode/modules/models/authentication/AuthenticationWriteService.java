package se.coolcode.modules.models.authentication;

public interface AuthenticationWriteService {

	void createAccount(Username username, Password password);

}
