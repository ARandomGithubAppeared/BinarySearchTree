
public class PostOrderVisitor implements Visitor{

	@Override
	public void visit(BinarySearchTreeNode node) {
		
		if (node.getLeft() != null) {
			visit(node.getLeft());
		}

		if (node.getRight() != null) {
			visit(node.getRight());
		}
		System.out.println(node.getElt());
	}

}
