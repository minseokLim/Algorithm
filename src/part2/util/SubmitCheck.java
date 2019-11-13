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
		String familyNm = "Lim";
		List<Integer> dpList = Arrays.asList(1463, 11726, 11727, 9095, 10844, 11057, 2193, 9465, 2156, 11053, 11055, 11722, 11054, 1912, 2579, 
											1699, 2133, 9461, 2225, 2011, 11052);
		questionList.addAll(dpList);
		
		duplicateCheck(questionList);
		submitCheck(questionList, packageNm, familyNm);
	}

	private static void submitCheck(List<Integer> questionList, String packageNm, String familyNm) {
		String currDir = System.getProperty("user.dir");
		File directory = new File(currDir + File.separator + "src" + File.separator + packageNm);
		
		List<String> notSolved = questionList.stream().map(String::valueOf).collect(Collectors.toList());
		List<String> solved = Arrays.stream(directory.listFiles()).filter(file -> !file.isDirectory())
				.map(file -> file.getName().substring(familyNm.length(), file.getName().lastIndexOf('.')))
				.filter(notSolved::contains)
				.collect(Collectors.toList());
		
		notSolved.removeAll(solved);
		System.out.println("풀지 않은 문제 목록 : " + notSolved);
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
			
			throw new Exception("추가된 문제에서 중복된 항목이 있습니다. --> " + duplicateSet);
		}
	}
}
