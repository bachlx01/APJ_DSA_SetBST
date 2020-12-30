public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }


    @Override
    public boolean insert (E e) {
        if (root == null) {
            root = new TreeNode<>(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> temp = root;
            while (temp != null) {
                if (e.compareTo(temp.value) < 0) {
                    parent = temp;
                    temp = temp.left;
                } else  if (e.compareTo(temp.value) > 0) {
                    parent = temp;
                    temp = temp.right;
                } else return false;
            }
            if (e.compareTo(parent.value) < 0) {
                parent.left = new TreeNode<>(e);
            } else
                parent.right = new TreeNode<>(e);
        }
        size ++;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inOder() {
        inOder(root);
    }
    protected void inOder(TreeNode root) {
        if (root != null) {
            inOder(root.left);
            System.out.print(root.value + " - ");
            inOder(root.right);
        }
    }

    public boolean search(E e) {
        boolean search = false;
        TreeNode<E> temp = root;
        while (temp != null) {
            if (e.compareTo(temp.value) == 0) {
                search = true;
                break;
            } else if (e.compareTo(temp.value) > 0) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return search;
    }
}
