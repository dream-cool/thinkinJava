package 继承.d四;

/**
 * @author clt
 * @create 2019/11/27 20:00
 * 7.4.1 练习12
 */
class Component1{
    Component1(){
        System.out.println("Component1.....");
    }
    void dispose(){
        System.out.println("Component1.....dispose");
    }
}
class Component2{
    Component2(){
        System.out.println("Component2......");
    }
    void dispose(){
        System.out.println("Component2.....dispose");
    }
}
class Component3{
    Component3(){
        System.out.println("Component3......");
    }
    void dispose(){
        System.out.println("Component3.....dispose");
    }

}

class Root{
    Component1 component1;
    Component2 component2;
    Component3 component3;
    Root(){
        component1 = new Component1();
        component2 = new Component2();
        component3 = new Component3();
        System.out.println("Root.....");
    }
    void dispose(){
        System.out.println("Root.....dispose");
        component3.dispose();
        component2.dispose();
        component1.dispose();
    }
}

public class Stem extends Root {
    Stem(){
        System.out.println("Stem.........");
    }
    void dispose(){
        System.out.println("Stem.....dispose");
        super.dispose();
    }
    public static void main(String[] args) {
        Stem s = new Stem();
        try {

        }finally {
            s.dispose();
        }
        /**
         * Component1.....
         * Component2......
         * Component3......
         * Root.....
         * Stem.........
         * Stem.....dispose
         * Root.....dispose
         * Component3.....dispose
         * Component2.....dispose
         * Component1.....dispose
         */

    }

}
