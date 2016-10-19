
public class BinarySearchTree<E extends Comparable>{ 
	private class BinarySearchTreeNode<E extends Comparable>{
		private E elt;
		private BinarySearchTreeNode<E> left;
		private BinarySearchTreeNode<E> right;
	
		public void add(E elt){
			if (this.elt.compareTo(elt)<0){
				if (left==null){
					left = new BinarySearchTreeNode(elt);
				}else{
					left.add(elt);
				}
			}else if(this.elt.compareTo(elt)>0){
				if(right==null){
					right = new BinarySearchTreeNode(elt);
				}else{
					right.add(elt);
				}
			}
		}
		
		public boolean contains(E elt){
			if(this.elt == elt){
				return true;
			}else if (this.elt.compareTo(elt)<0){
				left.contains(elt);
			}else if(this.elt.compareTo(elt)>0){
				right.contains(elt);
			}
			return false;
		}
		public void display(){
			if (left != null){
				left.display();
			}
			
			System.out.println(elt.toString());
			
			if (right != null){
				right.display();
			}
		}
		
		public BinarySearchTreeNode(E elt){
			this.elt=elt;
		}
	
	}
	
	private int size;
	private BinarySearchTreeNode root;
	
	public BinarySearchTree(E elt){
		BinarySearchTreeNode root = new BinarySearchTreeNode(elt);
		size=1;
	}
	
	public void add(E elt){
		root.add(elt);
	}

	public boolean contains(E elt){
		return root.contains(elt);
	}

	public void display(){
		root.display();
	}
}
