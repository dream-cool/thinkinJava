package 内部类;

/**
 * @author clt
 * @create 2020/7/22 9:35
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}
public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() { return i == items.length; }
        @Override
        public Object current() { return items[i]; }
        @Override
        public void next() { if(i < items.length) i++; }
    }

    private class ReverseSelector implements Selector {
        private int i = 9;
        @Override
        public boolean end() { return i < 0; }
        @Override
        public Object current() { return items[i]; }
        @Override
        public void next() { if(i >= 0) i--; }
    }

    public Selector selector() {
        return new SequenceSelector();
    }
    public Selector reverseSelector() {
        return new ReverseSelector();
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        /**
         * 当某个外部类的对象创建了一个内部类对象时，
         * 此内部类对象必定会秘密地捕获一个指向那个外部类对象的引用。
         * 然后，在你访问此外部类的成员时，就是用那个引用来选择外部类的成员。
         *
         * 内部类的对象只能在与其外部类的对象相关联的情况下才能被创建（就像你应该看到的，内部类是非 static 类时）。
         * 构建内部类对象时，需要一个指向其外部类对象的引用，如果编译器访问不到这个引用就会报错。
         */
        System.out.println();
        Selector selector1 = sequence.reverseSelector();
        while(!selector1.end()) {
            System.out.print(selector1.current() + " ");
            selector1.next();
        }




    }
}
