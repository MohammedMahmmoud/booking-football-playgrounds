package register_login;

import java.util.List;
import java.util.Vector;


/**
 * this class is made to make the user or administrator log in
 * @author Mohamed Yosry Abd-Elaal
 *
 */
public class Login {
	private String password,name;
	
	/**
	 * set the name and the password to log in
	 * @param n represent the name that user entered
	 * @param pass represent the password that user entered
	 */
	public void setInfo(String n,String pass)
	{
		name=n;
		password=pass;
	}
	
	/**
	 * check the info that the user entered
	 * @param admin is object of class administrator to check the user-name and password
	 * @param obj is the list of objects of all the users to check the name and password
	 * @return index that represent the index of the user or administrator or to know if the index is out range of the list 
	 * and doesn't exist
	 */
	public int checkInfo(Adminestrator admin,List<User>obj)
	{
		int index=obj.size()+1;
		if(name.equals(admin.getName()) && password.equals(admin.getPassword()))
			return index+2;
		for(int i=0;i<obj.size();i++)
		{
			if(obj.get(i).getName().equals(name) && password.equals(obj.get(i).getPassword()))
				return i;
		}
		return index;
	}

}
