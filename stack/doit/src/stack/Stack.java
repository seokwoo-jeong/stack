package stack;

import java.util.Arrays;
import java.util.Scanner;

public class Stack {
	private int max;
	private int point;
	private int[] stack;

	public void makeStack(int capacity) {
		this.stack = new int[capacity];
		this.max = capacity;
		this.point = 0;
		
	}
	private void push(int variable){
		if(this.point >= this.max) {
			maxSizeDouble();
		}
		
		this.stack[this.point] = variable;
		this.point++;
		
	}
	
	private void maxSizeDouble() {
		this.max = this.max*2;
		int[] bigStack = new int[this.max];
		System.arraycopy(stack, 0, bigStack, 0, point);
		this.stack = bigStack;
	}
	private int pop() {
		int temp;
		if(this.point <= 0) {
			System.out.println("stack이 비어있습니다.");
			return 0;
		}else {
		this.point--;
		temp = this.stack[this.point];
	
		this.stack[this.point] = 0;
		return temp;
	}
	}
	
	private int peek() {
		
		return this.stack[this.point-1];
	}
	
	private int capacity() {
		return this.max;
	}

	private int size() {
		return this.point;
	}
	

	
	

	public static void main(String[] args) {
		Stack stack = new Stack();
		Scanner scanner = new Scanner(System.in);
		stack.makeStack(2);
		while(true) {
			System.out.println("현재 데이터 수: " + stack.size() + " / " + stack.capacity());
			System.out.println(Arrays.toString(stack.stack));
			System.out.println("(1)푸시 (2)팝 (3)피크 (4)종료: ");
			int menu = scanner.nextInt(); // 위에 1 2 3 4  인식
			if(menu == 4) { // 5번일 경우 break
				System.out.println("종료 완료!");
				break;
			}
			int variable; //푸시 할 경우 푸시 값, 팝 할 경우 어떤 값 꺼내는 지 정해주는 변수
			switch(menu){
			case 1:
				System.out.print("데이터: ");
				variable = scanner.nextInt();
				stack.push(variable);				
				break;
			case 2:
				variable = stack.pop();
				System.out.println("pop 결과: " + variable);
				break;
			case 3:
				variable = stack.peek();
				System.out.println("peek 결과: " + variable);
				break;
			}
		}
		

	}

}
