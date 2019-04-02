package ueb02;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {

    // Node representation as inner class
    class Node {

        String value;
        Node left, right;

        /**
         * Creates a new object of type Node.
         *
         * @param value
         * @param left
         * @param right
         */
        Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * Returns the size of this sub tree.
         *
         * @return
         */
        int size () {
            int s = 1;

            if (left != null)
                s += left.size();

            if (right != null)
                s += right.size();

            return s;
        }

        boolean add(String s) {
            if (s.compareTo(value) < 0) {
                    if(left != null)
                        return left.add(s);
                    left = new Node(s, null, null);
                    return true;
            }
            if (s.compareTo(value) > 0) {
                if(right != null)
                    return right.add(s);
                right = new Node(s, null, null);
                return true;
            }
            return false;
        }

        /**
         * Check if this subtree contains s.
         *
         * @param s
         * @return
         */
        boolean contains(String s) {
            if (s.compareTo(value) == 0)
                return true;

            if (s.compareTo(value) < 0) {
                if(left != null)
                    return left.contains(s);
            }
            if (s.compareTo(value) > 0) {
                if(right != null)
                    return right.contains(s);
            }

            return false;
        }

        /**
         *
         * @param s
         * @return
         */
        Node checkSubTrees(String s){

            Node elem = checkNode(this.left,s);
            if (elem == null) {
                elem = checkNode(this.right, s);
            }
            if (elem != null) {
                if (elem.right != null) {
                    Node prev = elem;
                    Node it = elem.right;
                    while (it.left != null) {
                        prev = it;
                        it = it.left;
                    }
                    prev.left = null;
                    it.left = elem.left;
                    it.right = elem.right;
                    this.right = it;
                }
                this.left = elem.left;
            }

            return  elem;
        }

        private Node checkNode(Node node, String s) {
            if (node == null)
                return null;

            if (node.value.compareTo(s) == 0) {
                return node;
            }
            return node.checkSubTrees(s);
        }

        /**
         * Returns the string representation of this element.
         * @return value and subtrees
         */
        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // root element
    private Node root;

    /**
     * Adds a new element to the set. Returns true if successful
     * otherwise false.
     *
     * @param s Value to be added
     * @return True if add was successful otherwise false.
     */
    @Override
    public boolean add(String s) {
        //  check if root is null
        if (root == null) {
            root = new Node(s, null, null);
            return true;
        }
        // otherwise add to substree
        return root.add(s);
    }

    /**
     * Checks if set contains value s.
     *
     * @param s
     * @return Returns true if set contains value otherwise false
     */
    @Override
    public boolean contains(String s) {
        if (root == null)
            return false;

        return root.contains(s);
    }

    /**
     * Removes s from set.
     *
     * @param s
     * @return
     */
    @Override
    public String remove(String s) {
        if (root == null)
            throw new NoSuchElementException();

        Node result = root.checkSubTrees(s);
        if (result == null)
            throw  new NoSuchElementException();

        return result.value;
    }

    /**
     * Returns number of elements in set.
     *
     * @return
     */
    @Override
    public int size() {
        if (root == null)
            return 0;

        return root.size();
    }

    /**
     * Returns the string representation.
     *
     * @return
     */
    @Override
    public String toString() {
        return "StringSetImpl{" +
                "root=" + root +
                '}';
    }
}
