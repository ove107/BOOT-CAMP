package Collections;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Que7 {
    public static Map sortMap(Map<Integer,Integer> map) //descending order
    {
        Map<Integer,Integer> sorted;
        sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new));

        return sorted;
    }
    public static void show(Map<Integer,Integer> map)
    {
        System.out.print("[");
        for(Integer key: map.keySet())
        {
            System.out.print("{ "+key+" , "+map.get(key)+" }");
        }
        System.out.print("]\n");
    }
    public static void main(String[] args) throws IOException {
        Map<Integer,Integer> map= new LinkedHashMap<Integer,Integer>();
        System.out.print("Enter values: ");
        String[] strArr=new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        Integer[] arr=new Integer[strArr.length];
        int i=0;
        for(String s: strArr)
        {
            Integer key=Integer.parseInt(s);
            if(map.containsKey(key))
            {
                //increment value
                map.put(key,map.get(key)+1);
            }
            else
            {
                //insert key and value 1
                map.put(key,1);
            }
            i++;
        }
        show(map);
        show(sortMap(map));
    }
}