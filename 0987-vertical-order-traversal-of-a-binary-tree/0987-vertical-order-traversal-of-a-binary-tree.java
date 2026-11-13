/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // column -> row -> node values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
            new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> nodes : rows.values()) {

                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }

            result.add(column);
        }

        return result;
    }
}

class Pair {
    TreeNode node;
    int row;
    int col;

    Pair(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
