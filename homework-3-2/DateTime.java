/**
 * Represent a timestamp consisting of a date (day/month/year) and time 
 * in hours and minutes (24h format.
 */
public class DateTime implements Comparable<DateTime>{ //implements Comparable<DateTime> { //For part 4
    
    public int year;
    public int month;
    public int day; 
    public int hours;
    public int minutes;    
    public int seconds;
    public boolean pm; 

    
    public DateTime(int year, int day, int month, int h, int m) {        
        this.year = year; 
        this.month = month; 
        this.day = day;     
        this.hours = h; 
        this.minutes = m;                
    }
    
    public DateTime(String datetime) {
        String[] fields = datetime.split(" ");
        String[] dateFields = fields[0].split("/");
        month = Integer.parseInt(dateFields[0]);
        day = Integer.parseInt(dateFields[1]);
        year = Integer.parseInt(dateFields[2]);
        
        String[] timeFields = fields[1].split(":"); 
        hours = Integer.parseInt(timeFields[0]);
        minutes = Integer.parseInt(timeFields[1]);;
    }
    
    public String toString() {
        return Integer.toString(month)+"/"+Integer.toString(day)+"/"+Integer.toString(year)+"  "+
            String.format("%02d" , hours)+":"+String.format("%02d", minutes);
    }   
    
    @Override
    public int hashCode(){
        return year *27*27*27*27*27*27 + month *27*27*27*27*27 + day *27*27*27*27 + hours *27*27*27 + minutes *27*27;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DateTime)) {
            return false;
        }
        DateTime d = (DateTime) obj;
        return this.year == d.year
                && this.month == d.month
                && this.day == d.day
                && this.hours == d.hours
                && this.minutes == d.minutes;             
    }
    
    
    public int compareTo(DateTime other){
        // compare year
        if (this.year > other.year)
            return 1;
        else if (this.year < other.year)
            return -1;
        else{
            // compare month
            if (this.month > other.month)
                return 1;
            else if (this.month < other.month)
                return -1;
            else{
                // compare day
                if (this.day > other.day)
                    return 1;
                else if (this.day < other.day)
                    return -1;
                else{
                    // compare hours
                    if (this.hours > other.hours)
                        return 1;
                    else if (this.hours < other.hours)
                        return -1;
                    else {
                        // compare minutes
                        if (this.minutes > other.minutes)
                            return 1;
                        else if (this.minutes < other.minutes)
                            return -1;
                        else 
                            return 0;
                    }
                }
                
                
            }
            
        }
            
        
        
            
    }
    
    
}