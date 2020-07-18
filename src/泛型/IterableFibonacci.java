package 泛型;

import java.util.Iterator;

/**
 * @author clt
 * @create 2020/7/18 10:17
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int count) { n = count; }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() { return n > 0; }
            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.get();
            }
            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for(int i : new IterableFibonacci(18))
            System.out.print(i + " ");
        /**
         * 在 for-in 语句中使用 IterableFibonacci，
         * 必须在构造函数中提供一个边界值，这样 hasNext() 才知道何时返回 false，结束循环。
         */

    }
}
