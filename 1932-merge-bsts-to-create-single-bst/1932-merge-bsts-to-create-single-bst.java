class Solution {

    HashMap<Integer, TreeNode> map = new HashMap<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        // 1. Store every tree root
        for (TreeNode root : trees) {
            map.put(root.val, root);
        }

        // 2. Find the root of the final BST
        HashSet<Integer> leaves = new HashSet<>();

        for (TreeNode root : trees) {

            if (root.left != null) {
                leaves.add(root.left.val);
            }

            if (root.right != null) {
                leaves.add(root.right.val);
            }
        }

        TreeNode root = null;

        for (TreeNode node : trees) {

            // This root is not a child of any other root
            if (!leaves.contains(node.val)) {

                if (root != null) {
                    return null; // More than one possible root
                }

                root = node;
            }
        }

        if (root == null) {
            return null;
        }

        // We already used the final root
        map.remove(root.val);

        // 3. Merge trees + validate BST
        if (!merge(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return null;
        }

        // 4. If some trees are unused, merging failed
        if (!map.isEmpty()) {
            return null;
        }

        return root;
    }

    private boolean merge(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        // Check BST property
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // If node is a leaf
        if (node.left == null && node.right == null) {

            // Is there another BST whose root has this value?
            if (map.containsKey(node.val)) {

                TreeNode tree = map.remove(node.val);

                // Attach the new BST
                node.left = tree.left;
                node.right = tree.right;
            }
        }

        // Check left and right subtree
        return merge(node.left, min, node.val)
            && merge(node.right, node.val, max);
    }
}