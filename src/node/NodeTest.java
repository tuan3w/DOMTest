package node;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;


public class NodeTest implements Node {
	protected String nodeName;
	protected short nodeType;
	protected String nodeValue;
	protected Node parentNode;
	protected NodeListTest childNodes;
	protected NamedNodeMapTest attributes;
	protected HashMap<String, Object> data;
	protected String baseURI;

	public NodeTest(String name) {
		nodeName = name;
		nodeType = ELEMENT_NODE; //default is element node
		nodeValue = null;
		childNodes = new NodeListTest();
		attributes = new NamedNodeMapTest();
		parentNode = null;
		baseURI = null;
	}
	@Override
	public String getNodeName() {
		return nodeName;
	}

	@Override
	public String getNodeValue() throws DOMException {
		return nodeValue;
	}

	@Override
	public void setNodeValue(String nodeValue) throws DOMException {
		this.nodeValue = nodeValue;
		
	}

	@Override
	public short getNodeType() {
		return nodeType;
	}

	@Override
	public Node getParentNode() {
		return parentNode;
	}

	@Override
	public NodeList getChildNodes() {
		return childNodes;
	}

	@Override
	public Node getFirstChild() {
		return childNodes.item(0);
	}

	@Override
	public Node getLastChild() {
		return childNodes.item(childNodes.getLength() -1);
	}

	@Override
	public Node getPreviousSibling() {
		if (parentNode == null)
			return null;
		ArrayList<Node> listChild = ((NodeListTest) parentNode.getChildNodes()).getItems();
		int id = listChild.indexOf(this);
		return listChild.get(id - 1);
	}

	@Override
	public Node getNextSibling() {
		if (parentNode == null)
			return null;
		ArrayList<Node> listChild = ((NodeListTest) parentNode.getChildNodes()).getItems();
		int id = listChild.indexOf(this);
		return listChild.get(id + 1);
	}

	@Override
	public NamedNodeMap getAttributes() {
		return attributes;
	}
	
	//get attribute of node
	public String getAttribute(String attr){
		Node result = attributes.getNamedItem(attr);
		//return result.toString();
		if (result != null)
			return result.getNodeValue();
		else
			return "";
	}
	public void setAttribute(String name, String value){
		//System.out.println("Name : " + name + ", attr: " + value);
		AttributeNodeTest att = new AttributeNodeTest(name);
		att.setNodeValue(value);
		//System.out.println(att);
		attributes.setNamedItem(att);
	}
	
	@Override
	public Document getOwnerDocument() {
		Node temp;
		temp = this;
		while (temp.getNodeType() != Node.DOCUMENT_NODE)
			temp = temp.getParentNode();
		
		return (Document)temp;
	}

	@Override
	public Node insertBefore(Node newChild, Node refChild) throws DOMException {
		ArrayList<Node> t;
		childNodes.insertItemBefore(newChild, refChild);
		((NodeTest)newChild).setParentNode(this);
		return this; ///?
	}
//	@Override
//	public boolean equals(Object obj) {
//		NodeTest t = (NodeTest) obj;
//		return attributes ==t.attributes && nodeType == t.nodeType 
//				&& nodeValue == t.nodeValue && nodeName == t.nodeName;
//	}
	@Override
	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
		childNodes.replaceItem(newChild, oldChild);
		return this;
	}

	@Override
	public Node removeChild(Node oldChild) throws DOMException {
		childNodes.removeItem(oldChild);
		return this;
	}

	@Override
	public Node appendChild(Node newChild) throws DOMException {
		childNodes.addItem(newChild);
		
		((NodeTest)newChild).parentNode = this;
		return this;
	}

	@Override
	public boolean hasChildNodes() {
		return childNodes.getLength()> 0;
	}

	@Override
	public Node cloneNode(boolean deep) {
		Node t= new NodeTest(nodeName);
		//t.childNodes = (NodeListTest) this.childNodes.clone();
		return t;
	}

	@Override
	public void normalize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSupported(String feature, String version) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNamespaceURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPrefix(String prefix) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAttributes() {
		return attributes.getLength() > 0;
	}

	@Override
	public String getBaseURI() {
		return baseURI;
	}

	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTextContent() throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSameNode(Node other) {
		return this == other;
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqualNode(Node arg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getFeature(String feature, String version) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserData(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString(int depth){
		String spaces = "";
		for (int i=0; i< depth; i++)
			spaces += "\t";
		String result ="\n" +  spaces;
		
		result += "<" + nodeName + " ";
		Collection<Node> attribCollection =((NamedNodeMapTest) getAttributes()).getItems();
		//Iterator<Node> iter = attribCollection.iterator();
		for (Node n: attribCollection)
			result += n.toString();
		result += "> ";
		for (Node n : childNodes.getItems())
			result += ((NodeTest)n).toString(depth + 1);
		
		result +="\n" +  spaces +"</" + nodeName  + ">";
		return result;
	}
	private void setParentNode(NodeTest node){
		parentNode = node;
	}
	@Override
	public String toString() {
		return toString(0);
	}
}
