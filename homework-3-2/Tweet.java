/**
 * Represent a tweet, including the content, author's username
 * and time when it was posted. 
 */
public class Tweet {
    
    public String user;
    public DateTime datetime; 
    public String content;
    
    public Tweet(String user, DateTime datetime, String content) {
            this.user = user; 
            this.datetime = datetime;
            this.content = content;       
    }
    
    public String toString(){
        return "@"+this.user+" ["+datetime.toString()+"]: "+content;
    }
    
    @Override
    public int hashCode(){
        int hashValue = hash(user) *127 + hash(content) *1901 + hash(datetime) * 4591;
        return hashValue;
    }
    
    
    public int hash(String key){
        int hashVal =0;
        for (int i =key.length()-1; i>=0; i--)
            hashVal = 37* hashVal + key.charAt(i);
        
        return hashVal;  
    }
    
    public int hash(DateTime datetime){
        return datetime.hashCode();
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tweet)) {
            return false;
        }
        Tweet t = (Tweet) obj;
        return this.user.equals(t.user)
                && this.content.equals(t.content)
                && this.datetime.equals(t.datetime);
  
    }
    
}