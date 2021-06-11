package register_login;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * this is a class player for what player can do: add team show available playgrounds and book a playground
 * @author Mohamed Shob Mohamed, Mohamed Mahmoud Mansour and Mohamed Nasser Ismail
 *
 */
public class Player extends User {
	
	/**
	 * scanner for the input
	 */
	Scanner scan=new Scanner(System.in);
	
	
	/**
	 * this is a constructor for the player's information  
	 * @param name string for the player name
	 * @param Password string for the player password
	 * @param phone	string for the phone number of the player
	 * @param address string for the player address
	 * @param email string for the player e-mail
	 * @param id  string for the player id that must be unique 
	 */
	Player(String name,String Password,String phone,String address,String email,int id)
	{
		setRole("Player");
		setName(name);
		setPassword(Password);
		setPhone(phone);
		setAddress(address);
		setEmail(email);
		setId(id);
	}
	
	
	/**
	 * this is a class for the player team which he can invite to play with him in the playground he booked
	 * @author Mohamed Mahmoud Mansour
	 *
	 */
	public class team
	{
		/**
		 * string array for all the team of the player names and e-mails
		 */
		private String Names[],Emails[]; 
		/**
		 * int value for number of players that the player want to have
		 */
		private int noPlayer;
		
		
		/**
		 * chick that e-mail has the characters '@' and '.'  and has no space 
		 * @param email is the e-mail want to check that is correct
		 * @return the valid e-mail which has '@' and has no space
		 */
		String checkMail(String email){
			int find=0;
        	System.out.println("Enter your email: "); email=scan.nextLine(); 
            for (int i=0;i<email.length();i++)
            {
              if (email.charAt(i)=='@')
                  {find=1;}
              
            }
            if(find!=1) 
            	System.out.println("email must have '@' on it. please re enter the email correctly");
            for (int i=0;i<email.length();i++)
            {
            	if (email.charAt(i)==' ')// space;
                {find=-1;}
              
            }
            if(find==-1)
            	System.out.println("email can't have space on it. please re enter the email correctly");
            	
            for (int i=0;i<email.length();i++)
            {
            	if (email.charAt(i)=='.')// has '.';
                {find++;}
              
            }
            if(find!=2)
            	System.out.println("email must have '.' character on it. please re enter the email correctly");
            	
            
            if(find==2)
            	return email;	
            else return checkMail(email);
        }
		
		/**
		 * method that is used for create the player team 
		 * @return the team that has been added
		 */
		public team creatTeam() 
		{
			System.out.println("How many player you want to add to your team");
			noPlayer=scan.nextInt();
			Names=new String[noPlayer];	Emails=new String[noPlayer];
			for(int i=0;i<noPlayer;i++)
			{
				System.out.println("Enter player no."+(i+1)+" name");
				Names[i]=scan.next();
				scan.nextLine();
				Emails[i]=checkMail("x");
			}
			return this;
		}
		
		
		/**
		 * method to remove one player from the team
		 * @param pName string for the name of the player which the player want to remove from the team
		 * @return the team after removing the player or if the player name is entered wrongly 
		 * return the team without  any change
		 */
		public team removePlayer(String pName)
		{
			boolean isExisting=false;
			noPlayer--;
			
			for(int i=0;i<noPlayer;i++ )
			{
				if(Names[i].equals(pName))
				{
					for(int j = i; j < Names.length - 1; j++){
	                    Names[j] = Names[j+1];
	                    Emails[j]= Emails[j+1];
	                }
					isExisting=true;
				}
			}
			if(isExisting==false)
				System.out.println("This player you want to remove is not existing");
			
			return this;
		}
		
		
		/**
		 * method for adding one player to the team with the new player name and e-mail
		 * @return the team after adding the new player
		 */
		public team addPlayer()
		{
			String tempName[]=Names.clone(),tempEmail[]=Emails.clone();
			
			noPlayer++;
			Names=new String[noPlayer];		Emails=new String[noPlayer];
			Names=Arrays.copyOf(tempName, noPlayer);		Emails=Arrays.copyOf(tempEmail, noPlayer);
			System.out.println("at"+(noPlayer-1)+"\tEnter new player name");
			Names[noPlayer-1]=scan.next();
			scan.nextLine();
			Emails[noPlayer-1]=checkMail("x");
			System.out.println("Player added successfully");
			return this;
			
		}
		
