import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap; 
import java.util.TreeMap; 
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class TweetDB {
   
    
    HashMap<String, List<Tweet>> tweetsPerUser;
    HashMap<String, List<Tweet>> tweetsPerKeyword;  
    TreeMap<DateTime, List<Tweet>> tweetsByTime;

        
    public TweetDB(String pathToFile) throws FileNotFoundException, IOException {
        tweetsPerUser = new HashMap<>();               
        tweetsPerKeyword = new HashMap<>();   
        tweetsByTime = new TreeMap<>();  
        
        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        String[] s;
        String userName;
        String content;
        String[] words;
        
        CsvReader reader = new CsvReader(br);
        
        // this is the first line of the string
        s = reader.nextLine();
        while (s!=null){
            // construct a new tweet
            userName = s[0];
            content = s[1];
            DateTime date = new DateTime(s[2]);
            Tweet new_ = new Tweet(userName, date, content);
            
            // TweetsByTime
            if (tweetsByTime.get(date) == null){
                List<Tweet> tDate = new ArrayList<>();
                tDate.add(new_);
                tweetsByTime.put(date, tDate);
            } else{
                List<Tweet> tweet_Time = tweetsByTime.get(date);
                tweet_Time.add(new_);
                tweetsByTime.put(date, tweet_Time);
            }
            
            // TweetsPerKeyword
            // get a list of all the words in a string
            words = content.split("\\W+");
            for (String w: words){
                if(tweetsPerKeyword.get(w) == null){
                    List<Tweet> tKey = new ArrayList<>();
                    tKey.add(new_);
                    tweetsPerKeyword.put(w, tKey);
                } else{
                    List<Tweet> tweet_Key = tweetsPerKeyword.get(w);
                    tweet_Key.add(new_);
                    tweetsPerKeyword.put(w, tweet_Key);
                }         
            }
            
            // TweetsPerUser
            // If new user, create a new list; if old user, then add this element to the list
            if (tweetsPerUser.get(userName) == null){
                List<Tweet> t = new ArrayList<>();
                t.add(new_);   
                tweetsPerUser.put(userName, t);
            } else {
                List<Tweet> tweet_list = tweetsPerUser.get(userName);
                tweet_list.add(new_);
                tweetsPerUser.put(userName, tweet_list);
            } 
            s = reader.nextLine();   
        }  
        
    } 
    
    public List<Tweet> getTweetsByUser(String user) {
        List<Tweet> getUser = new ArrayList<>();
        Set<Tweet> setUser = new HashSet<>();
        
        
        if(tweetsPerUser.get(user) == null)
            return getUser;
  
        for (Tweet t_: tweetsPerUser.get(user))
            setUser.add(t_);
        
        for (Tweet t: setUser)
            getUser.add(t);
        
        return getUser;
    }
    
    
    public List<Tweet> getTweetsByKeyword(String kw) {
        List<Tweet> getKey = new ArrayList<>();
        Set<Tweet> setKey = new HashSet<>(tweetsPerKeyword.get(kw));
        
        for (Tweet t2: setKey)
            getKey.add(t2);
        
        return getKey;
    }
    
     public List<Tweet> getTweetsInRange(DateTime start, DateTime end) {

        List<Tweet> tweet_Range = new ArrayList<>(); 
        for (Map.Entry<DateTime,List<Tweet>> entry : tweetsByTime.subMap(start, end).entrySet()) {
            List<Tweet> values = entry.getValue();
            
            for (Tweet value : values)
                tweet_Range.add(value);
       }
         
         return tweet_Range;
    }  
    
    public static void main(String[] args) {
          
        try {
            TweetDB tdb = new TweetDB("coachella_tweets.csv"); // read the file                 

           // Part 1: Search by username 
            System.out.println("This is get tweets by Users: ");
            for(Tweet a : tdb.getTweetsByUser("b"))
                System.out.println(a.toString());
            
             
           // Part 2: Search by keyword
            System.out.println("This is get tweets by keywords: ");
            for(Tweet t : tdb.getTweetsByKeyword("hannah_frog"))
                System.out.println(t.toString());
           
            
           // Part 3: Search by date/time interval          
            System.out.println("This is get tweets by date range: ");
            for(Tweet c : tdb.getTweetsInRange(new DateTime("1/6/15 00:00"), new DateTime("1/6/15 5:00")))
                System.out.println(c.toString());
           
            
        } catch (FileNotFoundException e) {
            System.out.println(".csv File not found.");
        } catch (IOException e) {
            System.out.println("Error reading from .csv file.");
        }
        
        
        
        
    }
    
}