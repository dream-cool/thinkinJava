package 类型信息.class对象;

/**
 * @author clt
 * @create 2019/12/6 18:40
 */
//: typeinfo/SweetShop.java
// Examination of the way the class loader works.

class Candy {

    static int num = 1;

    static { System.out.println("Loading Candy"); }

    {
        System.out.println("loading");
    }
}

class Gum {
    static { System.out.println("Loading Gum"); }
}

class Cookie {
    static { System.out.println("Loading Cookie"); }
}

public class SweetShop {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("inside main");
        int a = Candy.num;
        System.out.println("After creating Candy");
        try {
            Class.forName("类型信息.class对象.Gum");
        } catch(ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~

