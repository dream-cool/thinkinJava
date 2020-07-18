package 继承.g七;

/**
 * @author clt
 * @create 2019/11/27 20:57
 * 7.7 向上转型 示例
 */
//: Wind.java
// Inheritance & upcasting
import java.util.*;
class Instrument {
    public void play() {
        System.out.println("play");
    }
    static void tune(Instrument i) {
        // ...
        i.play();
    }
}
// Wind objects are instruments
// because they have the same interface:
class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Upcasting

        Instrument instrument = flute;
        Instrument instrument1 = new Instrument();
        instrument.play();
        instrument1.play();

//        向上转型成功 但方法被丢失
        Object object = instrument;
//        强制向下转型
        Instrument instrument2 = (Instrument)object;
        instrument2.play();
    }
} ///:~