package 多态.用继承进行设计;

/**
 * @author clt
 * @create 2019/11/29 20:40
 *  用继承进行设计  练习16
 */

class Ship{
    public void act(){
        System.out.println("Ship act");
    }
}

class CargoShip extends Ship{
    public void act(){
        System.out.println("CargoShip act");
    }
}

class AirShip extends Ship{
    public void act(){
        System.out.println("AirShip act");
    }
}


public class StarShip {
    private Ship ship = new CargoShip();


    public void alertStatus(){
        ship = new AirShip();
    }

    public static void main(String[] args) {
        StarShip starShip = new StarShip();
        starShip.ship.act();
        starShip.alertStatus();
        starShip.ship.act();
        /**
         * CargoShip act
         * AirShip act
         *
         * 用继承表达行为建的差异
         * 用字段表达状态上的变化
         */

    }

}
