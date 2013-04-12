import org.w3c.dom.Node;

import node.DocumentTest;
import node.NodeTest;


public class Test {
	public static void main(String[] args){
		DocumentTest doc = new DocumentTest();
		
		//body element
		Node body = doc.createElement("body");
		
		//div element
		NodeTest div =(NodeTest) doc.createElement("div");
		div.setAttribute("role", "menu");
		
		//div element
		Node div2 = doc.createElement("div");
		
		NodeTest p =(NodeTest) doc.createElement("p");
		p.setAttribute("style", "position: absolute; width: 30px; height: 10px;");
		p.setAttribute("id", "block-paragraph");
		
		NodeTest button = (NodeTest) doc.createElement("button");
		button.setAttribute("type", "submit");
		
		
		
		body.appendChild(div).appendChild(div2);
		div2.appendChild(p);
		div2.appendChild(button);
		doc.appendChild(body);
		
		System.out.println("=================================================");
		System.out.println("Document structure : \n" + doc);
		
		//parent node
		System.out.println("=================================================");
		System.out.println("parent node of first div tag : " + div.getParentNode().getNodeName());
		
		//get attribute of NOde
		System.out.println("Get attribute id of p tag: " + p.getAttribute("id"));
		
		//DOM explorer
		Node block = doc.getElementById("block-paragraph");
		System.out.println("=================================================");
		System.out.println("block element : " + block.getNodeName());
		
		//sibling
		System.out.println("=================================================");
		NodeTest nextElement = (NodeTest) p.getNextSibling();
		System.out.println("Next element " + nextElement.getNodeName());
		NodeTest prevElement = (NodeTest) button.getPreviousSibling();
		System.out.println("Previous element of button :" + prevElement.getNodeName());
		
		//insert before
		System.out.println("=================================================");
		System.out.println("Insert image tag before button tag ");
		NodeTest img = new NodeTest("img");
		div2.insertBefore(img, button);
		System.out.println (doc);
	}
}
