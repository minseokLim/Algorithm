package part3.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubmitCheck {
	public static void main(String[] args) throws Exception {
		String packageNm = "part3";
		String subPackageNm = "needToReview";
		
		String currDir = System.getProperty("user.dir");
		File directory = new File(currDir + File.separator + "src" + File.separator + packageNm + File.separator +  "questionList");
		File[] questionFiles = directory.listFiles();
		Set<String> questionSet = Arrays.stream(questionFiles).filter(file -> !file.isDirectory())
										.map(file -> file.getName().replaceAll("_\\d+", ""))
										.map(elem -> elem.replaceAll("\\D", ""))
										.collect(Collectors.toSet());
		
		List<String> questionList = new ArrayList<>(questionSet);		
		
		submitCheck(questionList, packageNm, subPackageNm);
	}

	private static void submitCheck(List<String> questionList, String packageNm, String subPackageNm) {
		String currDir = System.getProperty("user.dir");
		File directory = new File(currDir + File.separator + "src" + File.separator + packageNm);
		File subDirectory = new File(currDir + File.separator + "src" + File.separator + packageNm + File.separator + subPackageNm);
		File[] solvedFiles = directory.listFiles();
		File[] needToReview = subDirectory.listFiles();
		File[] totalSolved = new File[solvedFiles.length + needToReview.length];
		System.arraycopy(solvedFiles, 0, totalSolved, 0, solvedFiles.length);
		System.arraycopy(needToReview, 0, totalSolved, solvedFiles.length, needToReview.length);
		
		int questionCnt = questionList.size();
		
		List<String> notSolved = questionList;
		List<String> solved = Arrays.stream(totalSolved).filter(file -> !file.isDirectory() && !file.getName().contains("_"))
				.map(file -> file.getName().replaceAll("\\D", ""))
				.filter(notSolved::contains)
				.collect(Collectors.toList());
		Set<String> needToReviewSet = Arrays.stream(needToReview).filter(file -> !file.isDirectory()).map(file -> file.getName().replaceAll("_\\d+", "")).collect(Collectors.toSet());
		
		notSolved.removeAll(solved);
		System.out.println("Question count : " + questionCnt);
		System.out.println("Solved count   : " + solved.size());
		System.out.println("Unsolved count : " + notSolved.size());
		System.out.println("Need to review : " + needToReviewSet.size());
		System.out.println("Unsolved list: " + notSolved);
	}
}
