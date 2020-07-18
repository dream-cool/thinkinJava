package 继承.h八;

/**
 * @author clt
 * @create 2019/11/28 19:11
 * 7.8.1 空白final 示例
 */
//: BlankFinal.java
// "Blank" final data members
class Poppet { }
public class BlankFinal {
    final int i = 0; // Initialized final
    final int j; // Blank final
    final Poppet p; // Blank final handle
    // Blank finals MUST be initialized
    // in the constructor:
    /**
     * 当在  每个  构造函数中对final初始化后则空白final编译可以通过
     */
    BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet();
    }
    BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet();
    }

    @Override
    public String toString() {
        return "BlankFinal{" +
                "i=" + i +
                ", j=" + j +
                ", p=" + p +
                '}';
    }

    public static void main(String[] args) {
        BlankFinal bf = new BlankFinal();
        BlankFinal bf1 = new BlankFinal(47);
        System.out.println(bf);
        System.out.println(bf1);
    }
} ///:~