package node;

import java.util.ArrayList;
import java.util.List;

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
		int i = nodeList.indexOf(refChild);
		ArrayList<Node> temp = new ArrayList<Node>();
		List<Node> subList = nodeList.subList(i, nodeList.size());
		
		for (Node t : subList)
			temp.add(t);  //clone 
		nodeList.removeAll(subList);
		nodeList.add(newChild);
		nodeList.addAll(temp);
		
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
