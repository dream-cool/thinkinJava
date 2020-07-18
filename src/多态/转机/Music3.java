package 多态.转机;

/**
 * @author clt
 * @create 2019/11/28 21:19
 * 可扩展性 示例 练习6、练习8
 */
//: Music3.java
// An extensible program
import javax.sound.midi.Instrument;
import java.util.*;
class Instrument3 {
    public void play() {
        System.out.println("Instrument3.play()");
    }
    public String what() {
        return "Instrument3";
    }
    public void adjust() {}
}
class Wind3 extends Instrument3 {
    public void play() {
        System.out.println("Wind3.play()");
    }
    public String what() { return "Wind3"; }
    public void adjust() {}
}
class Percussion3 extends Instrument3 {
    public void play() {
        System.out.println("Percussion3.play()");
    }
    public String what() { return "Percussion3"; }
    public void adjust() {}
}
class Stringed3 extends Instrument3 {
    public void play() {
        System.out.println("Stringed3.play()");
    }
    public String what() { return "Stringed3"; }
    public void adjust() {}
}
class Brass3 extends Wind3 {
    public void play() {
        System.out.println("Brass3.play()");
    }
    public void adjust() {
        System.out.println("Brass3.adjust()");
    }
}
class Woodwind3 extends Wind3 {
    public void play() {
        System.out.println("Woodwind3.play()");
    }
    @Override
    public String toString() { return "Woodwind3"; }
}
public class Music3 {
    // Doesn't care about type, so new types
    // added to the system still work right:
    static void tune(Instrument3 i) {
        // ...
        i.play();
    }
    static void tuneAll(Instrument3[] e) {
        for(int i = 0; i < e.length; i++)
            tune(e[i]);
    }

    public static Instrument3 RandomInstrumentGenerator(){
        switch ((int)(Math.random() * 5)){
            default: // To quiet the compiler
            case 0:return new Wind3();
            case 1:return new Percussion3();
            case 2:return new Stringed3();
            case 3:return new Woodwind3();
            case 4:return new Brass3();
        }
    }

    public static void main(String[] args) {
        Instrument3[] orchestra = new Instrument3[5];
        int i = 0;
        // Upcasting during addition to the array:
        orchestra[i++] = new Wind3();
        orchestra[i++] = new Percussion3();
        orchestra[i++] = new Stringed3();
        orchestra[i++] = new Brass3();
        orchestra[i++] = new Woodwind3();
        System.out.println(orchestra[i-1]);
        tuneAll(orchestra);
        System.out.println("--------");
        Instrument3[] orchestra1 = new Instrument3[5];
        for (int j = 0; j < orchestra1.length; j++) {
            orchestra1[j] = RandomInstrumentGenerator();
        }
        tuneAll(orchestra1);

    }
} ///:~
