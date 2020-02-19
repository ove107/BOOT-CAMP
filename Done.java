package JavaIntro2;
import java.util.Scanner;
public class Done {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Word to match begining and ending char");
        String s = sc.next();
        sc.nextLine();

        while (!s.equalsIgnoreCase("done"))
        {
            if(s.charAt(0)==s.charAt(s.length()-1))
                System.out.println("Begining and ending char are same");
            else
                System.out.println("Begining and ending char not same");

            System.out.println("Enter a Word to match begining and ending char");
            s = sc.next();
            sc.nextLine();
        }
    }
}
