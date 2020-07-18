package 多态.再论向上转型;

/**
 * @author clt
 * @create 2019/11/28 20:27
 * 再论向上转型 示例
 */
//: Music.java
// Inheritance & upcasting
class Note {
    private int value;
    private Note(int val) { value = val; }
    public static final Note
            middleC = new Note(0),
            cSharp = new Note(1),
            cFlat = new Note(2);
} // Etc.
class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}
// Wind objects are instruments
// because they have the same interface:
class Wind extends Instrument {
    // Redefine interface method:
    @Override
    public void play(Note n) {
        System.out.println("Wind.play()");
    }
}
class Stringed extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Stringed2.play()");
    }
}
class Brass extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Brass2.play()");
    }
}
public class Music {
    public static void tune(Instrument i) {
        // ...
        i.play(Note.middleC);
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed flute1 = new Stringed();
        Brass flute2 = new Brass();

        tune(flute); // Upcasting
        tune(flute1); // Upcasting
        tune(flute2); // Upcasting
        /**
         * Wind.play()
         * Stringed2.play()
         * Brass2.play()
         */
    }
} ///:~