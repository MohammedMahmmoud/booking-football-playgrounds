package register_login;

/**
 * class to make new account (player,playground owner)
 * @author Mohamed Yosry Abd-Elaal
 *
 */
 public class Register {
	
	 /**
	  * set all the user(player,playground owner) information
	  * @param name the name of the new user
	  * @param password the password of the user
	  * @param email the email of the new user 
	  * @param phone the phone number of the user
	  * @param role the role of the user(player,playground owner)
	  * @param address the address of the user
	  * @param id the id of the user and it is unique
	  * @return the object of type User that represent new user that has been created
	  */
	public User setInfo(String name,String password,String email,String phone,String role,String address,int id)
	{
		User newuser = null;
		if(role.equals("player")||role.equals("Player"))
			newuser=new Player(name,password,phone,address,email,id);
		else if(role.equalsIgnoreCase("playground owner"))
			newuser=new PlayGroundowner(name,password,phone,address,email,id);
		else System.out.println("role is not valid");
		return newuser;
	}

}
