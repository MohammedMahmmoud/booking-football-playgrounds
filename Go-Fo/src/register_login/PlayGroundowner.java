package register_login;
import java.util.List;
import java.util.Scanner;
/**
 * class PlayGroundowner
 * constructor  PlayGroundowner setting data of playground owner
 * function addplayground to add new playground for the owner
 * function menu for viewing menu for playground owner to show available tasks to do
 * @author Ahmed Mohamed Abd-ElWahed
 */
public class PlayGroundowner extends User{
    Scanner scan=new Scanner(System.in);
    private int numOfPlaygrounds=0;
	/**
	 * constructor to set data of playground owner
	 * @param name playground owner's name
	 * @param Password playground owner's password
	 * @param phone playground owner's phone
	 * @param address playground owner's address
	 * @param email playground owner's email
	 * @param id playground owner's id
	 */
    PlayGroundowner(String name,String Password,String phone,String address,String email,int id)
	{
		setRole("Playground owner");
		setName(name);
		setPassword(Password);
		setPhone(phone);
		setAddress(address);
		setEmail(email);
		setId(id);
	}
	/**
	 * function addplayground
	 * used to add new playground for the owner request to insert data of the playground
	 * and then set it to class playground
	 * @return object form class playground
	 */
	public  playground addplayground()
	{
		String name,location,playgoundId;
		float size;
		int priceperhour,cancelperiod,open,close;
		System.out.println("Enter playground name: "); name=scan.next();
		System.out.println("Enter playground location: "); location=scan.next();
		System.out.println("Enter playground size: "); size=scan.nextFloat();
		System.out.println("Enter playground opening time: "); open=scan.nextInt();
		System.out.println("Enter playground closing time: "); close=scan.nextInt();
		System.out.println("Enter playground priceperhour: "); priceperhour=scan.nextInt();
		System.out.println("Enter playground cancelperiod by days: "); cancelperiod=scan.nextInt();
		playgoundId=Integer.toString(getId())+Integer.toString(numOfPlaygrounds);
		playground play=new playground();
		play.setname(name);
		play.setlocation(location);
		play.setsize(size);
		play.setpriceperhour(priceperhour);
		play.setavailablehours(close-open);
		play.setcancelperiod(cancelperiod);
		play.setstart(open);
		play.setend(close);
		play.setPlaygroundownerid(getId());
		play.setstatus("unavailable");
		play.setPlaygroundId(playgoundId);
		return play;
	}
	/***
	 * FUNCTION menu to view available tasks for playground owner to do
	 * option 1 add playground
	 * option 2 log out
	 * @param user object from class user
	 * @param playgroundLists list of class play ground contains all playgrounds
	 */
	public void menu(User user,List<playground>playgroundLists) {
		while(true) {
			System.out.println("Welcome "+user.getName()+" to Go Fo");
			System.out.println("choose one of the options: ");
			System.out.println("1-Add new playground\n2-access your e-wallet");
			System.out.println("3-log out");
			int choice=scan.nextInt();
			if(choice==1) {
				System.out.println("Enter number of playgrounds you want to add...");
				int num=scan.nextInt();
				for(int i=0;i<num;i++)
				{
					numOfPlaygrounds++;
					playgroundLists.add(addplayground());
				}
			}
			
			else if(choice==2)
			{
				System.out.println("you have : "+this.wallet.getAccMoney()+" at your account/ndo you want to withdraw some money from it? (y,n)");
				scan.nextLine();
				char op=scan.nextLine().charAt(0);
				
				if(op=='y')
				{
					float get;
					System.out.println("what is the amount of money you want to withdraw? ");
					while(true)
					{
						get=scan.nextFloat();
						if(get<=0)
							System.out.println("this certain amount of money can not be withdrawn from your account please enter a +ve number");
						else if(get>this.wallet.getAccMoney())
							System.out.println("you only have "+this.wallet.getAccMoney()+" you can't withdraw more than that");
						else
						{
							this.wallet.Deposit(get);
							System.out.println("successfly withdrawn ("+get+") from your e-wallet and you now have ("+
							this.wallet.getAccMoney()+") at your e-wallet\nplease press any key to continue");
							scan.nextLine();
							op=scan.nextLine().charAt(0);
							break;
						}
					}
				}
			}
			
			else if(choice==3) {
				return;
			}
		}
		
	}

}
