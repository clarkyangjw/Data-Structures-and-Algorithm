package LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {

		HeroNode hero1 = new HeroNode(1, "Ant-Man");
		HeroNode hero2 = new HeroNode(2, "Batman");
		HeroNode hero3 = new HeroNode(3, "Captain Marvel");
		HeroNode hero4 = new HeroNode(4, "X-Men");
		HeroNode hero5 = new HeroNode(10, "Superman");
		HeroNode hero6 = new HeroNode(20, "Spider-Man");
		HeroNode hero7 = new HeroNode(30, "Hellboy");
		
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero4);
//		singleLinkedList.add(hero6);
//		singleLinkedList.add(hero7);
//		singleLinkedList.add(hero2);
//		singleLinkedList.add(hero5);
//		singleLinkedList.add(hero3);
//		System.out.println("Show the hero list: ");
//		singleLinkedList.list();
		
		
		//add hero by order
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero6);
		singleLinkedList.addByOrder(hero7);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero5);
		singleLinkedList.addByOrder(hero3);
		System.out.println("Show the hero list: ");
		singleLinkedList.list();
		
		
//		System.out.println("Reverse the list: ");
//		reverseList(singleLinkedList.getHead());
//		singleLinkedList.list();
		
		System.out.println("Reverse print the list: ");
		reversePrint(singleLinkedList.getHead());
		
/*		
		//Testing the update function
		HeroNode newHeroNode = new HeroNode(2, "Batmanmanman");
		singleLinkedList.update(newHeroNode);
		
		System.out.println("Show the updated list: ");
		singleLinkedList.list();
		
		//Testing the delete function
		singleLinkedList.delete(1);
		singleLinkedList.delete(4);
		System.out.println("Show the list: ");
		singleLinkedList.list();
		
		//Testing the function of querying the number of the node
		System.out.println("The number of the node=" + getLength(singleLinkedList.getHead()));//2
		
		//Testing the finding last index node
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
*/		
		
	}
	
	//use stack, fist in, last out
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	
	//Reverse the list
	public static void reverseList(HeroNode head) {
		//Return if the list is empty or there is only one node in the list
		if(head.next == null || head.next.next == null) {
			return ;
		}
		HeroNode cur = head.next;
		HeroNode next = null;// Used to save the next node of the cur node
		HeroNode reverseHead = new HeroNode(0, "");
		while(cur != null) { 
			next = cur.next;//save the next node
			cur.next = reverseHead.next;//save the next node of the new list to the next node of the cur node
			reverseHead.next = cur; //connect the cur node to the node of the new list
			cur = next;//move forward
		}
		head.next = reverseHead.next;
	}
	
	//Find the last number of nodes
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if(head.next == null) {
			return null;
		}
		int size = getLength(head);
		//Validate the index
		if(index <=0 || index > size) {
			return null; 
		}
		HeroNode cur = head.next; //3 // 3 - 1 = 2
		for(int i =0; i< size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	//Query the number of the node in the list
	/**
	 * 
	 * @param head of a list
	 * @return the number of the node
	 */
	public static int getLength(HeroNode head) {
		if(head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode tem = head.next;
		while(tem != null) {
			length++;
			tem = tem.next;
		}
		return length;
	}

}


//declare SingleLinkedList to manipulate HeroNode objects
class SingleLinkedList {
	//initialize the head node, it does not contain any data, just used to mark down the start point of the linked list
	private HeroNode head = new HeroNode(0, "");
	
	public HeroNode getHead() {
		return head;
	}


	//add a new HeroNode to the linked list without considering the hero's no.
	public void add(HeroNode heroNode) {
		
		//use a temporary HeroNode instead of changing the head node
		HeroNode temp = head;
		//iterate the linked list to search the last element
		while(true) {
			//break the loop when the last element is found
			if(temp.next == null) {//
				break;
			}
			//move to the next node and keep searching
			temp = temp.next;
		}
		//when the loop is break, temp points to the last element
		//the last element points to the new HeroNode
		temp.next = heroNode;
	}
	
	
	//add a new HeroNode to the linked list order by the hero's no.
	public void addByOrder(HeroNode heroNode) {
		
		HeroNode temp = head;
		boolean flag = false; // use a flag to indicate the number exist or not
		while(true) {
			if(temp.next == null) {//if the temp.next is the last element, insert the new HeroNode to the temp.next
				break; //
			} 
			if(temp.next.no > heroNode.no) { //if the no of temp.next is greater than the new HeroNode, insert the new HeroNode to the temp.next
				break;
			} else if (temp.next.no == heroNode.no) {//set the flag to true if having the same hero's no
				flag = true; 
				break;
			}
			temp = temp.next; //move forward
		}
		//can not insert the same hero's no
		if(flag) { 
			System.out.printf("The hero number %d already exist\n", heroNode.no);
		} else {
			//stored the temp.next to the next of the new HeroNore object
			heroNode.next = temp.next;
			//insert the new HeroNore object to the temp.next
			temp.next = heroNode;
		}
	}

	
	//update the information base on the no of new HeroNode
	public void update(HeroNode newHeroNode) {
		if(head.next == null) {
			System.out.println("The linked list is empty.");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false; //indicate whether the hero is found
		while(true) {
			if (temp == null) {
				break; 
			}
			if(temp.no == newHeroNode.no) {
				//if found
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.name = newHeroNode.name;
		} else { 
			System.out.printf("The hero no %d is not found.\n", newHeroNode.no);
		}
	}
	
	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false; //indicate whether the hero is found
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			//If the hero is found, delete it
			temp.next = temp.next.next;
		}else {
			System.out.printf("The hero number %d does not exist.\n", no);
		}
	}
	
	//Show the hero list
	public void list() {
		if(head.next == null) {
			System.out.println("The list is empty.");
			return;
		}
		HeroNode temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			//Print the hero's message
			System.out.println(temp);
			//Move forward
			temp = temp.next;
		}
	}
}


//declare HeroNode class£¬ every object of HeroNode is a node
class HeroNode {
	public int no;
	public String name;
	public HeroNode next; //record the next node

	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
		this.next = null;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
}
