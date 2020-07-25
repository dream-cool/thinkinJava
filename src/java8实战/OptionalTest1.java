package java8实战;

import java.util.Optional;

/**
 * @author clt
 * @create 2020/7/25 16:26
 */
class Person {
    public Car car;
    public Optional<Car> getCar() { return Optional.ofNullable(car); }
}
class Car {
    public Insurance insurance;
    public Optional<Insurance> getInsurance() { return Optional.ofNullable(insurance); }
}
class Insurance {
    public String name;
    public String getName() { return name; }
}
public class OptionalTest1 {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(getCarInsuranceName(person));

        Car car = new Car();
        person.car = car;
        System.out.println(getCarInsuranceName(person));

        Insurance insurance = new Insurance();
        car.insurance = insurance;
        System.out.println(getCarInsuranceName(person));

        insurance.name = "aa";
        System.out.println(getCarInsuranceName(person));
    }

    public static String getCarInsuranceName(Person person) {
        Optional<Person> optional = Optional.ofNullable(person);

        return optional.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
