package com.training;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxSubsequenceSumTest {
    private MaxSubsequenceSum maxSubsequenceSum = new MaxSubsequenceSum();
    private int arr1[] = {-1, -3, 5, -2, -1, 3, 1, -2};
    private int arr2[] = {2, -8, 3, -2, 4, -10};
    private int arr3[] = {- 3, -10, - 5};
    private int arr4[] = { };

    @Test
    public void calculateMaxSubsequenceSum() {
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSum(arr1), 6);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSumUsingBruteForce(arr1), 6);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSumUsingDivideNConquer(arr1, 0, arr1.length - 1), 6);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSum(arr2), 5);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSumUsingBruteForce(arr2), 5);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSumUsingDivideNConquer(arr2, 0, arr2.length - 1), 5);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSum(arr3), -3);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSumUsingBruteForce(arr3), -3);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSumUsingDivideNConquer(arr3, 0, arr3.length - 1), -3);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSum(arr4), Integer.MIN_VALUE);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSumUsingBruteForce(arr4), Integer.MIN_VALUE);
        Assert.assertEquals(maxSubsequenceSum.findMaxSubsequenceSumUsingDivideNConquer(arr4, 0, arr4.length - 1), Integer.MIN_VALUE);
    }
}
