import java.util.ArrayList;

public class ArrayListVisitor implements Visitor{
	private ArrayList elts;
	public ArrayListVisitor(ArrayList elts){
		this.elts=elts;
	}
	
	@Override
	public void visit(BinarySearchTreeNode node) {
		if (node.getLeft() != null) {
			visit(node.getLeft());
		}
		elts.add(node.getElt());
		if (node.getRight() != null) {
			visit(node.getRight());
		}
	}
	
	public ArrayList getArray(){
		return elts;
	}

}
