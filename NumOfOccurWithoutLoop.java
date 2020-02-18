package JavaIntro1;



public class NumOfOccurWithoutLoop {
    public static void main(String[] args) {
        String S = "This is a test string with aaaa and bbbb";
        int l =S.length();
        int ln = S.replace("a","").length();
        System.out.println("No. of occurrences of a = "+(l-ln));
    }
}
