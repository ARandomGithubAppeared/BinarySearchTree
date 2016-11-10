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
		BinarySearchTreeNode<E> parent = node;
		BinarySearchTreeNode<E> childBuff = null;
		if (node != null) {
			if (node.left != null && node.left.getElt() == elt) {
				node = node.left;
				System.out.println("left");
				if (node.left != null && node.right == null) {
					node = node.left;
					parent.left = node;
				}
				if (node.left == null && node.right != null) {
					node = node.right;
					parent.left = node;
				}
				if (node.left == null && node.right == null) {
					parent.left = null;
				}
				if (node.left!=null && node.right != null){
					childBuff=node;
					node=findRight(node.left);					
					BinarySearchTreeNode<E> righty=null;
					righty=findNode(parent,null,node.getElt());
				    righty.left=null;
					node.right=childBuff.right;
					node.left=childBuff.left;
					parent.left=node;

					System.out.println(righty.getElt());
					
				//	parent.right=righty;
				}
			} else if (node.right != null && node.right.getElt() == elt) {
				node = node.right;
				System.out.println("right");
				if (node.left != null && node.right == null) {
					node = node.left;
					parent.right = node;
				}
				if (node.left == null && node.right != null) {
					node = node.right;
					parent.right = node;
				}
				if (node.left == null && node.right == null) {
					parent.right=null;
				}
				if (node.left!=null && node.right != null){
					childBuff=node;
					node=findLeft(node.left);					
					BinarySearchTreeNode<E> righty=null;
					righty=findNode(parent,null,node.getElt());
				    righty.right=null;
					node.right=childBuff.right;
					node.left=childBuff.left;
					parent.right=node;

					System.out.println(righty.getElt());
					
				//	parent.right=righty;
				}
			}

		}

	}

	public BinarySearchTreeNode<E> findLeft(BinarySearchTreeNode<E> node){
		BinarySearchTreeNode<E> buff = node;


		
		if (buff.right != null) {
			buff = findLeft(buff.right);
		}

	//	System.out.println(par.getElt());
		return buff;
	}
	public BinarySearchTreeNode<E> findRight(BinarySearchTreeNode<E> node){
		BinarySearchTreeNode<E> buff = node;


		
		if (buff.left != null) {
			buff = findLeft(buff.left);
		}

	//	System.out.println(par.getElt());
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
