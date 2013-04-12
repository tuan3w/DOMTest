package node;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

public class AttributeNodeTest extends NodeTest {
	public AttributeNodeTest(String name) {
		super(name);
	}
	public AttributeNodeTest(String name, String value){
		super(name);
		setNodeValue(value);
	}
	@Override
	public String toString() {
		return nodeName + " = " + "\"" +nodeValue + "\"";
	}
	public Node appendChild(Node newChild) throws DOMException {
		throw new DOMException(DOMException.INVALID_ACCESS_ERR, "Node.ATTRIBUTE_NODE node could not have a child");
	}
	public Node insertBefore(Node newChild, Node refChild) throws DOMException {
		throw new DOMException(DOMException.INVALID_ACCESS_ERR, "Node.ATTRIBUTE_NODE node could not have a child");
	}
	public Node getFirstChild() {
		throw new DOMException(DOMException.INVALID_ACCESS_ERR, "Node.ATTRIBUTE_NODE node could not have a child");
	}
	
}
