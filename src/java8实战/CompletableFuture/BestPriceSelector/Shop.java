package java8实战.CompletableFuture.BestPriceSelector;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author clt
 * @create 2020/7/26 16:25
 */
public class Shop {

    private String name;

    private Random random = new Random(47);

    private static ExecutorService executor = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<>());

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 该方法的内部实现会查询商店的数据库，但也有可能执行一些其他耗时的任务，比如联系其
     * 他外部服务（比如，商店的供应商，或者跟制造商相关的推广折扣）。
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                '}';
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        executor.submit(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            }catch (IllegalArgumentException e){
                futurePrice.completeExceptionally(e);
            }
        });
        return futurePrice;
        //return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    /**
     * 依据产ֵ的名称，生成一个随机值作为价格。
     */
    private double calculatePrice(String product) {
        delay();
        if (product == null || product.length() < 2) {
            throw new IllegalArgumentException("商品格式错误");
        }
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 模拟1秒钟延迟的方法
     */
    public static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> findPrices(List<Shop> shops, String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public List<String> findPricesAsyncByParallelStream(List<Shop> shops, String product) {
        return shops.parallelStream()
                .map(shop -> {
                    try {
                        return String.format("%s price is %.2f",
                                shop.getName(), shop.getPriceAsync(product).get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(toList());
    }

    public List<String> findPricesAsyncByCompletableFuture(List<Shop> shops, String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " +
                                        shop.getPrice(product)))
                        .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }

    @Test
    public void testCalculatePrice() {
        double colaPrice = calculatePrice("cola");
        Assert.assertEquals(true, colaPrice > 0);
        try {
            calculatePrice("1");
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void testDelay() {
        long start = System.currentTimeMillis();
        delay();
        long end = System.currentTimeMillis();
        long costTime = end - start;
        Assert.assertEquals(true, costTime < 2000);
        Assert.assertEquals(true, costTime >= 1000);
    }

    @Test
    public void testGetPrice() {
        long start = System.currentTimeMillis();
        double colaPrice = getPrice("cola");
        long end = System.currentTimeMillis();
        long costTime = end - start;
        Assert.assertEquals(true, costTime < 2000);
        Assert.assertEquals(true, costTime >= 1000);
        Assert.assertEquals(true, colaPrice > 0);
    }

    @Test
    public void testGetPriceAsync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Future<Double> cola = getPriceAsync("cola");
        long end = System.currentTimeMillis();
        long costTime = end - start;
        Assert.assertEquals(true, costTime < 1000);
        Assert.assertEquals(true, cola.get() > 0);
    }

    public static void main(String[] args) {
        Shop shop = new Shop("Test");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("m");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        //doSomethingElse();
        try {
            double price = futurePrice.get(2, TimeUnit.SECONDS);
            System.out.printf("Price is %.2f%n", price);
        } catch (TimeoutException e){
            System.out.println("获取信息超时");
            throw new RuntimeException(e);
        } catch (IllegalArgumentException | InterruptedException | ExecutionException e){
            if (e.getCause() instanceof IllegalArgumentException){
                System.out.println(e.getMessage());
            }
            throw new RuntimeException(e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}
