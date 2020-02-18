package JavaIntro1;

import java.util.Arrays;
public class DupCharArr {
    public static void main(String[] args) {
        int[] arr1={1,2,3,1,2,4,5,6,7,6,8,9,4,5,0};
        int[] arr2={4,5,6,7,4,5,6,7,4,5,6,7,4,5,6};
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2   = new StringBuffer();

        for (int k:
             arr1) {
            sb1.append(k);
        }
        for (int k:
        arr2) {
            sb2.append(k);
        }
        for (int i = 0; i < sb1.length(); i++) {
            int c=0;
            for (int j = i + 1; j < sb1.length(); j++) {
                if (sb1.charAt(i) == sb1.charAt(j)) {
                    sb1.deleteCharAt(j);
                    c++;
                }
                if(c>=1)
                    sb1.deleteCharAt(i);
            }


        }
        for (int i = 0; i < sb2.length(); i++) {
            int c=0;
            for (int j = i + 1; j < sb2.length(); j++) {
                if (sb2.charAt(i) == sb2.charAt(j)) {
                    sb2.deleteCharAt(j);
                    c++;
                }
                if(c>=1)
                    sb2.deleteCharAt(i);
            }

        }
        int count = 0;
        for (int i = 0; i < sb1.length(); i++) {
            for (int j = 0; j < sb2.length(); j++) {
                if (sb1.charAt(i) == sb2.charAt(j)) {
                    count+=1;
                }
            }
        }
        System.out.println("Number of duplicate elements = "+count);


    }
}
