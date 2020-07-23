package 内部类;

/**
 * @author clt
 * @create 2020/7/22 15:06
 */
class Egg {
    private Yolk y;
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }
    Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}
public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }
    public static void main(String[] args) {
        BigEgg bigEgg = new BigEgg();
        /**
         * New Egg()
         * Egg.Yolk()
         */

        bigEgg.new Yolk();
        /**
         * BigEgg.Yolk()
         */

    }
}
