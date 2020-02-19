package JavaIntro2;
class Singleton
{
    private static Singleton sing_inst = null;
    public String s;
    private Singleton()
    {
        s = "This is a SINGLETON CLass";
    }
    public static Singleton getInstance()
    {
        if (sing_inst == null)
            sing_inst = new Singleton();

        return sing_inst;
    }
}
class Main
{
    public static void main(String args[])
    {
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();
        x.s = (x.s).toUpperCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println();
        z.s = (z.s).toLowerCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
    }
}
