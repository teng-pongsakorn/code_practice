package easy;

public class BestTimeToBuyAndSellStock {
    public static int maxProfitMultipleTransactions(int[] prices) {
        int total = 0;
        for (int i=1; i<prices.length; i++) {
            int profit = prices[i] - prices[i-1];
            if (profit > 0) {
                total += profit;
            }
        }
        return total;
    }
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price > minPrice) {
                max = Math.max(max, price - minPrice);
            }
        }
        return max;
    }

    public static int maxProfit_v2(int[] prices) {
        int iMin = 0;
        int iMax = 0;
        int max = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < prices[iMin] || iMin > iMax) {
                iMin = i;
            }
            if (prices[i] >= prices[iMax] || iMin > iMax) {
                iMax = i;
            }
            if (iMin < iMax) {
                max = Math.max(max, prices[iMax]-prices[iMin]);
            }
        }
        return max;
    }


    public static int maxProfit_v1(int[] prices) {
        int max = 0;
        for (int i=0; i<prices.length-1; i++) {
            for (int j=i; j<prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        System.out.println(BestTimeToBuyAndSellStock.maxProfit(prices));
        System.out.println(BestTimeToBuyAndSellStock.maxProfitMultipleTransactions(prices));
        prices = new int[] {7,6,4,3,1};
//        System.out.println(BestTimeToBuyAndSellStock.maxProfit(prices));
        System.out.println(BestTimeToBuyAndSellStock.maxProfitMultipleTransactions(prices));
        prices = new int[] {1, 2};
//        System.out.println(BestTimeToBuyAndSellStock.maxProfit(prices));
        prices = new int[] {1, 100000, 23, 4352, 1341, 33243, 5432, 980, 9, 234, 342, 99999};
//        System.out.println(BestTimeToBuyAndSellStock.maxProfit(prices));
        prices = new int[] {2,1,2,1,0,0,1};
//        System.out.println(BestTimeToBuyAndSellStock.maxProfit(prices));
        System.out.println(BestTimeToBuyAndSellStock.maxProfitMultipleTransactions(prices));
    }
}
