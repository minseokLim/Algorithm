package _template;

// https://onsil-thegreenhouse.github.io/programming/algorithm/2018/04/05/permutation_combination/
public class CombinationPractice {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9};
        int n = arr.length;
        int r = 3;
        // 선택할 arr배열 원소의 idx값을 저장할 배열
        int[] combArr = new int[r];
        
        combination(combArr, n, r, 0, 0, arr);
	}
	
	// index는 combArr의 idx, target은 저장할 arr배열 원소의 idx
	private static void combination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		
		if(r == 0) {
			
			for(int i = 0; i < combArr.length; i++) {
				System.out.print(arr[combArr[i]] + " ");
			}
			
			System.out.println();
		} else if(n - target < r) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, n, r - 1, index + 1, target + 1, arr);
			combination(combArr, n, r, index, target + 1, arr);
		}
	}
}
