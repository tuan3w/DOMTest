package node;
import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.xml.bind.annotation.W3CDomHandler;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;

import org.omg.CORBA.ORB;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;



public class DocumentTest extends NodeTest implements Document{
	
	public DocumentTest() {
		super("html");
		//node type DOCUMENT_NODE;
		this.nodeType = DOCUMENT_NODE;
	}
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addDocumentListener(DocumentListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDocumentListener(DocumentListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUndoableEditListener(UndoableEditListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUndoableEditListener(UndoableEditListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getProperty(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putProperty(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int offs, int len) throws BadLocationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertString(int offset, String str, AttributeSet a)
			throws BadLocationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText(int offset, int length) throws BadLocationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getText(int offset, int length, Segment txt)
			throws BadLocationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position getStartPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getEndPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position createPosition(int offs) throws BadLocationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public javax.swing.text.Element[] getRootElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public javax.swing.text.Element getDefaultRootElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Runnable r) {
		// TODO Auto-generated method stub
		
	}
	public Node createElement(String name){
		Node t = new NodeTest(name);
		return t;
	}
	public NodeList getElementsByTagName(String tagName){
		NodeListTest list = new NodeListTest();
		for (int i= childNodes.getLength() -1; i>=0; i--){
			Node t = childNodes.item(i);
			if (t.getNodeName().equalsIgnoreCase(tagName))
				list.addItem(t);
		}
		return list;
	}
	public Node getElementById(String id){
//		for (int i= childNodes.getLength() -1; i>=0; i--){
//			System.out.println(i);
//			NodeTest t = (NodeTest)childNodes.item(i);
//			if (t.getAttribute("id").equalsIgnoreCase(id)){
//				System.out.println("found");
//				return t;
//			}
//		}
		return findChilElement(this, "id", id);
	}
	private Node findChilElement(Node n,String attr, String value){
		ArrayList<Node> list =((NodeListTest)n.getChildNodes()).getItems();
		
		for (Node t: list){
			System.out.println("Node " + t.getNodeName() + " : " + ((NodeTest)t).getAttribute(attr));
			if (((NodeTest)t).getAttribute("id").equals(value))
				return t;
			if (t.hasChildNodes()){
				Node out = null;
				for (Node temp: ((NodeListTest)t.getChildNodes()).getItems()){
					out = findChilElement(temp, attr, value);
					if (out != null)
						return out;
				}
			}
		}
		return null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}