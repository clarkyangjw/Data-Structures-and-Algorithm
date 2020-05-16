package LinkedList;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		
		System.out.println("Test Double Linked List");

		HeroNode2 hero1 = new HeroNode2(1, "Ant-Man");
		HeroNode2 hero2 = new HeroNode2(2, "Batman");
		HeroNode2 hero3 = new HeroNode2(3, "Captain Marvel");
		HeroNode2 hero4 = new HeroNode2(4, "X-Men");

		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		
		doubleLinkedList.list();
		
		//Testing Update
		HeroNode2 newHeroNode = new HeroNode2(4, "Superman");
		doubleLinkedList.update(newHeroNode);
		System.out.println("After update: ");
		doubleLinkedList.list();
		
		//Testing Delete
		doubleLinkedList.del(3);
		System.out.println("After delete: ");
		doubleLinkedList.list();
		
		
		
	}

}


class DoubleLinkedList {

	private HeroNode2 head = new HeroNode2(0, "");

	public HeroNode2 getHead() {
		return head;
	}

	// Display the list
	public void list() {
		if (head.next == null) {
			System.out.println("The list is empty.");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// Add a node at the end of the list.
	public void add(HeroNode2 heroNode) {
		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {//
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	public void update(HeroNode2 newHeroNode) {
		if (head.next == null) {
			System.out.println("The list is empty.");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false; 
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
		} else {
			System.out.printf("Did not find the node %d.\n", newHeroNode.no);
		}
	}

	public void del(int no) {
		if (head.next == null) {
			System.out.println("The list is empty.");
			return;
		}

		HeroNode2 temp = head.next; 
		boolean flag = false; 
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next; 
		}
		if (flag) { 
			temp.pre.next = temp.next;
			// If the deleted node is the last node in the list, it may cause null pointer error
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("The deleted node %d does not exist.\n", no);
		}
	}

}

class HeroNode2 {
	public int no;
	public String name;
	public HeroNode2 next;
	public HeroNode2 pre;

	public HeroNode2(int no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

}
