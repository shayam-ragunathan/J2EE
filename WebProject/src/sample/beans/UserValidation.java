package sample.beans;

import sample.repository.UserRepository;

public class UserValidation {

public static boolean isValid(Users users)
{
	
    //String userId= users.getUserName();
    //String password= users.getUserPassword();
	boolean valid = UserRepository.isUserAvailable(users);

	return valid;
	
}

}
