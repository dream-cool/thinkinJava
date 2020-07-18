package 继承.b二;

/**
 * @author clt
 * @create 2019/11/27 18:36
 */
//: Chess.java
// Inheritance, constructors and arguments
class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}
class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}
public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
    public static void main(String[] args) {
        Chess x = new Chess();
    }
} ///:~
/**
 * Game constructor
 * BoardGame constructor
 * Chess constructor
 */
