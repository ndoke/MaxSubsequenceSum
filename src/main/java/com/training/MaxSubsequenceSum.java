package com.training;

/**
 * {@link MaxSubsequenceSum} has methods to calculate the maximum
 * sub-sequence sum of any given integer array.
 * {@link MaxSubsequenceSum#findMaxSubsequenceSumUsingBruteForce(int[])}
 * calculates the maximum sub-sequence sum of any given array using
 * a brute force approach while the other method
 * {@link MaxSubsequenceSum#findMaxSubsequenceSumUsingBruteForce(int[])}
 * calculates the same in an efficient way.
 *
 * @author  Nachiket Doke
 * @since   1.0
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
}
