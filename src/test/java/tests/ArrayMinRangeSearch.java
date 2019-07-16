package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayMinRangeSearch {

    /**
     * There is an array with prices per day
     * Need to find max falling for N days (range param)
     * 
     * @param pricesPerDay
     * @param range
     * @return
     */
    public int findMaxFalling(int[] pricesPerDay, int range) {
        int lengthOfArray = pricesPerDay.length;
        int maxFall = 0;
        if (range <= lengthOfArray) {
            for (int firstPriceIndexInRange = 0; firstPriceIndexInRange < lengthOfArray; firstPriceIndexInRange ++) {
                int firstPrice = pricesPerDay[firstPriceIndexInRange];
                int lastPriceIndex = firstPriceIndexInRange + range;
                if (lastPriceIndex > lengthOfArray) {
                    //here we will not consider ranges less than range
                    //lastPriceIndex = maxIndex;
                    break;
                }
                for (int otherPriceIndex = firstPriceIndexInRange; otherPriceIndex < lastPriceIndex; otherPriceIndex ++) {
                    int anotherPrice = pricesPerDay[otherPriceIndex];
                    int diff = firstPrice - anotherPrice;
                    if (diff > maxFall) {
                        maxFall = diff;
                    }
                }
            }
        } else {
            //return 0 if range is more than the array itself
            return 0;
        }
        return maxFall;
    }
    
    @DataProvider(name = "checkMinFallingInArrayRange")
    public Object[][] createData() {
        return new Object[][] {
                { new TestData(new int[]{30, 20, 10}, 3, 20)},
                { new TestData(new int[]{30, 20, 10}, 2, 10)},
                { new TestData(new int[]{30, 20, 10}, 4, 0)},
                { new TestData(new int[]{1, 2, 3}, 3, 0)},
                { new TestData(new int[]{30, 26, 21, 14}, 3, 12)},
                { new TestData(new int[]{128, 12, 26, 55, 123, 21, 223, 23000, 1}, 3, 222)},
                { new TestData(new int[]{100, 90, 91, 20}, 3, 70)},
        };
    }

    @Test(dataProvider = "checkMinFallingInArrayRange")
    public void checkMinFallingInArrayRange(TestData data) {
        assertEquals(findMaxFalling(data.getPriceArray(), data.getRange()), data.getExpectedFalling());
    }
}
