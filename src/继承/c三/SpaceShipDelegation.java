package 继承.c三;

/**
 * @author clt
 * @create 2019/11/27 19:23
 * 代理示例代码
 */
public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();

    SpaceShipDelegation(String name) {
        this.name = name;
    }

    void up(int velocity) {
        controls.up(velocity);
    }

    void down(int velocity) {
        controls.down(velocity);
    }

    void left(int velocity) {
        controls.left(velocity);
    }

    void right(int velocity) {
        controls.right(velocity);
    }

    void back(int velocity) {
        controls.back(velocity);
    }

    void forward(int velocity) {
        controls.forward(velocity);
    }

    void turboBoost(int velocity) {
        controls.turboBoost(velocity);
    }

    public static void main(String[] args) {

        SpaceShipDelegation spaceShipDelegation = new SpaceShipDelegation("太空船");
        spaceShipDelegation.back(10);

    }

}
