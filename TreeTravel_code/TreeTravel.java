	import java.util.Scanner;

	
public class TreeTravel
 {
	
	private static String inputNodeName = "A";
	

	private static int mode = 0;

	private static int findInLevel = 0;
	
	public static void main(String arg[])
 {
		
	// 5
		
	Node e = new Node("E", null);
	
	Node o = new Node("O", null);

	// 4
	
	Node d = new Node("D", new Node[] { e });
	
	Node g = new Node("G", null);
		
	Node k = new Node("K", null);
		
	Node n = new Node("N", new Node[] { o });

	// 3
		
	Node c = new Node("C", new Node[] { d });

	Node f = new Node("F", new Node[] { g });

	Node i = new Node("I", null);
	
	Node j = new Node("J", new Node[] { k });

	Node m = new Node("M", new Node[] { n });

	// 2
		
	Node b = new Node("B", new Node[] { c, f });
	
	Node h = new Node("H", new Node[] { i, j });
	
	Node l = new Node("L", new Node[] { m });
	
	// 1
		
	while(true) 
{
	
	Scanner scanner = new Scanner(System.in);
	
	//  prompt for the user's name
	
	System.out.print("Enter node name or exit: ");
	
	inputNodeName = scanner.next();
		
    	if(inputNodeName != null && inputNodeName.equals("exit")) break;
	
	mode = 0;
		  
  	findInLevel =  0;
		
	Node a = new Node("A", new Node[] { b, h, l });
		
	a.setLevel(1);
			
	Node peerNode = findNodeLevel(a, 1);
	
	if (peerNode != null)
 {
				
	System.out.println("PeerNode for "+inputNodeName +" is : " + peerNode.getName() + ", at level: " + peerNode.getLevel());

			} 
	else 
{
		
	System.out.println("No Peer found");
	
}
		
}

}


	private static Node findNodeLevel(Node parentNode, int currentStage)
 {
		
	Node result = null;

	if (!parentNode.getName().equals(inputNodeName)) 
{
			
	currentStage++;
		
	if (parentNode.getChildren() != null)
	
	for (Node currentNode : parentNode.getChildren())
 {
					
	currentNode.setLevel(currentStage);
	
	if (mode == 0) 
{	
	// currentPosition

	if(currentNode.getName().equals(inputNodeName)) 
{
							
	// current Node position found
			
	mode = 1;
	
	findInLevel = currentStage;

} 
	else if ((result = findNodeLevel(currentNode, currentStage)) != null) break;	
} 
	else if(mode == 1)
 { 
	// peerNode which is next same level
				
	if(currentStage == findInLevel) 
{
					
	// peer Node found
	
	result = currentNode;
	
	break;
		
} 
	else if ((result = findNodeLevel(currentNode, currentStage)) != null) break;
	
} 
			
}
	
}
		
	return result;
	
}

}

	
class Node
 {

	
	private String name;

	private Node[] children;

	private int level;

	
	Node(String name, Node[] children)
 {
		
	this.name = name;

	this.children = children;

}

	
	public String getName()
 {
	
	return name;

}


	public void setName(String name)
 {
		
	this.name = name;
	
}

	
	public Node[] getChildren()
 {
		
	return children;

}

	
	public void setChildren(Node[] children)
 {
	
	this.children = children;

}

	
	public String toString() 
{
		
	return this.name;

}

	
	public int getLevel()
 {
		
	return level;

}

	
	public void setLevel(int level) 
{
		
	this.level = level;
	
}

}