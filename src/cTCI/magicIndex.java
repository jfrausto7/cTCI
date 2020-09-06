package cTCI;

public class magicIndex {
	
	public static void magicIndex(int[] sorted) {
		//base case
		if(sorted == null || sorted.length == 0) {
			System.out.println("Bad input.");
		}
		
		//use implementation of binary search
		int result = binarySearch(sorted, 0, sorted.length-1);
		
		//print accordingly
		if(result == -1) {
			System.out.println("There is no magic index.");
		}else {
			System.out.println("The magic index is at " + result + " .");
		}
		
	}
	
	public static int binarySearch(int[] arr, int l, int r) {
		if(r >= l) {
			int mid = l + (r-1) / 2;
			
			if(arr[mid] == mid) return mid;	//magic index
			
			if(arr[mid] > mid) {
				return binarySearch(arr, l, mid-1);//left subarray
			}
			
			return binarySearch(arr,mid+1,r); //right subarray
		}
		return -1;	//break recursion
	}
	
	//driver code
	public static void main(String[] args) {
		int[] sorted = {1,2,3,4,5};
		int[] sorted2 = {0,12,19,22,51};
		int[] sorted3 = {-1,0,1,2,4,10};
		
		magicIndex(sorted);
		magicIndex(sorted2);
		magicIndex(sorted3);
		
		
	}

}