		/**
		 * a unification method that make the player choose if he want to add or remove a player from the team  
		 */
		public void editTeam() {
			int choice;
			System.out.println("how you want to edit your team\n1-Delete an existing player\n2-Add new player");
			choice=scan.nextInt();
			while(true) {
				if(choice==1)
				{
					String name;
					System.out.println("Enter player name you want to remove");
					name=scan.next();
					removePlayer(name);
					break;
				}
				else if(choice==2) {
					addPlayer();
					break;
				}
				else 
					System.out.println("Please select valid choice");
			}
			
		}
		
		
		/**
		 * method for printing the players the player have
		 */
		void printTeam()
		{
			for(int i=0;i<noPlayer;i++)
				System.out.println("player name: "+Names[i]+"\te-mail :"+Emails[i]);
		}
	}
	Player.team myTeam=new team();
	
	
	/**
	 * method filter to display all playgrounds and display it filtered by name,location or available hours
	 * @param playgroundLists list from playground class that is the approved playgrounds 
	 */
	public void Filter(List<playground>playgroundLists){
		while(true){
            System.out.println("1.you want to view all the playground details");
            System.out.println("2.you want do filtering  by name for the playground");
            System.out.println("3.you want do filtering  by location for the playground");
            System.out.println("4.you want do filtering  by available hourse for the playground");
            System.out.println("5.back to home");
            System.out.print("pleas Enter your choice: ");
            int  choice=scan.nextInt();
            
            if(choice==1){
            	if(playgroundLists.size()>0)
    				System.out.println("playground name\t\tplayground location\tplayground size\t\tprice per hour\t\t" + 
    						"start time\t\tend time\t\tcancel period\t\tPlayground ID");			
            	for(int i=0;i<playgroundLists.size();i++){
    				System.out.println(playgroundLists.get(i).getname()+"\t\t\t"+
    						playgroundLists.get(i).getlocation()+"\t\t\t"+
    						playgroundLists.get(i).getsize()+"\t\t\t"+
    						playgroundLists.get(i).getpriceperhour()+"\t\t\t"+
    						playgroundLists.get(i).getstart()+"\t\t\t"+
    						playgroundLists.get(i).getend()+"\t\t\t"+
    						playgroundLists.get(i).getcancelperiod()+"\t\t\t"+
    						playgroundLists.get(i).getPlaygroundId());
                  }
         
            }
            
            else if(choice==2){
            	Filterbyname(playgroundLists);
            }
            
            else if(choice==3){
                 Filterbylocation(playgroundLists);
            }
            
            else if(choice==4){
                  Filterbyavailablehourse(playgroundLists);
            }
                     
            else if(choice==5){
                 return;
            }
                 
            else
                  System.out.println("pleas Enter one of the option and try agian");
         
            }
            
        }
	
