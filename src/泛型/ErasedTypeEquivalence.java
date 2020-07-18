package 泛型;

import java.util.ArrayList;

/**
 * @author clt
 * @create 2020/7/18 10:49
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
    /**
     * 泛型擦除
     * ArrayList<String> 和 ArrayList<Integer> 应该是不同的类型。
     * 不同的类型会有不同的行为。例如，如果尝试向 ArrayList<String> 中放入一个 Integer，
     * 所得到的行为（失败）和向 ArrayList<Integer> 中放入一个 Integer 所得到的行为（成功）完全不同。
     * 然而上面的程序认为它们是相同的类型。
     *
     */

}
