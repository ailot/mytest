package com.ailot.avl;

public class AVLTree<T extends Comparable<T>> {

    private AVLTreeNode<T> mRoot;

    class AVLTreeNode<T extends Comparable<T>> {
        T key;
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.height = 0;
            this.left = left;
            this.right = right;
        }
    }

    public AVLTree() {
        this.mRoot = null;
    }

    /**
     * 获取树的高度
     *
     * @param tree
     * @return
     */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }
        return 0;
    }

    private int height() {
        return height(mRoot);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 前序遍历AVL树
     *
     * @param tree
     */
    private void preOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            System.out.println(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 中序遍历
     *
     * @param tree
     */
    private void inOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /**
     * 后续遍历
     *
     * @param tree
     */
    private void postOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /**
     * 递归查找树中的节点
     *
     * @param node
     * @param key
     * @return
     */
    private AVLTreeNode<T> search(AVLTreeNode<T> node, T key) {
        if (node == null) {
            return node;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return search(node.left, key);
        } else if (cmp > 0) {
            return search(node.right, key);
        } else {
            return node;
        }
    }

    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * 非递归实现树节点查找
     *
     * @param node
     * @param key
     * @return
     */
    private AVLTreeNode<T> iterativeSearch(AVLTreeNode<T> node, T key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public AVLTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 查找最小节点
     *
     * @param node
     * @return
     */
    private AVLTreeNode<T> minimun(AVLTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public T minimun() {
        AVLTreeNode<T> node = minimun(mRoot);
        if (node != null) {
            return node.key;
        }
        return null;
    }

    /**
     * 查找最大节点
     *
     * @param node
     * @return
     */
    private AVLTreeNode<T> maxmun(AVLTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public T maxmun() {
        AVLTreeNode<T> node = minimun(mRoot);
        if (node != null) {
            return node.key;
        }
        return null;
    }

    /**
     * LL:左单旋转
     * @param k2
     * @return
     */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left),k2.height) + 1;
        return k1;
    }
}
