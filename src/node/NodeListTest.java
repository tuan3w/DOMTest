package node;

import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListTest implements NodeList{
	protected ArrayList<Node> nodeList = new ArrayList<Node>();
	@Override
	public Node item(int index) {
		return nodeList.get(index);
	}

	@Override
	public int getLength() {
		return nodeList.size();
	}

	public void insertItemBefore(Node newChild, Node refChild) {
		for (int i= nodeList.size() -1; i>=0; i--)
			if (nodeList.get(i) == refChild) {
				ArrayList subList = (ArrayList) nodeList.subList(i, nodeList.size());
				nodeList.removeAll(subList);
				nodeList.add(newChild);
				nodeList.addAll(subList);
			}
		
	}
	
	public void replaceItem(Node newChild, Node oldChild) {
		//get old node position
		for (int i= nodeList.size() -1; i>=0; i--)
			if (nodeList.get(i) == oldChild) {
				nodeList.set(i, newChild);
				break;
			}
		
	}

	public void removeItem(Node oldChild) {
		nodeList.remove(oldChild);
	}



	public void addItem(Node newChild) {
		nodeList.add(newChild);
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Node> getItems() {
		// TODO Auto-generated method stub
		return nodeList;
	}

}
