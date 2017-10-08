
/**
 * 3.38 displays a 12hr clock. 00:00 is 12:00 am while time past 12:00 pm (13:00 to 23:00 pm) had 
 * their hours individually stored. at 24:00 time rolls over back to 12:00 am.
 * 
 * Author: Olive Tamondong
 * Date: Octover 8, 2017
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
   /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if(hours.getValue() == 0)
        displayString = "12:" + minutes.getDisplayValue() + " am";
        
        else if(0 < hours.getValue() && hours.getValue() < 12)
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + " am";
        else if(hours.getValue() == 12)
        displayString = hours.getDisplayValue() + ":" +
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 13)
        displayString = "01:" + minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 14)
        displayString = "02:" +
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 15)
        displayString = "03:" +
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 16)
        displayString = "04:" +
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 17)
        displayString = "05:"+
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 18)
        displayString = "06:"+
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 19)
        displayString = "07:" +
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 20)
        displayString = "08:" +
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 21)
        displayString = "09:" +
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 22)
        displayString = "10:" +
                        minutes.getDisplayValue() + " pm";
        else if(hours.getValue() == 23)
        displayString = "11:" +
                        minutes.getDisplayValue() + " pm";
        
    }
}
