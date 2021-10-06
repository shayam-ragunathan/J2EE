package sample.repository;

import java.util.HashMap;
import java.util.Map;

import sample.beans.UserDetails;
import sample.beans.Users;

public class UserRepository {

private static Map<Users,UserDetails> userRepository= new HashMap<>();
static
{
	Users user1= new Users("Shyam","P@sword1");
	Users user2= new Users("Joint1","1");
	Users user3= new Users("Joint2","P@sword3");

	
	UserDetails  userDetail1=new UserDetails ("Shyam","Sundar","Ragunathan","shayam.ragunathan@oracle.com");
	UserDetails  userDetail2=new UserDetails ("Eegan","Shaym","Sundar","shayam.ragunathan2@oracle.com");
	UserDetails  userDetail3=new UserDetails ("Ajay","Ram","kanna","ajay.kanna@oracle.com");
	userRepository.put(user1, userDetail1);
	userRepository.put(user2, userDetail2);
	userRepository.put(user3, userDetail3);
}

public static UserDetails getUserById(Users currentUser)
{
	UserDetails userDetail =userRepository.get(currentUser);
	return userDetail;
}

public static boolean isUserAvailable(Users currentUser)
{
	boolean isAvailable = userRepository.containsKey(currentUser);
	return isAvailable;
}

}
