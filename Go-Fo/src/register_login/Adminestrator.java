package register_login;

import java.util.List;
import java.util.Scanner;

/**
 * class for admiestrator to approve playgrounds and check eWallet
 * @author Mohamed Sobh
 *
 */
public class Adminestrator{
	Scanner scan=new Scanner(System.in);
    private final String Adminstrator="admin",password="1234";
    
    /**
     * menu function to show available option for the Administrator 
     * @param approved is a list containing all approved playgrounds
     * @param playgroundLists is a list containing all unapproved playgrounds
     */
    public void menu(List<playground>approved,List<playground>playgroundLists){
        while(true) {
			System.out.println("Welcome Adminstrator to Go Fo");
			System.out.println("choose one of the options: ");
			System.out.println("1-Approve Playground ");
			System.out.println("2-log out");
			int choice=scan.nextInt();
			if(choice==1) {
				if(playgroundLists.size()==0)
					System.out.println("No unapproved playgrounds");
				else
					ApprovPlayGround(playgroundLists,approved);
			}
			else if(choice==2) {
				return;
			}
		}
        
        
    }
    
    /**
     * this function show list of tasks administrator can do to approve playgrounds and deletes it from
     * undefin list and add it to approve list
     * @param undefin is a list containing all unapproved playgrounds to delete the playground that administrator approved on
     * @param approve is a list containing all approved playgrounds to add the playground that administrator approved on 
     */
    public void ApprovPlayGround(List<playground>undefin,List<playground>approve){
	      for(int i=0;i<undefin.size();i++){
	          System.out.println((i+1)+"."+"playground name: "+undefin.get(i).getname());
	          System.out.println("Playground Location: "+undefin.get(i).getlocation());
	          System.out.println("Playground Size: "+undefin.get(i).getsize());
	          System.out.println("Playground Start: "+undefin.get(i).getstart());
	          System.out.println("Playground end: "+undefin.get(i).getend());
	          System.out.println("Playground cancel period: "+undefin.get(i).getcancelperiod());
	          System.out.println("Playground avilable hours: "+undefin.get(i).getavailablehours());
	          System.out.println("Playground price perhour: "+undefin.get(i).getpriceperhour());
	          System.out.println("Playground ID: "+undefin.get(i).getPlaygroundId());
	          System.out.println();
	      }
	      while(true){
	          System.out.println("choose one of the options: ");
	          System.out.println("1.select all");
	          System.out.println("2.select number of the playe ground you want to approve it");
	          System.out.println("3.return");
	          int choice=scan.nextInt();
	          if(choice==1){
	               for(int i=0;i<undefin.size();i++){
	            	   undefin.get(i).setstatus("approve");
	            	   approve.add(undefin.get(i));
	               }
	               undefin.clear();
	               
	          }
	          else if(choice==2){
	               System.out.print("pleas Eneter the number of the PlayGround want to approve it: ");
	               int numberofPlayGround=scan.nextInt();
	               for(int i=0;i<numberofPlayGround;i++){
	              		System.out.println("Enter playground name:");
	                    String name= scan.next(); 
	                    System.out.println("Enter playground id:");
	                    String id=scan.next();
	                    for(int x=0;x<undefin.size();x++) {
	                    	if(id.equalsIgnoreCase(undefin.get(x).getPlaygroundId()) && name.equalsIgnoreCase(undefin.get(x).getname())) {
	                       		undefin.get(x).setstatus("approve");
	    	                    approve.add(undefin.get(x));
	    	                    undefin.remove(x);
	    	                    break;
	                       	}
	                    }
	               	}
	          }
	          else if(choice==3){
	                 return ;
	          }
	          else
	                 System.out.println("please sir choice one of the option");
	      }
	        
	        
	        
	    }
    /**
     * get the administrator name to use it in logging in
     * @return administrator name
     */
    public String getName() {
    	return Adminstrator;
    }
    /**
     * get the administrator password to use it in logging in
     * @return administrator password
     */
    public String getPassword() {
    	return password;
    }
}
