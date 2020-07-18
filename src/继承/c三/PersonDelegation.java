package 继承.c三;

/**
 * @author clt
 * @create 2019/11/27 19:31
 */
public class PersonDelegation {
    private String name;
    private PersonControls personControls = new PersonControls();
    PersonDelegation(String name){
        this.name = name;
    }

    public void eat() {
        personControls.eat();
    }

    public void sleep() {
        personControls.sleep();
    }

    public void playGame() {
        personControls.playGame();
    }

    public static void main(String[] args) {
        PersonDelegation person = new PersonDelegation("CLT");
        person.eat();
    }
}
