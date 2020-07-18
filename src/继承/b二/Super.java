package 继承.b二;

/**
 * @author clt
 * @create 2019/11/27 18:43
 * 7.2.1练习8
 */
class Base {
    Base(int i){
        System.out.println("base...."+i);
    }
}

public class Super extends Base{
    Super(){
        super(1);
        System.out.println("Super default constructor");
    }
    Super(int i){
        super(11);
        System.out.println("Super args constructor");
    }

    public static void main(String[] args) {

        Super sup = new Super();
        /**
         * base....1
         * Super default constructor
         */
        Super sup1 = new Super(1);
        /**
         * base....1
         * Super args constructor
         */
    }

}

