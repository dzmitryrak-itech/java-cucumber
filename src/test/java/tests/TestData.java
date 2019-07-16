package tests;

public class TestData {
    int[] priceArray;
    int range;

    public int getExpectedFalling() {
        return expectedFalling;
    }

    public void setExpectedFalling(int expectedFalling) {
        this.expectedFalling = expectedFalling;
    }

    int expectedFalling; 
    
    public TestData(int[] priceArray, int range, int expectedFalling) {
        this.priceArray = priceArray;
        this.range = range;
        this.expectedFalling = expectedFalling;
    }

    public int[] getPriceArray() {
        return priceArray;
    }

    public void setPriceArray(int[] priceArray) {
        this.priceArray = priceArray;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
