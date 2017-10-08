/**
 * The ClockDisplay 3.39 is a clock that is 24hour internally but displays the time
 * as a 12hr clock
 * 
 * Author: Olive Tamondong
 * Date: October 8, 2017
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
        
        else if(0 < hours.getValue() && hours.getValue() <= 11)
         displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + " am";
        
        else if(hours.getValue() == 12)
         displayString = "12: " + minutes.getDisplayValue() + " pm";
           
                         
        else if( hours.getValue() > 12 )
         displayString = (hours.getValue() % 12) + ":" +
                        minutes.getDisplayValue() + " pm";
    }

