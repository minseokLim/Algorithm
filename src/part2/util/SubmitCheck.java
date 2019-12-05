package part2.util;

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
		
		List<Integer> mathList = Arrays.asList(2751, 11652, 10799, 10845, 10866, 10808, 
											  10809, 10820, 2743, 11655, 10824, 11656, 1406, 1158, 1168, 10430, 2609, 1934, 1850, 9613, 11005, 
											  2745, 1373, 1212, 2089, 11576, 1978, 1929, 6588, 11653, 10872, 1676, 2004);
		questionList.addAll(mathList);
		
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
		
		notSolved.removeAll(solved);
		System.out.println("Unsolved list : " + notSolved);
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
