package JavaIntro2;


class Cloning implements Cloneable {
    int num;

    Cloning(int num) {
        this.num = num;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Copy {
    int num;
    Copy(int num) {
        this.num=num;
    }
    Copy(Copy obj) {
        num = obj.num;
    }
}
class DeepCopyShallowCopy{
    public static void main(String[] args) {
        try {
            Cloning obj = new Cloning(10);
            Cloning obj1 = (Cloning) obj.clone();
            System.out.println(obj.num);
            System.out.println(obj1.num);
            Copy obj2 = new Copy(5);
            Copy obj3 = new Copy(obj2);
            System.out.println(obj2.num);
            System.out.println(obj3.num);
        }
        catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}