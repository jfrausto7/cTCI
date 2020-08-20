package cTCI;

public class stepPaths {
	
	public static int stepPaths(int steps) {
		//base cases to end recursion
		if(steps == 0 || steps == 1) return 1;
		else if(steps == 2) {
			return 2;
		}else {
			return stepPaths(steps-3) + stepPaths(steps-2) + stepPaths(steps-1);
		}
	}
	
	
	//driver code
	public static void main(String[] args) {
		System.out.println(stepPaths(4));
	}

}
