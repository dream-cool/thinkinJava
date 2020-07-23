package 内部类;

/**
 * @author clt
 * @create 2020/7/22 10:05
 */
class Wrapping{
    private int value;

    public Wrapping(int value) {
        this.value = value;
    }

    int value(){
        return value;
    };
}
public class Parcel8 {
    public Wrapping wrapping(int x) {
        // Base constructor call:
        return new Wrapping(x) { // [1]
            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // [2]
    }
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }
}
