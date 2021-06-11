package register_login;
import java.util.ArrayList;
/**
 * contains all information for the playground
 * @author Ahmed Mohamed Abd-Elwahed
 */
class playground {
    private String name;
    private String location;
    private float size;
    private int priceperhour;
    private int availablehours;
    private int cancelperiod;
    private int start;
    private int end;
    private int playgroundownerid;
    private String status,playgroundId;
    private ArrayList<Integer> hoursforbooking = new ArrayList<Integer>();
    
    /**
     * set start for time to play
     * @param startt start of time to play
     */
    public void setstart (int startt)
    {
        start=startt;
    }
    /**
     * set end of playing time
     * and then call function to set hours that player can reserve
     * @param endd end of playing time
     */
    public void setend (int endd)
    {
        end=endd;
        setHoursforbooking();
    }
    /**
     * get start time to play
     * @return start of time to play
     */
    public int getstart ()
    {
        return start;
    }
    /**
     * get end of time to play
     * @return end of playing time
     */
    public int getend ()
    {
        return end;
    }
    
    /**
     * set hours to be reserved in a list to print it to the player
     */
    public void setHoursforbooking ()
    {
        for (int i=start;i<end;i++)
            hoursforbooking.add(i);
    }
    
    /**
    *
    *  print available hours that player can reserve
    */
   public void gethoursforbooking()    {
       System.out.println("The available hours of the ground :");
       for (int i = 0; i < hoursforbooking.size(); i++) {
           System.out.println(hoursforbooking.get(i));
       }
   }
    
    /**
     *Confirm that playground information and hours that he selected are available
     * @param namee playground's name
     * @param to start time to play
     * @param end end of time to play
     * @param Id2 playground's id
     * @return true if information is correct otherwise return false
     */
    public boolean confirmOrder( String namee,int start,int end,String Id2)
    { int checker1=0,checker2=0,startIndex = 0,endIndex=0;
      if (name.equalsIgnoreCase(namee) &&	Id2.equalsIgnoreCase(playgroundId)) {
          for (int i = 0; i < hoursforbooking.size(); i++) {
              if (hoursforbooking.get(i) == start) {
            	  startIndex=i;
                  checker1 += 1;
              }
          }
          if (this.end==end)
          {
        	  endIndex=hoursforbooking.size();
        	  checker2 += 1;
          }
          for (int i = 0; i < hoursforbooking.size(); i++) {
              if (hoursforbooking.get(i) == end) {
            	  endIndex=i;
                  checker2 += 1;
              }
          }
          if (checker1 + checker2 == 2 && startIndex!=endIndex)
          {
        	  for(int i=endIndex-1;i>startIndex-1;i--)
        	  {
        		  hoursforbooking.remove(i);
        	  }
                  return true;
          }
          else
              return false;
      }
      else
          return false;
    }
    
    /**
     * set name of playground
     * @param namee playground's name
     */
    public void setname (String namee)
    {
        name=namee;
    }
    /**
     * set playground owner's id
     * @param id playground owner's id
     */
    public void setPlaygroundownerid (int id)
    {
        playgroundownerid=id;
    }
    /**
     * get playground owner's id
     * @return id for the playground owner
     */
    public int getPlaygroundownerid ()
    {
       return playgroundownerid;
    }
    /**
     * set playground's id
     * @param num palyground's id
     */
    public void setPlaygroundId (String num)
    {
        playgroundId=num;
    }
    /**
     * get playground's id
     * @return playground id
     */
    public String getPlaygroundId ()
    {
       return playgroundId;
    }
    
    /**
     * set location for playground
     *
     * @param locatione location of playground
     */
    public void setlocation (String locatione)
    {
        location=locatione;
    }
    /**
     * set size of playground
     * @param sizee size of playground
     */
    public void setsize (float sizee)
    {
        size=sizee;
    }
    /**
     *set price for hour to play for the playground
     * @param priceperhoure price for hour to play
     */
    public void setpriceperhour (int priceperhoure)
    {
        priceperhour=priceperhoure;
    }
    /**
     * set number of available hours that the playground is available
     * @param availablehourse number of available hours
     */
    public void setavailablehours(int availablehourse)
    {
        availablehours=availablehourse;
    }
    /**
     * set period that is available to cancel reservation
     * @param cancelperiode period to cancel reservation
     */
    public void setcancelperiod(int cancelperiode)
    {
        cancelperiod=cancelperiode;
    }
    /**
     * set the status for the playground
     * @param statuse playground's status
     */
    public void setstatus(String statuse)
    {
        status=statuse;
    }
    /**
     *get palyground's name
     * @return playground's name
     */
    public String getname ()
    {
        return name;
    }
    /**
     * get location for the playground
     * @return plauground's location
     */
    public String getlocation ()
    {
        return location;
    }
    /**
     * get playground's size
     * @return size of the playground
     */
    public float getsize ()
    {
        return size;
    }
    /**
     * get the price for hour of the playground
     * @return price per hour of playground
     */
    public int getpriceperhour ()
    {
        return priceperhour;
    }
    /**
     * get number of available hours for the playground
     * @return   number of available hours for the playground
     */
    public int getavailablehours()
    {
        return availablehours;
    }
    /**
     * get cancel period 
     * @return cancel period
     */
    public int getcancelperiod()
    {
        return cancelperiod;
    }
    /**
     * set status of the playground
     * @return status of the playground
     */
    public String setstatus()
    {
        return status;
    }
    /**
     * get playground owner'sid
     * @return playgroundowner's id
     */
    public int getId()
    {
    	return playgroundownerid;
    }
}