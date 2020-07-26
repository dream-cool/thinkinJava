package java8实战.CompletableFuture;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author clt
 * @create 2020/7/26 15:26
 */
public class FutureTest {
    private static Random random = new Random();

    private static ExecutorService executor = new ThreadPoolExecutor(4,10,60L, TimeUnit.SECONDS, new SynchronousQueue<>());

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        test1();
        System.exit(0);
    }

    public static void test1() throws InterruptedException, ExecutionException, TimeoutException {
        long start = System.currentTimeMillis();
        //异步执行第一个任务
        Future<Integer> future =  executor.submit( () -> {
            int firstTaskConstTime = random.nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(firstTaskConstTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第一个已经执行完成， 耗时"+ firstTaskConstTime + "秒");
            return firstTaskConstTime;
        });
        //执行第二步任务
        int secondTaskConstTime = random.nextInt(10);
        TimeUnit.SECONDS.sleep(secondTaskConstTime);
        System.out.println("第二个已经执行完成， 耗时"+ secondTaskConstTime + "秒");
        //get 方法阻塞，直到future返回结果后才能获取到值
        System.out.println("第一个任务耗时" +future.get(10, TimeUnit.SECONDS) + "秒");
        System.out.println("第二个任务耗时" +secondTaskConstTime + "秒");
        System.out.println("总共耗时" + ((System.currentTimeMillis() - start) / 1000));
    }

}
