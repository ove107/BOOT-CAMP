package JavaIntro1;

import java.lang.String;
public class RepSubStr {
    public static void main(String[] args) {
        String number = "112211221122";
        String replace = number.replace("11","33");
        System.out.println("Old String "+number);
        System.out.println("Replaced Substring "+replace);
    }
}
