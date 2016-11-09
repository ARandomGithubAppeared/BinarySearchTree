
public class PreOrderVisitor implements Visitor {

	@Override
	public void visit(BinarySearchTreeNode node) {
		System.out.println(node.getElt());
		if (node.getLeft() != null) {
			visit(node.getLeft());
		}

		if (node.getRight() != null) {
			visit(node.getRight());
		}
	}
}
