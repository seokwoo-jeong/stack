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
			System.out.println("stack�� ����ֽ��ϴ�.");
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
			System.out.println("���� ������ ��: " + stack.size() + " / " + stack.capacity());
			System.out.println(Arrays.toString(stack.stack));
			System.out.println("(1)Ǫ�� (2)�� (3)��ũ (4)����: ");
			int menu = scanner.nextInt(); // ���� 1 2 3 4  �ν�
			if(menu == 4) { // 5���� ��� break
				System.out.println("���� �Ϸ�!");
				break;
			}
			int variable; //Ǫ�� �� ��� Ǫ�� ��, �� �� ��� � �� ������ �� �����ִ� ����
			switch(menu){
			case 1:
				System.out.print("������: ");
				variable = scanner.nextInt();
				stack.push(variable);				
				break;
			case 2:
				variable = stack.pop();
				System.out.println("pop ���: " + variable);
				break;
			case 3:
				variable = stack.peek();
				System.out.println("peek ���: " + variable);
				break;
			}
		}
		

	}

}
