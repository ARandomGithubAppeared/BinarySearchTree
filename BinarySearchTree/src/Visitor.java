
public interface Visitor<E extends Comparable<E>> {
	public void visit(BinarySearchTreeNode<E> n);
}
