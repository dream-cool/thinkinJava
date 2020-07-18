package 多态.转机;

/**
 * @author clt
 * @create 2019/11/28 20:58
 * 产生正确的行为 示例 练习2、练习3、练习4
 */
//: Shapes.java
// Polymorphism in Java
class Shape {
    void draw() {}
    void erase() {}
    void print(){
        System.out.println("print shape");
    }
}
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Circle.draw()");
    }
    @Override
    void erase() {
        System.out.println("Circle.erase()");
    }
}
class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Square.draw()");
    }
    @Override
    void erase() {
        System.out.println("Square.erase()");
    }
    @Override
    void print(){
        System.out.println("Square print");
    }
}
class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Triangle.draw()");
    }
    @Override
    void erase() {
        System.out.println("Triangle.erase()");
    }
}
class Rectangle extends Shape{
    @Override
    void draw() {
        System.out.println("Rectangle.draw()");
    }
    @Override
    void erase() {
        System.out.println("Rectangle.erase()");
    }
}
public class Shapes {
    public static Shape randShape() {
        switch((int)(Math.random() * 4)) {
            default: // To quiet the compiler
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
            case 3: return new Rectangle();
        }
    }
    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        // Fill up the array with shapes:
        for(int i = 0; i < s.length; i++)
            s[i] = randShape();

        // Make polymorphic method calls:
        for(int i = 0; i < s.length; i++)
            s[i].draw();

        System.out.println("---------");

        for(int i = 0; i < s.length; i++)
            s[i].print();
    }
} ///:~
