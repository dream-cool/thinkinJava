package concurrent;

import util.LogUtil;
import util.Logger;
import util.ThreadUtil;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static util.ThreadUtil.sleep;
import static util.TookTimeUtil.logTookTime;

/**
 * @description
 * @author: clt
 * @create: 2021-04-11 12:57
 **/
public class CompletionTest {

    private static final Logger LOGGER = LogUtil.getLogger(CompletionTest.class);

    private static final ExecutorService executor = ThreadUtil.getDefaultExecutor();

    private static final Supplier<Long> SUPPLIER_TASK = () -> {
        double random = Math.random();
        long second = (long) (random * 10 / 3);
        LOGGER.info("SUPPLIER_TASK, this thread will sleep {} s", second);
        sleep(second, true);
        if (true){
            throw new RuntimeException();
        }
        return second;
    };

    private static final Runnable RUNNABLE_TASK = () -> {
        double random = Math.random();
        long second = (long) (random * 10 / 3);
        LOGGER.info("RUNNABLE_TASK, this thread will sleep {} s", second);
        sleep(second, true);
    };

    private static final Function<Long, Long> FUNCTION_TASK = (second) -> {
        LOGGER.info("FUNCTION_TASK, this thread will sleep {} s", second);
        sleep(second, true);
        return second;
    };

    private static final Consumer<Long> CONSUMER_TASK = (second) -> {
        LOGGER.info("CONSUMER_TASK, this thread will sleep {} s", second);
        sleep(second, true);
    };


    public static void main(String[] args) {
        // logTookTime(CompletionTest::test2);
        // logTookTime(CompletionTest::test3);
        // logTookTime(CompletionTest::test4);
        // logTookTime(CompletionTest::test5);
        // logTookTime(CompletionTest::test6);
        // logTookTime(CompletionTest::test7);
        logTookTime(CompletionTest::test7);

    }

    private static void test8() {
    }

    private static void test7() {
        // 当需要查询的结果集不相互依赖时， 则耗时只取决于 耗时最长的任务
        // 此处共有 6步是异步之心， supplyAsync 和 thenCombineAsync
        // Math::addExact 是异步执行， 但它具有依赖性， 依赖于 CompletableFuture.supplyAsync 的两个结果
        // CompletableFuture.supplyAsync 无任何依赖性。
        // 也就是说下面 一共可以拆分成 6个步骤， 3个 supplyAsync 和3个 Math::addExact
        // Math::addExact 依赖于 CompletableFuture.supplyAsync， 所以外层的 Math::addExact
        // 依赖里层的 Math::addExact， 因为里层的 Math::addExact， 是 CompletableFuture.thenCombineAsync 的返回结果
        Long total = CompletableFuture.supplyAsync(SUPPLIER_TASK, executor)
                .thenCombineAsync(
                        CompletableFuture.supplyAsync(SUPPLIER_TASK, executor)
                                .thenCombineAsync(
                                        CompletableFuture.supplyAsync(SUPPLIER_TASK, executor)
                                                .thenCombineAsync(
                                                        CompletableFuture.supplyAsync(SUPPLIER_TASK, executor),
                                                        // 1
                                                        Math::addExact,
                                                        executor
                                                ),
                                        // 2
                                        Math::addExact,
                                        executor
                                ),
                        // 3
                        Math::addExact,
                        executor
                )
                // 实现自定义异常处理 优先级高于 exceptionally
                .handleAsync((t, e) -> {
                    if (e != null){
                        LOGGER.info("error", e);
                    }
                    return 1000L;
                }, executor)
                // 异常后的默认返回结果
                .exceptionally((e) -> 100L)
                .whenComplete((t, e) -> {
                    if (t != null){
                        LOGGER.info("the result is null");
                    }
                })
                // 覆盖值
                // .obtrudeValue(-1L)
                .join();
        LOGGER.info("it will took {}s whit normal", total);

    }

