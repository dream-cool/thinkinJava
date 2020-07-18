package 继承.h八;

/**
 * @author clt
 * @create 2019/11/28 19:19
 * 7.8.1 空白final  练习19
 */
class Person{
    private String name;

    Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class FinalPerson {
    final Person person;

    FinalPerson(String name){
        person = new Person(name);
        /**
         * 若构造器中如果没有对空白final进行初始化则编译无法通过
         */

    }

    FinalPerson(){
        person = new Person("name");
    }

    public static void main(String[] args) {
        FinalPerson person = new FinalPerson("CLT");
        System.out.println(person.person);
        FinalPerson person1 = new FinalPerson();
        System.out.println(person1.person);
    }
}
