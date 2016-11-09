import java.util.ArrayList;

public class BinarySearchTreeNode<E extends Comparable<E>> {
	private E elt;
	private BinarySearchTreeNode<E> left;
	private BinarySearchTreeNode<E> right;
	private E node;
	
	public BinarySearchTreeNode<E> getLeft(){
		return left;
	}

	public BinarySearchTreeNode<E> getRight(){
		return right;
	}
	
	public void order(Visitor v){
		v.visit(this);
	}
	
	public void add(E elt) {
		if (this.elt.compareTo(elt) > 0) {
			if (left == null) {
				left = new BinarySearchTreeNode<E>(elt);
			} else {
				left.add(elt);
			}
		} else if (this.elt.compareTo(elt) < 0) {
			if (right == null) {
				right = new BinarySearchTreeNode<E>(elt);
			} else {
				right.add(elt);
			}
		}
	}

	public boolean contains(E elt) {
		int status = this.elt.compareTo(elt);
		if (status == 0) {

			return true;
		} else if (status > 0) {
			if (left != null) {

				return left.contains(elt);
			} else {
				return false;
			}
		} else if (status < 0) {
			if (right != null) {

				return right.contains(elt);
			} else {

				return false;
			}
		}
		return false;
	}

	public void display() {
		if (left != null) {
			left.display();
		}

		System.out.println(elt.toString());

		if (right != null) {
			right.display();
		}
	}

	public BinarySearchTreeNode(E elt) {
		this.elt = elt;
	}

	public BinarySearchTreeNode<E> findNode(BinarySearchTreeNode<E> root, BinarySearchTreeNode<E> previous, E elt) {
		BinarySearchTreeNode<E> find = root;

		if (find.contains(elt)) {

			if (elt.compareTo(find.getElt()) == 0) {
				return previous;
			} else if (elt.compareTo(find.getElt()) > 0) {
				previous = find;
				return findNode(find.right, previous, elt);
			} else {
				previous = find;
				return findNode(find.left, previous, elt);
			}
		}

		return null;
	}

	public void delete(BinarySearchTreeNode<E> root, E elt) {
		BinarySearchTreeNode<E> node = findNode(root, null, elt);
		// System.out.println(node.getElt());
		if (node.left != null) {
			if (node.left.getElt().compareTo(elt) == 0) {
				BinarySearchTreeNode<E> buff = node.left;
				node.left = findLeft(node.left);
				node.left = buff.left;
				node.right = buff.right;
			}
		}
		if (node.right != null) {
			if (node.right.getElt().compareTo(elt) == 0) {
				BinarySearchTreeNode<E> buff = node.right;
				node.right = findRight(node.right);
				node.right = buff.right;
				node.left = buff.left;
			}
		}

	}

	public BinarySearchTreeNode<E> findLeft(BinarySearchTreeNode<E> node) {
		if (node.right != null) {
			node = node.right;
		}

		return node;
	}

	public BinarySearchTreeNode<E> findRight(BinarySearchTreeNode<E> node) {
		if (node.left != null) {
			node = node.left;
		}

		return node;
	}

	public E getElt() {
		return this.elt;
	}
	
	
	public ArrayList<E> treeSort() {
		ArrayList<E> johnnyBoy = new ArrayList<E>();
		
		this.order(new ArrayListVisitor(johnnyBoy));
		
		return johnnyBoy;

	}

}