    private static void test6() {

        // CompletableFuture then 相关测试，用于多异步查询结果存在先后依赖
        String result = CompletableFuture.supplyAsync(SUPPLIER_TASK, executor)
                .thenApplyAsync(FUNCTION_TASK, executor)
                .thenApply(val -> val)
                .thenAcceptAsync(CONSUMER_TASK, executor) // Void
                .thenAccept(void_ -> LOGGER.info("thenAccept, val is{},", void_)) // Void
                // 转机, 重新返回一个新的 CompletionStage， 和 thenApply 类似
                .thenCompose(void_ -> CompletableFuture.completedFuture("thenCompose"))
                .thenAcceptBothAsync(
                        CompletableFuture.supplyAsync(() -> "thenAcceptBoth", executor),
                        (first, second) -> {
                            LOGGER.info("first == thenCompose ? {}, second == thenAcceptBoth ?  {}", "thenCompose".equals(first), "thenAcceptBoth".equals(second));
                        },
                        executor
                )
                .thenRunAsync(() -> LOGGER.info("thenRunAsync"), executor)
                .thenRun(() -> LOGGER.info("thenRun"))
                .thenComposeAsync(void_ -> CompletableFuture.completedFuture("thenComposeAsync"), executor)
                .thenCombine(
                        CompletableFuture.completedFuture("thenCombine"),
                        (item1, item2) -> {
                            LOGGER.info("item1 == thenComposeAsync ? {}, item2 == thenCombine ?  {}", "thenComposeAsync".equals(item1), "thenCombine".equals(item2));
                            return "thenCombine-result";
                        }
                )
                .join();
        LOGGER.info("result == thenCombine-result ?; {}", "thenCombine-result".equals(result));
    }


    private static void test5() {
        CompletableFuture.completedFuture(11).join();
    }

    /**
     * 并发执行 耗时 2s
     */
    private static void test1() {
        LOGGER.info("test1 starting");
        List<String> list = CompletableFuture.supplyAsync(() -> {
            sleep(2, true);
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(
                () -> {
                    sleep(1, true);
                    return "world";
                }),
                (str1, str2) -> Stream.of(str1, str2).collect(Collectors.toList())
        ).join();
        LOGGER.info("list, {}", list);
        LOGGER.info("test1 ending");
    }

    /**
     * 非并发执行 耗时 3s
     */
    private static void test2() {
        Long second = CompletableFuture.supplyAsync(SUPPLIER_TASK, executor)
                .thenCombine(
                        CompletableFuture.supplyAsync(SUPPLIER_TASK, executor),
                        (num1, num2) -> Stream.of(num1, num2).reduce(Math::addExact).orElse(0L)
                ).join();
        LOGGER.info("it will took {}s whit normal", second);
    }

    private static void test3() {
        // Returns a new CompletableFuture<Void> if the all CompletionStage is finished
        // 多个任务异步执行， 依赖于这些任务都执行完成后才可继续执行
        CompletableFuture.allOf(
                CompletableFuture.runAsync(RUNNABLE_TASK, executor),
                CompletableFuture.runAsync(RUNNABLE_TASK, executor),
                CompletableFuture.runAsync(RUNNABLE_TASK, executor),
                CompletableFuture.runAsync(RUNNABLE_TASK, executor),
                CompletableFuture.runAsync(RUNNABLE_TASK, executor)
        ).join();
    }


    private static void test4() {
        // Returns a new CompletableFuture<Void> if the any one CompletionStage is finished
        // 多个任务异步执行， 依赖于任一任务执行完成后可继续执行
        CompletableFuture.anyOf(
                CompletableFuture.runAsync(RUNNABLE_TASK, executor),
                CompletableFuture.runAsync(RUNNABLE_TASK, executor),
                CompletableFuture.runAsync(RUNNABLE_TASK, executor),
                CompletableFuture.runAsync(RUNNABLE_TASK, executor)
        ).join();

    }

}
