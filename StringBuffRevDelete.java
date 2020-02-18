package JavaIntro1;

public class StringBuffRevDelete {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Java programming Language");
        System.out.println("string: " + sb);
        System.out.println("reverse: " + sb.reverse());
        System.out.println("After removing characters 4 through 9 "+sb.delete(4,9));
    }
}
