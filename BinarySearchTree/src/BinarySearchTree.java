
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchTree<E extends Comparable<E>> {

	public BinarySearchTreeNode<E> root;

	public void delete(E elt) {
		if (root != null) {
			root.delete(root, elt);
		}

	}

	// public int compare(E elt) {
	// return root.compare(elt);
	// }

	public void add(E elt) {
		if (root == null) {
			root = new BinarySearchTreeNode<E>(elt);
		} else {
			root.add(elt);
		}
	}

	public boolean contains(E elt) {
		return root.contains(elt);
	}
	public void order(Visitor v){
		if (root!= null){
			root.order(v);
		}
	}

	public void display() {
		if (root!= null){
		root.display();
		}
	}

	public ArrayList treesort(){
		return root.treeSort();
	}
	
	public static void main(String[] args) {

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		Scanner scan = new Scanner(System.in);
		for (int x=0;x<20;x++){
			tree.add((int)Math.floor(100*Math.random()));
		}
		System.out.println(tree.root.getElt());
		System.out.println("PreOrder:");
		tree.order(new PreOrderVisitor());
		System.out.println("InOrder:");
		tree.order(new InOrderVisitor());
		System.out.println("PostOrder:");
		tree.order(new PostOrderVisitor());
		System.out.println("ArrayList");
		Object[] array;
		array=tree.treesort().toArray();
		for (int x=0;x<array.length;x++){
			System.out.println(array[x]);
		}
		
		
		while(scan.hasNext()){
			if(tree.contains(scan.nextInt())){
				System.out.println("It's here");
			}else{
				System.out.println("It's not here");
			}
			
		}
		
		
	

	}

}