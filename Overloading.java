package JavaIntro1;

public class Overloading {
    int Add(int a, int b) {
        return a + b;
    }

    double Add(double a, double b) {
        return a + b;
    }

    int Mul(int a, int b) {
        return a * b;
    }

    float Mul(float a, float b) {
        return a * b;
    }

    String Concatenate(String a, String b) {
        return a + " " + b;
    }

    String Concatenate(String a, String b, String c) {
        return a + " " + b + " " + c;
    }

    public static void main(String[] args) {
        Overloading o = new Overloading();
        System.out.println("Addition of two integers = " + o.Add(2, 3));
        System.out.println("Addition of two doubles = " + o.Add(2.54, 7.89));
        System.out.println("Multiplication of two int = " + o.Mul(5, 2));
        System.out.println("Multiplication of two float = " + o.Mul(5.2f, 2.5f));
        System.out.println("Concatenation of two strings = " + o.Concatenate("Two", "Strings"));
        System.out.println("Concatenation of three strings = " + o.Concatenate("Two", "Strings", "Plus third"));
    }
}
