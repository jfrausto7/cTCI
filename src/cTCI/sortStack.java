package cTCI;

import java.util.Stack;

public class sortStack {
	
	public static Stack<Integer> sortStack(Stack<Integer> stack){
		Stack<Integer> result = new Stack<Integer>();
		int temp;
		//iterate through stack
		while(!stack.isEmpty()) {
			temp = stack.pop();
			
			//control flow
			if(result.isEmpty()) result.push(temp);
			else if(result.peek() < temp) {
				while(result.peek() < temp) {
					stack.push(result.pop());
					if(result.isEmpty()) break;
				}
				result.push(temp);
			}else {
				result.push(temp);
			}
		}
		return result;
	}
	
	
	//driver testing code below
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		//push some numbers
		stack.push(7);
		stack.push(9);
		stack.push(2);
		stack.push(5);
		
		
		System.out.println(sortStack(stack));

	}

}
