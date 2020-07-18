package 继承.b二;

/**
 * @author clt
 * @create 2019/11/27 18:57
 * 7.2.1练习9
 */
class Component1{
    Component1(){
        System.out.println("Component1.....");
    }
}
class Component2{
    Component2(){
        System.out.println("Component2......");
    }
}
class Component3{
    Component3(){
        System.out.println("Component3......");
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
}

public class Stem extends Root{
    Stem(){
        System.out.println("Stem.........");
    }
    public static void main(String[] args) {
        Stem s = new Stem();
        /**
         * Component1.....
         * Component2......
         * Component3......
         * Root.....
         * Stem.........
         *
         */

    }


}
