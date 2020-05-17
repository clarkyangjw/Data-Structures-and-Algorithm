package LinkedList;

public class Josepfu {

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.showBoy();
		
		circleSingleLinkedList.countBoy(1, 2, 5); // 2->4->1->5->3
	}

}

class CircleSingleLinkedList {

	private Boy first = null;

	//num represents the number of boys that will be added
	public void addBoy(int num) {
		if (num < 1) {
			System.out.println("num must be positive.");
			return;
		}
		Boy curBoy = null; 
		for (int i = 1; i <= num; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	public void showBoy() {
		if (first == null) {
			System.out.println("This is an empty list.");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.printf("The boy's id is %d.\n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	/**
	 * 
	 * @param startNo
	 *            Start from which boy
	 * @param countNum
	 *            
	 * @param nums
	 *            Representing how many boys are in the list in the beginning
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("Parameters is not valid, please try again.");
			return;
		}
		Boy helper = first;
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		for(int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		while(true) {
			if(helper == first) {
				break;
			}
			for(int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("The boy No. %d exit¡£\n", first.getNo());
			first = first.getNext();
			helper.setNext(first); //
			
		}
		System.out.printf("The last boy in the list is No.%d.\n", first.getNo());
		
	}
}

class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

}
