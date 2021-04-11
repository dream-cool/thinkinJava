package util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description
 * @author: clt
 * @create: 2021-04-11 12:59
 **/
public class ThreadUtil {
    private ThreadUtil() {
    }
    public static final ThreadGroup DEFAULT_GROUP = Thread.currentThread().getThreadGroup();
    public static final String NAME_PREFIX = "concurrent_test_";
    private static final AtomicLong THREAD_NUMBER = new AtomicLong(0L);

    private static final ThreadFactory DEFAULT_THREAD_FACTORY = r -> {
        Thread t = new Thread(DEFAULT_GROUP,
                r,
                NAME_PREFIX + THREAD_NUMBER.getAndIncrement(),
                0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    };

    private static final ExecutorService executor = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(), DEFAULT_THREAD_FACTORY);

    public static ExecutorService getDefaultExecutor() {
        return executor;
    }


    public static void sleep(long second, boolean respondForInterrupt) {
        if (!respondForInterrupt) {
            long start = System.currentTimeMillis();
            for (; (System.currentTimeMillis() - start) < second * 1000; ) {
            }
        } else {
            try {
                Thread.sleep(second * 1000);
            } catch (InterruptedException e) {
                // 清除当前线程中断状态
                Thread.interrupted();
                e.printStackTrace();
            }
        }
    }
}
