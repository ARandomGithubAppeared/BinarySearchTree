import java.util.ArrayList;

public class BinarySearchTreeNode<E extends Comparable<E>> {
	private E elt;
	private BinarySearchTreeNode<E> left;
	private BinarySearchTreeNode<E> right;
	private E node;

	public BinarySearchTreeNode<E> getLeft() {
		return left;
	}

	public BinarySearchTreeNode<E> getRight() {
		return right;
	}

	public void order(Visitor v) {
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
		BinarySearchTreeNode<E> buff = node;
		boolean left=false;
		if(node.left.getElt()==elt){
			left=true;
			node=node.left;
			buff.left=null;
		}
		if(node.right.getElt()==elt){
			node=node.right;
			buff.right=null;
		}
		if((node.right != null && node.left==null )||( node.right == null && node.left != null)){
			if(node.right!=null){
				if(left==true){
					if(node.left!=null){
						buff.left=node.left;
					}else{
						buff.left=node.right;
					}
				}else{
				    if(node.right!=null){
				    	buff.right=node.right;
				    }else{
				    	buff.right=node.left;
				    }
				}
			}
		}
	

	}

	public BinarySearchTreeNode<E> findLeft(BinarySearchTreeNode<E> node) {
		BinarySearchTreeNode<E> buff = node;
		if (buff.right != null) {
			buff = buff.right;
		}

		return buff;
	}

	public BinarySearchTreeNode<E> findRight(BinarySearchTreeNode<E> node) {
		BinarySearchTreeNode<E> buff = node;
		if (buff.left != null) {
			buff = buff.left;
		}

		return buff;
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
