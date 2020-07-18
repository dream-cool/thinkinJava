package 继承.c三;

/**
 * @author clt
 * @create 2019/11/27 19:18
 * 非代理的示例
 */
class SpaceShipControls{
    void up(int velocity){

    }
    void down(int velocity){}
    void left(int velocity){}
    void right(int velocity){}
    void back(int velocity){ }
    void forward(int velocity){}
    void turboBoost(int velocity){}

}

public class SpaceShip  extends SpaceShipControls{
    private String name;
    SpaceShip(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip("太空船");
        spaceShip.forward(100);
    }
}
