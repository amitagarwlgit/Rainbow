package algo.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuySellStocksTest {
    private BuySellStocks buySellStocks = new BuySellStocks();

    @Test
    void testBuySellStocks() {
        Assertions.assertEquals(buySellStocks.maxProfit(new int[]{}), 0);
        Assertions.assertEquals(buySellStocks.maxProfit(new int[]{7}), 0);
        Assertions.assertEquals(buySellStocks.maxProfit(new int[]{7, 5}), 0);
        Assertions.assertEquals(buySellStocks.maxProfit(new int[]{5, 7}), 2);
        Assertions.assertEquals(buySellStocks.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
        Assertions.assertEquals(buySellStocks.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
        Assertions.assertEquals(buySellStocks.maxProfit(new int[]{2, 4, 1}), 2);
    }
}