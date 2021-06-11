package register_login;

/**
 * ewallet class to set and get all needed information about the user money
 * @author Mohamed Nasser
 *
 */
public class eWallet {
	private float AccMoney;
	
	/**
	 * contractor setting money to 0 by default
	 */
	eWallet()
	{
		AccMoney=0;
	}

	/**
	 * used to set user account money
	 * @param money is the money the  user have
	 */
    public void setAccMoney(float money)
	{
		AccMoney=money;
	}

	/**
	 * used to get user account money
	 * @param money is the money the  user have
	 */
    public float getAccMoney()
	{
		return AccMoney;
	}
    
    /**
	 * used to withdraw a money
	 * @param money is the money will withdraw
	 */

    public void withdraw(float money)
	{
		AccMoney-=money;
	}
    
    /**
	 * used to Deposit a money
	 * @param money is the money will Deposit
	 */
    public void Deposit(float money)
	{
		AccMoney+=money;
	} 
        
     }