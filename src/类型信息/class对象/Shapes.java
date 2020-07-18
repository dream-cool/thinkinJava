package 类型信息.class对象;

/**
 * @author clt
 * @create 2019/12/6 18:22
 *
 */
//: typeinfo/Shapes.java
import 多态.再论向上转型.Cycle;

import java.util.*;

abstract class Shape {
    /**
     * 练习5
     */
    public static boolean rotate(Shape shape){
        if (shape instanceof Circle){
            return  true;
        }
        return false;
    }

    void draw() { System.out.println(this + ".draw()"); }
    abstract public String toString();
}

class Circle extends Shape {
    public String toString() { return "Circle"; }
}

class Square extends Shape {
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape{

    @Override
    public String toString() {
        return "Rhomboid";
    }
}

public class Shapes {


    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );
        for(Shape shape : shapeList)
            shape.draw();
        for(Shape shape : shapeList)
            System.out.println(shape);
        Rhomboid rhomboid = (Rhomboid) shapeList.get(3);
        System.out.println(rhomboid.getClass().getSimpleName());
        /**
         * 练习3
         */


        int index = (int) (Math.random()*3);
        while (index < 3){
            System.out.println(index);
            if (shapeList.get(index) instanceof Circle){
                System.out.println("success");
                break;
            }
            index = (int) Math.random()*5;
        }

        /**
         * 练习4
         */
        for(Shape shape : shapeList){
            System.out.println(Shape.rotate(shape));
        }





    }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~
