package JavaIntro2;

public class ClassNotFoundException {
    public static void main(String[] args) {
        try{
            Class.forName("Noreal.class");
        }
        catch (Exception e){
            System.out.println(e+" class not found");
        }
    }
}
