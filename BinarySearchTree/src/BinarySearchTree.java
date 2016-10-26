import java.util.Scanner;

public class BinarySearchTree<E extends Comparable<E>>{ 
	private class BinarySearchTreeNode<E extends Comparable<E>>{
		private E elt;
		private BinarySearchTreeNode<E> left;
		private BinarySearchTreeNode<E> right;
	
		public void add(E elt){
			if (this.elt.compareTo(elt)>0){
				if (left==null){
					left = new BinarySearchTreeNode<E>(elt);
				}else{
					left.add(elt);
				}
			}else if(this.elt.compareTo(elt)<0){
				if(right==null){
					right = new BinarySearchTreeNode<E>(elt);
				}else{
					right.add(elt);
				}
			}
		}
		
		public boolean contains(E john){
			int status=elt.compareTo(john);
			if(status==0){
				return true;
			}else if (status>0){
				if (left !=null){
					left.contains(john);
				}else{
					return false;
				}
			}else if(status<0){
				if (right != null){
					right.contains(john);
				}else{
					return false;
				}
			}
			System.out.println("Status " +status);
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
		
	public int compare(E elt){
		return this.elt.compareTo(elt);
	}
	
	}
	

	private BinarySearchTreeNode<E> root;
	
	public BinarySearchTree(){
	}
	
	public int compare(E elt){
		return root.compare(elt);
	}
	
	public void add(E elt){
		if (root == null){
			root=new BinarySearchTreeNode<E>(elt);
		}else{
			root.add(elt);
		}
	}

	public boolean contains(E elt){
		return root.contains(elt);
	}

	public void display(){
		root.display();
	}


	
	public static void main(String[] args){
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()){
			int lol=scan.nextInt();
			tree.add(lol);
			System.out.println(tree.compare(lol));
		}
		tree.display();
		if (tree.contains(1)==true){
			System.out.println("5 is in the tree");
		}
		if (tree.contains(101)==false){
			System.out.println("101 is not in the tree");
		}
		
	}
	
	
}