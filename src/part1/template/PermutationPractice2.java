package part1.template;

import java.util.Arrays;

// https://onsil-thegreenhouse.github.io/programming/algorithm/2018/04/05/permutation_combination/
// 기존의 nPn이 아닌, 조합 알고리즘과의 연계를 통한 nPr을 구한다.
public class PermutationPractice2 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int n = arr.length;
		int r = 3;
		
		int[] combArr = new int[r];
		
		combination(combArr, n, r, 0, 0, arr);
	}

	private static void combination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		
		if(r == 0) {
			int[] selected = new int[combArr.length];
			
			for(int i = 0; i < combArr.length; i++) {
				selected[i] = arr[combArr[i]];
			}
			
			permutation(selected, 0);
		} else if(target == n) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, n, r - 1, index + 1, target + 1, arr);
			combination(combArr, n, r, index, target + 1, arr);
		}
	}

	private static void permutation(int[] selected, int depth) {
		
		if(depth == selected.length - 1) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		
		for(int i = depth; i < selected.length; i++) {
			swap(selected, i, depth);
			permutation(selected, depth + 1);
			swap(selected, i, depth);
		}
	}

	private static void swap(int[] selected, int i, int j) {
		int temp = selected[i];
		selected[i] = selected[j];
		selected[j] = temp;
	}	
}
