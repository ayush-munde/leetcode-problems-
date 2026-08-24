class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            return root.val
                    + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }

        else if (root.val < low) {
            // Current value and left subtree are too small
            return rangeSumBST(root.right, low, high);
        }

        else {
            // Current value and right subtree are too large
            return rangeSumBST(root.left, low, high);
        }
    }
}