package node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class NamedNodeMapTest implements NamedNodeMap{
	protected TreeMap<String, Node> attributes;
	public NamedNodeMapTest() {
		attributes = new TreeMap<String, Node>();
	}
	@Override
	public Node getNamedItem(String name) {
		//System.out.println("find attribute " + name + ": " + attributes.get(name));
		return attributes.get(name);
	}

	@Override
	public Node setNamedItem(Node arg) throws DOMException {
		//System.out.println(arg.getNodeName() + ": " + arg);
		//System.out.println("set attribute: " + arg.getNodeName());
		attributes.put(arg.getNodeName(), arg);
		
		//test
//		System.out.println("Test :");
//		getNamedItem(arg.getNodeName());
		return arg;
	}

	@Override
	public Node removeNamedItem(String name) throws DOMException {
		return attributes.remove(name);
	}

	@Override
	public Node item(int index) {
		return new ArrayList<Node>(attributes.values()).get(index);
	}
	@Override
	public int getLength() {
		return attributes.size();
	}

	@Override
	public Node getNamedItemNS(String namespaceURI, String localName)
			throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node setNamedItemNS(Node arg) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node removeNamedItemNS(String namespaceURI, String localName)
			throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<Node> getItems(){
		return attributes.values();
	}

}