		/**
		 * method to display playgrounds filtered by name
		 * @param playgroundLists list from playground class that is the approved playgrounds 
		 */
        public void Filterbyname(List<playground>playgroundLists){
            while(true){
                System.out.println("1.filtering playeground by name ");
                System.out.println("2.back to option ");
                System.out.print("pleas enter your choice:  ");
                int  choice=scan.nextInt();
                if(choice==1){
                	System.out.print("\nplease Enter the playeground name you want to search it:  ");
                	scan.nextLine();
                    String  userinputname=scan.nextLine();
                    System.out.println("playground name\t\tplayground location\tplayground size\t\tprice per hour\t\t" + 
    						"start time\t\tend time\t\tcancel period\t\tPlayground ID");
                    	for(int i=0;i<playgroundLists.size();i++){
                    		if(playgroundLists.get(i).getname().equals(userinputname)){
                    			System.out.println(playgroundLists.get(i).getname()+"\t\t\t"+
                						playgroundLists.get(i).getlocation()+"\t\t\t"+
                						playgroundLists.get(i).getsize()+"\t\t\t"+
                						playgroundLists.get(i).getpriceperhour()+"\t\t\t"+
                						playgroundLists.get(i).getstart()+"\t\t\t"+
                						playgroundLists.get(i).getend()+"\t\t\t"+
                						playgroundLists.get(i).getcancelperiod()+"\t\t\t"+
                						playgroundLists.get(i).getPlaygroundId());		
                             }
                             else
                                 System.out.println("there is no playeground in the name you make input please try agian");
                         }
                }
                else if(choice==2){
                    return;
                }
                else
                    System.out.println("pleas sir Enter your choice and try agin ");
            }
        }
        
        
        /**
		 * method to display playgrounds filtered by location
		 * @param playgroundLists list from playground class that is the approved playgrounds 
		 */
        public void Filterbylocation(List<playground>playgroundLists){
        	while(true){
                System.out.println("1.filtering playeground by location ");
                System.out.println("2.back to option ");
                System.out.print("pleas enter your choice:  ");
                int  choice=scan.nextInt();
                if(choice==1){
                	System.out.print("\nplease Enter the playeground location you want to search it:  ");
                	scan.nextLine();
                    String  userinputlocation=scan.nextLine();
                    System.out.println("playground name\t\tplayground location\tplayground size\t\tprice per hour\t\t" + 
    						"start time\t\tend time\t\tcancel period\t\tPlayground ID");
                    for(int i=0;i<playgroundLists.size();i++){
                    	if(playgroundLists.get(i).getlocation().equals(userinputlocation)){
                    		System.out.println(playgroundLists.get(i).getname()+"\t\t\t"+
            						playgroundLists.get(i).getlocation()+"\t\t\t"+
            						playgroundLists.get(i).getsize()+"\t\t\t"+
            						playgroundLists.get(i).getpriceperhour()+"\t\t\t"+
            						playgroundLists.get(i).getstart()+"\t\t\t"+
            						playgroundLists.get(i).getend()+"\t\t\t"+
            						playgroundLists.get(i).getcancelperiod()+"\t\t\t"+
            						playgroundLists.get(i).getPlaygroundId());		
                    	}
                        else
                                 System.out.println("there is no playeground in the location you make input please try agian");
                         }
                }
                else if(choice==2){
                    return;
                }
                else
                    System.out.println("pleas sir Enter your choice and try agin ");
        }
            
        }
        
