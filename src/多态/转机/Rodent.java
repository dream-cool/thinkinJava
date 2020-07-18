package 多态.转机;

/**
 * @author clt
 * @create 2019/11/28 21:37
 * 可扩展性  练习9
 */
class Mouse extends Rodent{
    @Override
    public void eat(){
        System.out.println("Mouse eat");
    }
}
class Gerbil extends Rodent{
    @Override
    public void eat(){
        System.out.println("Gerbil eat");
    }
}
class Hamster extends Rodent{
    @Override
    public void eat(){
        System.out.println("Hamster eat");
    }

}
public class Rodent {
    public void eat(){
        System.out.println("Rodent eat");
    }

    public static void tune(Rodent rodent){
        rodent.eat();
    }

    public static Rodent RandomInstrumentGenerator(){
        switch ((int)(Math.random() * 4)){
            default: // To quiet the compiler
            case 0:return new Mouse();
            case 1:return new Gerbil();
            case 2:return new Hamster();
            case 3:return new Rodent();
        }
    }

    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[9];
        for (int i = 0; i < rodents.length; i++) {
            rodents[i] = RandomInstrumentGenerator();
        }

        for (int i = 0; i < rodents.length; i++) {
            rodents[i].eat();
        }
    }
}
