package 异常.创建自定义异常;

/**
 * @author clt
 * @create 2019/12/3 19:39
 */
public class Practice3 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        try {
            numbers[10] = 10;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("catch an ArrayIndexOutOfBoundsException");
        }
        System.out.println("continue");
    }
}
