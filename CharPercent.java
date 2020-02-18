package JavaIntro1;

public class CharPercent {
    public static void main(String[] args) {
        int upcase = 0, lowcase = 0, spchar = 0, digit = 0, slength = 0;
        String test = "This Is a tEst StRing to C@l(u!@te (#@R FrEQueNcY 12345678908766544321334567";
        for (char w : test.toCharArray()) {
            if (Character.isUpperCase(w))
                upcase += 1;
            else if (Character.isLowerCase(w))
                lowcase += 1;
            else if (Character.isDigit(w))
                digit += 1;
            else
                spchar += 1;
        }
        slength = test.length();
        System.out.println("No. of uppercase letter = " + upcase + " Percentage of uppercase letter = " + (upcase*100/ slength) );
        System.out.println("No. of lowercase letter = " + lowcase + " Percentage of lowercase letter = " + (lowcase*100 / slength) );
        System.out.println("No. of digit            = " + digit + "   Percentage of digits           = " + (digit*100 / slength) );
        System.out.println("No. of special character = " + spchar + " Percentage of special characters = " + (spchar*100/ slength) );
    }
}