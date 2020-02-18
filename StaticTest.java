package JavaIntro1;

public class StaticTest {
    static String fname;
    static String lname;
    static int Age;
    static {
        System.out.println("Static block called");
        fname = "Ankit";
        lname = "Arora";
        Age = 20;
        System.out.println("First name = "+fname+" Last name = "+lname+" Age = "+Age);
    }
    static void change()
    {
        System.out.println("Static method called");
        lname = "Sagar";
        Age = 25;
    }
    void display()
    {
        System.out.println("First name = "+fname+" Last name = "+lname+" Age = "+Age);
    }

    public static void main(String[] args) {
        StaticTest st = new StaticTest();
        st.change();
        st.display();
    }
}
