package util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static util.ThreadUtil.sleep;

/**
 * @description
 * @author: clt
 * @create: 2021-04-11 14:42
 **/
public class TookTimeUtil {
    private static final Logger LOGGER = LogUtil.getLogger(TookTimeUtil.class);

    public static void logTookTime(Runnable r) {
        logTookTime(r, null);
    }

    public static <T,R> void logTookTime(Consumer<T> f, T t) {
        logTookTime((Object) f, t);
    }

    public static <T,R> void logTookTime(Supplier<T> f) {
        logTookTime( f, null);
    }

    public static <T,R> R logTookTime(Function<T,R> f, T t) {
        return (R) logTookTime((Object) f, t);
    }

    private static Object logTookTime(Object task, Object param) {
        Object result = null;
        long start = System.currentTimeMillis();
        if (task instanceof Runnable) {
            ((Runnable) task).run();
        }
        if (task instanceof Consumer) {
            ((Consumer) task).accept(param);
        }
        if (task instanceof Function) {
            result = ((Function) task).apply(param);
        }
        if (task instanceof Supplier) {
            result = ((Supplier) task).get();
        }
        LOGGER.info("the actual execution time is {} ms", System.currentTimeMillis() - start);
        return result;
    }


    public static void main(String[] args) {
        // runnable
        logTookTime(() -> sleep(1L, false));
        // consumer
        logTookTime((String str) -> System.out.println(str), "hello");
        // Supplier
        logTookTime(() -> "hello");
        // function
        logTookTime((String str) -> str, "hello");
    }
}
