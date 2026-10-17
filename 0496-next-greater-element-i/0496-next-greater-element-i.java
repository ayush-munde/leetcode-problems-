
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int span[] = new int[nums2.length];
        span[nums2.length - 1] = -1;

        Stack<Integer> s = new Stack<>();
        s.push(nums2[nums2.length - 1]);

        int i = nums2.length - 2;

        while (i >= 0) {

            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = -1;
            } else {
                span[i] = s.peek();
            }

            s.push(nums2[i--]);
        }

        int span2[] = new int[nums1.length];

        for (i = 0; i < nums1.length; i++) {
            int j = 0;

            while (j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    break;
                }
                j++;
            }

            span2[i] = span[j];
        }

        return span2;
    }
}
