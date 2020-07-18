package 继承.d四;

/**
 * @author clt
 * @create 2019/11/27 19:36
 * 组合和继承示例
 */
//: PlaceSetting.java
// Combining composition & inheritance
class Plate {
    Plate(int i) {
        System.out.println("Plate constructor"+i);
    }
}
class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        System.out.println(
                "DinnerPlate constructor"+i);
    }
}
class Utensil {
    Utensil(int i) {
        System.out.println("Utensil constructor"+i);
    }
}
class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        System.out.println("Spoon constructor"+i);
    }
}
class Fork extends Utensil {
    Fork(int i) {
        super(i);
        System.out.println("Fork constructor"+i);
    }
}
class Knife extends Utensil {
    Knife(int i) {
        super(i);
        System.out.println("Knife constructor"+i);
    }
}
// A cultural way of doing something:
class Custom {
    Custom(int i) {
        System.out.println("Custom constructor"+i);
    }
}
public class PlaceSetting extends Custom {
    Spoon sp;
    Fork frk;
    Knife kn;
    DinnerPlate pl;
    PlaceSetting(int i) {
        super(i + 1);
        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        System.out.println(
                "PlaceSetting constructor"+i);
    }
    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);

    }

} ///:~
/**
 * Custom constructor 10
 * Utensil constructor 11
 * Spoon constructor 11
 * Utensil constructor 12
 * Fork constructor 12
 * Utensil constructor 13
 * Knife constructor 13
 * Plate constructor 14
 * DinnerPlate constructor 14
 * PlaceSetting constructor 9
 */
