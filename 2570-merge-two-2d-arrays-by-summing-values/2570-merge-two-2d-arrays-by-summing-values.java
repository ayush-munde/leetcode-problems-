class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int i = 0, j = 0, k = 0;

        int[][] result = new int[nums1.length + nums2.length][2];

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i][0] == nums2[j][0]) {
                result[k][0] = nums1[i][0];
                result[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            }
            else if (nums1[i][0] < nums2[j][0]) {
                result[k][0] = nums1[i][0];
                result[k][1] = nums1[i][1];
                i++;
            }
            else {
                result[k][0] = nums2[j][0];
                result[k][1] = nums2[j][1];
                j++;
            }

            k++;
        }

        // Remaining elements of nums1
        while (i < nums1.length) {
            result[k][0] = nums1[i][0];
            result[k][1] = nums1[i][1];
            i++;
            k++;
        }

        // Remaining elements of nums2
        while (j < nums2.length) {
            result[k][0] = nums2[j][0];
            result[k][1] = nums2[j][1];
            j++;
            k++;
        }

        return Arrays.copyOf(result, k);
    }
}