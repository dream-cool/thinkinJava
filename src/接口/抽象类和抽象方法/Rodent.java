package 接口.抽象类和抽象方法;

/**
 * @author clt
 * @create 2019/11/29 21:13
 * 抽象类和抽象方法  练习1
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
public abstract class Rodent {
    public abstract void eat();

    public static void tune(Rodent rodent){
        rodent.eat();
    }

    public static Rodent RandomInstrumentGenerator(){
        switch ((int)(Math.random() * 4)){
            default: // To quiet the compiler
            case 0:return new Mouse();
            case 1:return new Gerbil();
            case 2:return new Hamster();
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
