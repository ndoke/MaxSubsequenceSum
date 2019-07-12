package com.training;

/**
 * {@link MaxSubsequenceSum} has methods to calculate the maximum
 * sub-sequence sum of any given integer array.
 * {@link MaxSubsequenceSum#findMaxSubsequenceSumUsingBruteForce(int[])}
 * calculates the maximum sub-sequence sum of any given array using
 * a brute force approach while the other method
 * {@link MaxSubsequenceSum#findMaxSubsequenceSumUsingBruteForce(int[])}
 * calculates the same in an efficient way.
 * {@link MaxSubsequenceSum#findMaxSubsequenceSumUsingDivideNConquer(int[], int, int)}
 * calculates the same using a divide and conquer approach.
 *
 * @author Nachiket Doke
 * @since 1.0
 */
public class MaxSubsequenceSum {
    /**
     * Returns the maximum sub-sequence sum of the given integer array in an
     * efficient way.
     *
     * @param anInput integer array
     * @return maximum sub-sequence sum of the given integer array
     */
    public int findMaxSubsequenceSum(int anInput[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < anInput.length; i++) {
            currSum += anInput[i];
            if (currSum > maxSum) { //if the current sum  is greater than max sum
                maxSum = currSum; // set maxSum to current sum
            } else if (currSum < 0) {
                currSum = 0; // if the current sum goes below 0, it is set to 0 again
            }
        }

        return maxSum;
    }

    /**
     * Returns the maximum sub-sequence sum of the given integer array using
     * a brute force approach.
     *
     * @param anInput integer array
     * @return maximum sub-sequence sum of the given integer array
     */
    public int findMaxSubsequenceSumUsingBruteForce(int[] anInput) {
        int maxSum = Integer.MIN_VALUE;
        int currSum;

        for (int i = 0; i < anInput.length; i++) {
            currSum = 0;
            for (int j = i; j < anInput.length; j++) {
                currSum += anInput[j];
                if (currSum > maxSum) { // if the current sum  is greater than max sum
                    maxSum = currSum; // set maxSum to current sum
                }
            }
        }

        return maxSum;
    }

    private int maxCrossingSum(int anInput[], int start, int mid, int end) {
        int currSum = 0;
        int maxSumLeft = Integer.MIN_VALUE;
        for (int i = mid; i >= start; i--) { // calculate maxSum from mid to the left direction
            currSum = currSum + anInput[i];
            if (currSum > maxSumLeft)
                maxSumLeft = currSum;
        }

        currSum = 0;
        int maxSumRight = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= end; i++) { // calculate maxSum from mid to the right direction
            currSum = currSum + anInput[i];
            if (currSum > maxSumRight)
                maxSumRight = currSum;
        }

        return maxSumLeft + maxSumRight; // sum of both maximum sums will be the required maxSum
    }

    /**
     * Returns the maximum sub-sequence sum of the given integer array using a
     * Divide and conquer approach.
     *
     * @param anInput integer array
     * @param start first index of the array
     * @param end end index of the array
     * @return maximum sub-sequence sum of the given integer array
     */
    public int findMaxSubsequenceSumUsingDivideNConquer(int anInput[], int start, int end) {
        if (anInput.length == 0) {
            return Integer.MIN_VALUE;
        }

        if (start == end) {
            return anInput[start];
        }

        int mid = (start + end) / 2;

        return Math.max(Math.max(findMaxSubsequenceSumUsingDivideNConquer(anInput, start, mid), // recursive call to find max sum of the left part of the array
                findMaxSubsequenceSumUsingDivideNConquer(anInput, mid + 1, end)), // recursive call to find max sum of the right part of the array
                maxCrossingSum(anInput, start, mid, end)); // calculate the max sum for entire array
    }
}