        /**
		 * method to display playgrounds filtered by available hours
		 * @param playgroundLists list from playground class that is the approved playgrounds 
		 */
        public void Filterbyavailablehourse(List<playground>playgroundLists){
        	while(true){
                System.out.println("1.filtering playeground by available hour");
                System.out.println("2.back to option ");
                System.out.print("pleas enter your choice:  ");
                int  choice=scan.nextInt();
                if(choice==1){
                	System.out.print("\nplease Enter the number of avialable hour you want to search it:  ");
                	scan.nextLine();
                    int  userinputhour=scan.nextInt();
                    System.out.println("playground name\t\tplayground location\tplayground size\t\tprice per hour\t\t" + 
    						"start time\t\tend time\t\tcancel period\t\tPlayground ID");
                    for(int i=0;i<playgroundLists.size();i++){
                    	if(playgroundLists.get(i).getavailablehours()==(userinputhour)){
                    		System.out.println(playgroundLists.get(i).getname()+"\t\t\t"+
            						playgroundLists.get(i).getlocation()+"\t\t\t"+
            						playgroundLists.get(i).getsize()+"\t\t\t"+
            						playgroundLists.get(i).getpriceperhour()+"\t\t\t"+
            						playgroundLists.get(i).getstart()+"\t\t\t"+
            						playgroundLists.get(i).getend()+"\t\t\t"+
            						playgroundLists.get(i).getcancelperiod()+"\t\t\t"+
            						playgroundLists.get(i).getPlaygroundId());	
                    	}
                    	else
                             System.out.println("there is no number available hour you make input please try agian");
                         }
                }
                else if(choice==2){
                    return;
                }
                else
                    System.out.println("pleas sir Enter your choice and try agin ");
        }
            
        }
       
        
        /**
         * this method is used to to book a playground using playground name, id and time to book (from, to)
         * @param playgroundLists list from playground class that is the approved playgrounds 
         */
        public void booking(List<playground>playgroundLists) {
        	if(playgroundLists.size()>0)
				System.out.println("playground name\t\tplayground location\tplayground size\t\tprice per hour\t\t" + 
						"start time\t\tend time\t\tcancel period\t\tPlayground ID");			
        	for(int i=0;i<playgroundLists.size();i++){
				System.out.println(playgroundLists.get(i).getname()+"\t\t\t"+
						playgroundLists.get(i).getlocation()+"\t\t\t"+
						playgroundLists.get(i).getsize()+"\t\t\t"+
						playgroundLists.get(i).getpriceperhour()+"\t\t\t"+
						playgroundLists.get(i).getstart()+"\t\t\t"+
						playgroundLists.get(i).getend()+"\t\t\t"+
						playgroundLists.get(i).getcancelperiod()+"\t\t\t"+
						playgroundLists.get(i).getPlaygroundId());
              }
        	
        	Scanner input=new Scanner(System.in);
			   System.out.println("Select name playground you want to book");

			   for(int i=0;i<playgroundLists.size();i++)
			   {
				   System.out.println(i+1+": "+playgroundLists.get(i).getname()+"\t\t"+"Start :");
				   playgroundLists.get(i).gethoursforbooking();
			   }
			   System.out.println("Enter the name of playground :");
			   String name2 =input.next();
			   System.out.println("Enter the Id of playground :");
			   String Id2 =input.next();
			   System.out.println("Start time :");
			   int to2 =input.nextInt();
			   System.out.println("end  time :");
			   int end2 =input.nextInt();
			   int check=0;
			   System.out.println("Size  "+playgroundLists.size());
			   for(int i=0;i<playgroundLists.size();i++)
			   {
				   if (playgroundLists.get(i).confirmOrder(name2,to2,end2,Id2)) {
					   int time=end2-to2,	price=time*playgroundLists.get(i).getpriceperhour();
					   System.out.println("this booking will cost you ("+price+"). do you want to book now? (y,n)");
					   scan.nextLine();
					   char confermBook=scan.nextLine().charAt(0);
					   if(confermBook=='y')
					   {
						   if(this.wallet.getAccMoney()>=price)
						   {
							   System.out.println("----------------------------------");
							   System.out.println("--------DONE--------");
							   System.out.println("your order is confirmed");
							   System.out.println("----------------------------------");
							   check++;
							   System.out.println("---\""+price+" is withdrawn from your e-wallet---\"\n");
							   this.wallet.withdraw(price);
						   }
						   else System.out.println("you don't have that much of money on your e-wallet");
					   }
					   
			   		}

			   }
				   if (check==0)
				   {
				   System.out.println("----------------------------------");
				   System.out.println("Not confirmed your order");
				   System.out.println("please Enter a correct input");
				   System.out.println("----------------------------------");
				   }

        }
	
     
	/**
	 *this is an overridden method for the menu method in User class
	 *this method is used to print the player menu like create a team, edit the team(add or remove a player)
	 * or printing his team and to access your e_wallet
	 *or viewing the available playground, book the play ground or log out from the system
	 *@param user is the User account that refer to the player here
	 *@param playgroundLists list from playground class that is the approved playgrounds 
	 */
	public void menu(User user,List<playground>playgroundLists)
	{
		while(true) {
			System.out.println("Welcome "+user.getName()+" to Go Fo\nchoose one of the options:");
			System.out.println("1-Create a team\n2-Edit your team\n3-Show my team\n4-view playgrounds"+
					"\n5-Book a playground\n6-access you e-wallet\n7-log out");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				myTeam.creatTeam();
				break;
				
			case 2:
				myTeam.editTeam();
				break;
				
			case 3:
				myTeam.printTeam();
				break;
				
			case 4:
				Filter(playgroundLists);
				break;
				
			case 5:
				booking(playgroundLists);			
				break;
				
			case 6:
				System.out.println("you have : "+this.wallet.getAccMoney()+" at your e-wallet/ndo you want to add more money into it (y,n)");
				scan.nextLine();
				char op=scan.nextLine().charAt(0);
				
				if(op=='y')
				{
					float add;
					System.out.println("what is the amount of money you want to add? ");
					while(true)
					{
						add=scan.nextFloat();
						if(add<=0)
							System.out.println("this certain amount of money can not be added to your account please enter a +ve number");
						else
						{
							this.wallet.Deposit(add);
							System.out.println("successfly add ("+add+") to your e-wallet and you now have ("+
							this.wallet.getAccMoney()+") at your e-wallet\nplease press any key to continue");
							scan.nextLine();
							op=scan.nextLine().charAt(0);
							break;
						}
					}
				}

				break;
				
			case 7:
				return;
				
			default:
				System.out.println("please enter valid choice");
			}
		}
	}

}