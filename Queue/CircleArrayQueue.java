package Queue;

import java.util.Scanner;

public class CircleArrayQueue {

	public static void main(String[] args) {
		
		System.out.println("Test the Circle Array Queue");
		
		// create a queue
		CircleArray queue = new CircleArray(4); //due to the agreement, we set maxSize to 4, but it only can store 3(leave one space)
		char key = ' '; // accept a char
		Scanner scanner = new Scanner(System.in);//
		boolean loop = true;
		// make a menu
		while (loop) {
			System.out.println("s(show): Show the queue");
			System.out.println("e(exit): Exit the program");
			System.out.println("a(add): Add data to the queue");
			System.out.println("g(get): Get data from the queue");
			System.out.println("h(head): Show the head element in the queue");
			key = scanner.next().charAt(0);// read a char from keyboard
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("Please enter a integer");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g': 
				try {
					int res = queue.getQueue();
					System.out.printf("Get the data: %d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("The head element in the queue: %d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("Program ended");
	}

}


class CircleArray {
	private int maxSize; // Max size of the array
	private int front; //Points to the first element of the array, initial value is 0
	private int rear; // Point to the position behind the last element, initial value is 0
	private int[] arr; // Used to stored the array
	
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}
	
	//Make an agreement that leave an empty space in the array
	public boolean isFull() {
		//The reason of adding one is the agreement(notice that rear points to the position behind the last element 
		return (rear  + 1) % maxSize == front;
	}
	
	public boolean isEmpty() {
		//Both initial value are 0
		return rear == front;
	}
	
	// Add data to the queue
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("Queue is full, can not add data");
			return;
		}
		//add the n into the element of index rear
		arr[rear] = n;
		//move the index rear to the next position, if rear is out of the maxSixe, return to 0(using mock up)
		rear = (rear + 1) % maxSize;
	}
	
	// acquire the data from the circle array
	public int getQueue() {
		if (isEmpty()) {
			// if empty, throw an exception
			throw new RuntimeException("Queue is empty, can not get data");
		}

		//save the value to a temporary variable
		int value = arr[front];
		//move the index front to the next position
		front = (front + 1) % maxSize;
		//return the temporary value
		return value;

	}
	
	// show all data in the queue
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty, can not get data");
			return;
		}
		//start from front, iterate size() time
		for (int i = front; i < front + size() ; i++) {
			//i might exceed the max size of the array, so it needs to be mocked by maxSize
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	// calculate the number of elements
	public int size() {
		// rear = 2
		// front = 1
		// maxSize = 3 
		return (rear + maxSize - front) % maxSize;   
	}
	
	// show the head element in the queue
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty, can not get data");
		}
		return arr[front];
	}
}