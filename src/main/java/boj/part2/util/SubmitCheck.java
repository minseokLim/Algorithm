package boj.part2.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubmitCheck {
	public static void main(String[] args) throws Exception {
		List<Integer> questionList = new ArrayList<Integer>();
		String packageNm = "part2";
		String subPackageNm = "needToReview";
		List<Integer> dpList = Arrays.asList(1463, 11726, 11727, 9095, 10844, 11057, 2193, 9465, 2156, 11053, 11055, 11722, 11054, 1912, 2579, 
											 1699, 2133, 9461, 2225, 2011, 11052);
		questionList.addAll(dpList);
		
		List<Integer> mathList = Arrays.asList(2751, 11652, 10799, 1406, 1168, 2609, 1850, 2089, 6588, 2004);
		questionList.addAll(mathList);
		
		List<Integer> graphList = Arrays.asList(1260, 11724, 1707, 9466, 2667, 2178, 2146, 1991, 11725, 1167, 1967);
		questionList.addAll(graphList);
		
		List<Integer> binarySearchList = Arrays.asList(1654, 2805, 2110, 10816);
		questionList.addAll(binarySearchList);
		
		List<Integer> greedyList = Arrays.asList(10610, 1783, 1931, 2873, 1744);
		questionList.addAll(greedyList);
		
		List<Integer> exhaustiveSearchList = Arrays.asList(1107, 1451, 10819, 10971, 1697, 1963, 9019, 1525, 2251, 2186, 3108, 5014, 1759, 2580, 1987, 
				 								  6603, 1182, 2003, 1806, 1644, 1261, 1208, 7453, 2632, 2143);
		questionList.addAll(exhaustiveSearchList);
		
		// https://m.blog.naver.com/PostView.nhn?blogId=kks227&logNo=221432986308&proxyReferer=https%3A%2F%2Fwww.google.com%2F
		List<Integer> ternarySearchList = Arrays.asList(11662);
//		List<Integer> ternarySearchList = Arrays.asList(11662, 8986, 13310, 1087);
		questionList.addAll(ternarySearchList);
		
		duplicateCheck(questionList);
		submitCheck(questionList, packageNm, subPackageNm);
	}

	private static void submitCheck(List<Integer> questionList, String packageNm, String subPackageNm) {
		String currDir = System.getProperty("user.dir");
		File directory = new File(currDir + File.separator + "src" + File.separator + packageNm);
		File subDirectory = new File(currDir + File.separator + "src" + File.separator + packageNm + File.separator + subPackageNm);
		File[] solvedFiles = directory.listFiles();
		File[] needToReview = subDirectory.listFiles();
		File[] totalSolved = new File[solvedFiles.length + needToReview.length];
		System.arraycopy(solvedFiles, 0, totalSolved, 0, solvedFiles.length);
		System.arraycopy(needToReview, 0, totalSolved, solvedFiles.length, needToReview.length);
		
		List<String> notSolved = questionList.stream().map(String::valueOf).collect(Collectors.toList());
		List<String> solved = Arrays.stream(totalSolved).filter(file -> !file.isDirectory() && !file.getName().contains("_"))
				.map(file -> file.getName().replaceAll("\\D", ""))
				.filter(notSolved::contains)
				.collect(Collectors.toList());
		Set<String> needToReviewSet = Arrays.stream(needToReview).filter(file -> !file.isDirectory()).map(file -> file.getName().replaceAll("_\\d+", "")).collect(Collectors.toSet());
		
		notSolved.removeAll(solved);
		System.out.println("Question count : " + questionList.size());
		System.out.println("Solved count   : " + solved.size());
		System.out.println("Unsolved count : " + notSolved.size());
		System.out.println("Need to review : " + needToReviewSet.size());
		System.out.println("Unsolved list: " + notSolved);
	}
	
	private static void duplicateCheck(List<Integer> questionList) throws Exception {
		int listSize = questionList.size();
		long filteredSize = questionList.stream().distinct().count();
		
		if(listSize != filteredSize) {
			Set<Integer> duplicateSet = new HashSet<>();
			questionList.sort(Comparator.naturalOrder());
			for(int i = 0; i < questionList.size() - 1; i++) {
				
				if(questionList.get(i).equals(questionList.get(i + 1))) {
					duplicateSet.add(questionList.get(i));
				}
			}
			
			throw new Exception("Duplication Error --> " + duplicateSet);
		}
	}
}
