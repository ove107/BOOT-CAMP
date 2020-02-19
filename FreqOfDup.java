package JavaIntro1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FreqOfDup {
    public static void main(String[] args) {
        String test = "This is test to test the duplicate words in test test is this and this is test";
            CountFreq(test);
    }
   public static void CountFreq(String count)
   {
       Map<String,Integer> wordcount = new HashMap<String, Integer>();
       String[] words = count.split(" ");
       for(String w:words)
       {
           String temp = w.toLowerCase();
           if(wordcount.containsKey(temp))
           {
               wordcount.put(temp,wordcount.get(temp)+1);
           }
           else
               wordcount.put(temp,1);
       }
       System.out.println("Word"+"\t\t\t"+"Count");
       System.out.println("----"+"\t\t\t"+"-----");
       for (Map.Entry<String ,Integer> entry:wordcount.entrySet()) {
           System.out.println(entry.getKey()+" \t\t\t\t"+entry.getValue());
           
       }
       
   }
}
