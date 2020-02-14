public class findLargest {

	public static void main(String[] args) {
		
		int[] a = {-5, 14, -12, 99, -77, 85, 45};
		int len = a.length;
		int largestVal = recFL(a,len);
		System.out.println(largestVal);
	}
	
	public static int recFL(int arr[], int x) {
		if(x == 1) {
			return arr[0];
		}
		
		else {
			return Math.max(arr[x-1], recFL(arr, x-1));
		}
	}

}
