package register_login;

import java.util.List;

/**
 * user class to set and get all needed information
 * @author Mohamed Yosry Abd-Elaal
 *
 */
public class User {
	private String name,password,phone,address,email,role;
	private int id;
	eWallet wallet =new eWallet();
	/**
	 * function made to show the menu of user or administrator(we use overriding)
	 * @param user the user that made register or log in
	 * @param playgroundLists list of all playgrounds
	 */
	public void menu(User user,List<playground>playgroundLists) {
		
	}
	/**
	 * used to set user name
	 * @param n the name user entered
	 */
	public void setName(String n)
	{
		name=n;
	}
	
	/**
	 * used to set user password
	 * @param pass is the password user entered
	 */
	public void setPassword(String pass)
	{
		password=pass;
	}
	
	/**
	 * set the user phone
	 * @param ph is the phone number user has entered
	 */
	public void setPhone(String ph)
	{
		phone=ph;
	}
	
	/**
	 * set the address
	 * @param add is the address user entered
	 */
	public void setAddress(String add)
	{
		address=add;
	}
	
	public void setEmail(String em)
	{
		email=em;
	}
	
	/**
	 * set the role of the user
	 * @param rol is the role that user entered
	 */
	public void setRole(String rol)
	{
		role=rol;
	}
	
	/**
	 * set unique id to the user
	 * @param Id is the unique id that has generated
	 */
	public void setId(int Id)
	{
		id=Id;
	}
	
	/**
	 * get user ID
	 * @return the user ID
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * get the user password
	 * @return the user password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * get the user name
	 * @return the user name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * get the role of the user
	 * @return the user role(player,playground owner)
	 */
	public String getRole()
	{
		return role;
	}
}
