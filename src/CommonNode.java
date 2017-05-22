/*
 * Two Singly linked list having one common node.  
 * Find the common node.
 */
public class CommonNode {

	public static void main(String[] args) {
		
		// -102 - is the common node
		Node common = new Node(-102,new Node(-22, new Node(5,new Node(6,null))));
		/*
		 * -3 -> -2 > -1 -> -2 -> 1 -> 2 -> 3 -> 4 -> -102 -> -22 -> 5 -> 6 -> null 
		 */
		Node l1 = new Node(-3,new Node(-2,new Node(-1,new Node(-2,new Node(1, new Node(2,new Node(3,new Node(4,common))))))));
		/*
		 * -3 -> -2 -> -1 -> -2 -> 1 -> 2-> 3 -> 4-> -102 -> -22 -> 5 -> 6 -> null 
		 */
		Node l2 = new Node(-5,new Node(-4,new Node(-3,new Node(-2,new Node(-1,common)))));
		
		int l1Height = 1;
		int l2Height = 1;
		Node commonNode = null;
		//Heads of 2 LL
		Node l1node = l1.next; 
		Node l2node = l2.next;
		
		while(true){			
			if (l1node !=null && l2node != null){
				l1Height++;
				l2Height++;
				if (l1node.key == l2node.key){
					
					if ((l1node = l1node.next) != null && (l2node = l2node.next) != null){
						if(l1node.key == l2node.key){
							commonNode = l1node;
							break;
						}
					}
				}
				else{
					l1node = l1node.next;
					l2node = l2node.next;
				}
				
			}
			else if(l1node != null){
				l1Height++;
				l1node = l1node.next;
			}
			else if(l2node != null){
				l2Height++;
				l2node = l2node.next;
			}
			else{
				break;
			}			
		}
		
		int heightDiff = 0;
		
		
		/*
		 * From the common node onwards, height of both L1 and L2 are same,
		 * so the common node can be searched for by comparing L1 (from the same height as L2, not from Head)
		 * with L2		
		 */
		
		/*
		 * L1 is tall, so reach till the same height 
		 * as L2 and starting comparing both
		 */
		if(l1Height > l2Height){
			heightDiff = l1Height-l2Height;
			l1node = l1.next;
			for(int i=0;i<heightDiff-1;i++){
				if(l1node != null)
					l1node = l1node.next;
			}
			l2node = l2;
			
			while(true){
				if(l1node != null && l2node !=null){
					
					if(l1node.key == l2node.key){
						commonNode = l1node;
						if ((l1node = l1node.next) != null && (l2node = l2node.next) != null){
							if(l1node.key == l2node.key){
								break;
							}
						}
					}
					
					l1node = l1node.next;
					l2node = l2node.next;
				}
				else{
					break;
				}
			}
		}
		/*
		 * L2 is tall, so reach till the same height 
		 * as L1 and starting comparing both
		 */
		else if (l2Height >l1Height){ 
			heightDiff = l2Height-l1Height;
			l1node = l1;
			l2node = l2.next;
			for(int i=0;i<heightDiff-1;i++){
				if(l2node != null)
					l2node = l2node.next;
			}
			
			
			while(true){
				if(l1node != null && l2node !=null){
					
					if(l1node.key == l2node.key){
						if ((l1node = l1node.next) != null && (l2node = l2node.next) != null){
							commonNode = l1node;
							if(l1node.key == l2node.key){
								break;
							}
						}
					}
					
					l1node = l1node.next;
					l2node = l2node.next;
				}
				else{
					break;
				}
			}
		}	
		
		System.out.println("L1 Height: "+ l1Height);
		System.out.println("L2 Height: "+l2Height);
		System.out.println("Common node: " + commonNode.key);
		

	}
	
	static class Node{
		int key;
		public Node next;
		
		Node(int key, Node node){
			this.key = key;
			this.next = node;
		}
	}

}
