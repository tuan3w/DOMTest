import org.w3c.dom.Node;

import node.DOMTest;
import node.NodeTest;


public class Test {
	public static void main(String[] args){
		DOMTest dom = new DOMTest();
		Node body = dom.createElement("body");
		NodeTest div =(NodeTest) dom.createElement("div");
		Node div2 = dom.createElement("div");
		NodeTest p =(NodeTest) dom.createElement("p");
		div.setAttribute("role", "menu");
		p.setAttribute("style", "position: absolute; width: 30px; height: 10px;");
		
		body.appendChild(div).appendChild(div2);
		div2.appendChild(p);
		dom.appendChild(body);
		
		System.out.println("Dom structure : \n" + dom);
	}
}
