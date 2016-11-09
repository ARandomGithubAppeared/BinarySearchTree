
public class InOrderVisitor implements Visitor {
	
	@Override
	public void visit(BinarySearchTreeNode node) {

		if (node.getLeft() != null) {
			visit(node.getLeft());
		}
		System.out.println(node.getElt());
		if (node.getRight() != null) {
			visit(node.getRight());
		}
	}
}
