package concurrent;

import util.ThreadUtil;

import java.util.concurrent.ExecutorService;

import static util.ThreadUtil.sleep;

/**
 * @description
 * @author: clt
 * @create: 2021-04-10 20:16
 **/
public class InterruptTest {

    private static final ExecutorService executor = ThreadUtil.getDefaultExecutor();

    public static void main(String[] args) throws InterruptedException {

        // testInterrupted1();
        // testInterrupted2();
        // testInterrupted3();
        // testInterrupted4();
        testInterrupted5();
    }

    private static void testInterrupted1() {
        Thread thread = new Thread(() -> sleep(100, true));
        thread.start();
        System.out.println("thread is interrupt ? " + thread.isInterrupted());

        sleep(5, true);
        thread.interrupt();
        sleep(1, true);
        System.out.println("thread is interrupt ? " + thread.isInterrupted());
        sleep(100, true);
    }

    /**
     * 学会在本地线程任务对中断作出处理
     */
    private static void testInterrupted2() {
        try {
            startRandomInterrupt();
        } catch (InterruptedException e) {
            System.out.println("thread has interrupted, but the interrupted status has been cleared");
            System.out.println("thread is interrupt ? " + Thread.currentThread().isInterrupted());
        }
    }

    /**
     * 自定义线程任务， 不响应中断
     *
     * 如果未在本地线程加上对中断的处理，其实中断就类似可有可无
     * 如下，即使 main 现在对 thread 线程进行了中断
     * 由于 sleep() 方法和 其余部分均未提供对中断的处理
     * 所以 thread 线程仍一如既往地执行自身工作，中断对他并无影响
     */
    private static void testInterrupted3() {
        Thread thread = new Thread(() -> {
            System.out.println("start to query data from database");
            sleep(3, false);
            System.out.println("handle data with normal");
        });
        thread.start();
        sleep(1, true);
        System.out.println("start to interrupt thread for db data handle");
        thread.interrupt();
    }

    /**
     * 自定义任务交由线程池处理， 且不响应中断
     * <p>
     * 此 test 和 test3 类似，均表明如果在线程任务逻辑中，如果没有的对中断的处理
     * 中断的概念将毫无意义。
     * 如下，把任务交由线程池处理，随后关闭线程池（
     *  关闭线程池的实质就是对每个 worker 线程进行中断
     *      shutdown() 只保证新的 worker 不再产生，旧的 worker 通过获取锁进行中断，锁获取失败将导致中断通知失败， 即只中断 空闲worker
     *      shutdownNow() 既保证新的 worker 不再产生，旧的 worker 通过不断获取锁进行中断，直到中断通知成功， 中断所有 worker
     * ）
     * 即使线程池已经关闭但任务无法阻碍 worker 线程的处理，
     * 只有 worker 线程自己响应对中断的处理才能真正意义实现中断。
     */
    private static void testInterrupted4() {
        executor.execute(() -> {
            System.out.println("start to query data from database");
            sleep(3, false);
            System.out.println("handle data with normal");
        });
        sleep(1, true);
        System.out.println("start to shutdown the executor");
        executor.shutdownNow();
        System.out.println("executor is shutdown ? " + executor.isShutdown());
    }

    /**
     * 自定义任务交由线程池处理， 且响应中断
     */
    private static void testInterrupted5() throws InterruptedException {
        executor.execute(() -> {
            System.out.println("start to query data from database");
            sleep(3, false);
            System.out.println("thread is interrupted ？ " + Thread.currentThread().isInterrupted());
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("the thread has been interrupted so can't handle data");
                return;
            }
            System.out.println("handle data with normal");
        });
        sleep(1, true);
        System.out.println("start to shutdown the executor");
        executor.shutdownNow();
        System.out.println("executor is shutdown ? " + executor.isShutdown());
    }

    private static void startRandomInterrupt() throws InterruptedException {
        System.out.println("start to execute task");
        for (; ; ) {
            sleep(1, true);
            if (Math.random() > 0.8) {
                // 设置当前线程终端状态
                Thread.currentThread().interrupt();
            }
            // 只检查当前线程是否是中断状态
            // if (Thread.currentThread().isInterrupted()) {
            // 检查当前是否为中断状态， 并清除掉中断状态
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            System.out.println("i am so happy that don't been interrupted");
        }
    }


}
