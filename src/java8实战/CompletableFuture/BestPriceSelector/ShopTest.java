package java8实战.CompletableFuture.BestPriceSelector;

import java.util.Arrays;
import java.util.List;

/**
 * @author clt
 * @create 2020/7/26 18:55
 */
public class ShopTest {
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
        Shop shop = new Shop("Test");
        System.out.println(shop.findPrices(shops, "BuyItAll"));
        System.out.println(shop.findPricesAsyncByParallelStream(shops, "BuyItAll"));
        System.out.println(shop.findPricesAsyncByCompletableFuture(shops, "BuyItAll"));

    }
}
