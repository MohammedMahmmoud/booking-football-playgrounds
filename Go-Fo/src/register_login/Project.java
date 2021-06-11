package register_login;

//import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Project {
	int playgroundd=1;
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args)
	{
		List<User>users=new Vector<User>();
		List<playground>unapprovedPlaygrounds=new Vector<playground>();
		List<playground>approvedPlaygrounds=new Vector<playground>();
		Adminestrator admin=new Adminestrator();
	 	Register registe=new Register();
	 	Login login=new Login();
	 	int index=-1,id=1;
	 	while(true) {
		 	boolean exist=false;
			System.out.println("Welcom to Go Fo.\nEnter your choice..");
			System.out.println("1-Register");
			System.out.println("2-Login");
			int choice;
			boolean nameChecker=true;
			choice=scan.nextInt();
			if(choice==1)
			{
				String name="none",password,address,email,role,phone;int code,find=0;
				while(true) {
                  
				       System.out.println("Enter your name: "); name=scan.next();
                                       
					for(int i=0;i<users.size();i++)
					{
						if(users.get(i).getName().equalsIgnoreCase(name)) {
							nameChecker=false;
							break;
						}
						else nameChecker=true;
					}
					if(!nameChecker)
						System.out.println("name is already exist...");
					else break;
				}
				System.out.println("Enter your password: "); password=scan.next();
				System.out.println("Enter your address: "); address=scan.next();
				System.out.println("Enter your phone: "); phone=scan.next();

	            boolean ch=true;          
	            scan.nextLine();
	            while(true) {	//checking on e-mail must have '@' and '.' no space
	            	System.out.println("Enter your email: "); email=scan.nextLine(); 
		            for (int i=0;i<email.length();i++)
	                {
	                  if (email.charAt(i)=='@')
	                      {find=1;}
	                  
	                }
		            if(find!=1) {
		            	System.out.println("email must have '@' on it. please re enter the email correctly");
		            	continue;
		            }
		            for (int i=0;i<email.length();i++)
	                {
		            	if (email.charAt(i)==' ')// space;
	                    {find=-1;}
	                  
	                }
		            if(find==-1)
		            {
		            	System.out.println("email can't have space on it. please re enter the email correctly");
		            	continue;
		            }
		            
		            for (int i=0;i<email.length();i++)
		            {
		            	if (email.charAt(i)=='.')// has '.';
		                {find++;}
		              
		            }
		            if(find!=2)
		            {
		            	System.out.println("email must have '.' character on it. please re enter the email correctly");
		            	System.out.println("Enter your email: "); email=scan.nextLine(); 
		            }
		            
		            if(find==2)	 break;           
	            }

                while (ch==true){			//confirming account
	                Random rand = new Random();
	                int upperbound = 100000; 
	                int int_random = rand.nextInt(upperbound);
	                System.out.println("Enter the code "+ int_random);code=scan.nextInt();
		            if (int_random!=code)
		                 System.out.println("you enter the wrong number");
		                 
		            else 
		                 ch=false;                                
                }
  
				scan.nextLine();
				System.out.println("Enter your role: "); role=scan.nextLine();
				users.add(registe.setInfo(name,password,email,phone,role,address,id)); 
				
				if(users.get(users.size()-1)==null)
					users.remove(users.size()-1);
				else 
					{index=users.size()-1;id++;exist=true;}
			}
			else
			{
				String password,name;
				System.out.println("Enter your name: "); name=scan.next();
				System.out.println("Enter your password: "); password=scan.next();
				login.setInfo(name,password);
				index=login.checkInfo(admin,users);
				exist=true;
			}
			if(index<users.size() && index>-1 && exist) {
				if(users.get(index).getRole().equalsIgnoreCase("player"))
					users.get(index).menu(users.get(index), approvedPlaygrounds);
				else if(users.get(index).getRole().equalsIgnoreCase("playground owner"))
					users.get(index).menu(users.get(index), unapprovedPlaygrounds);
			}
			else if(index==users.size()+3 && exist) {
				admin.menu(approvedPlaygrounds, unapprovedPlaygrounds);
			}
			else if(index==users.size()+1)
			{
				System.out.println("doesn't exist");
			}
		}
	 	
	 	
	}

}