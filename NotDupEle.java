package JavaIntro1;

import sun.java2d.marlin.MarlinRenderer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NotDupEle {


    public static void main(String[] args) {
        int[] arr={1,1,4,4,7,7,3,3,5,5,8,9,9,0,0};
        Map<Integer,Integer> set = new HashMap();
        for (int i : arr) {
            if(set.containsKey(i))
                set.put(i,set.get(i)+1);
            else
                set.put(i,1);
        }
        for (Map.Entry<Integer, Integer> entry : set.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.printf("Non duplicate element is "+entry.getKey());
            }

    }
}}
