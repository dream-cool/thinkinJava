package 异常.使用finally进行清理;

/**
 * @author clt
 * @create 2019/12/4 19:30
 * 恢复模型
 *
 */
public class NullException {

    public static void main(String[] args) {
        Object obj = null;
        int num = 0;
        while (true){
            int randomNum = (int) (Math.random() *1000);
            if (randomNum < 100){
                obj = Integer.valueOf(randomNum);
            }
            try {
                obj.hashCode();
                break;
            } catch (NullPointerException e){
                num++;
            }
        }
        System.out.println("抛出异常的次数："+num);
        System.out.println("通过的obj："+obj.hashCode());
    }

}
