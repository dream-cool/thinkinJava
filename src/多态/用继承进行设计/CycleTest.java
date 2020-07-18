package 多态.用继承进行设计;

/**
 * @author clt
 * @create 2019/11/29 20:55
 * 向下转型与运行时类型识别 练习17
 */
class Cycle{

}

class Unicycle extends Cycle{
    public void balance(){
        System.out.println("Unicycle can balance");
    }
}

class Bicycle extends Cycle{
    public void balance(){
        System.out.println("Bicycle can balance");
    }
}

class Tricycle extends Cycle{

}


public class CycleTest {

    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[]{new Unicycle(),new Bicycle(),new Tricycle()};
        ((Unicycle)cycles[0]).balance();
        ((Bicycle)cycles[1]).balance();
//        ((Tricycle)cycles[2]).balance();
    }
}
