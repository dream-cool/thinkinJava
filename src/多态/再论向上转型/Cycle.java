package 多态.再论向上转型;

/**
 * @author clt
 * @create 2019/11/28 20:44
 * 忘记对象类型  练习1
 */
class Unicycle extends Cycle{
    @Override
    public void ride(Cycle cycle){
        System.out.println("Unicycle ride");
    }

}
class Bicycle extends Cycle{
    @Override
    public void ride(Cycle cycle){
        System.out.println("Bicycle ride");
    }

}
class Tricycle extends Cycle{
    @Override
    public void ride(Cycle cycle){
        System.out.println("Tricycle ride");
    }

}

public class Cycle {

    public int wheels(){
        return (int)(Math.random() * 5);

    }

    public void ride(Cycle cycle){
        System.out.println(wheels());
        System.out.println("Cycle ride");
    }

    public static void tune(Cycle cycle) {
        cycle.ride(cycle);
        // ...
    }

    public static void main(String[] args) {
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        Cycle cycle = new Cycle();
        tune(unicycle);
        tune(bicycle);
        tune(tricycle);
        tune(cycle);
        /**
         * Unicycle ride Upcasting
         * Bicycle ride  Upcasting
         * Tricycle ride  Upcasting
         */

    }
}
