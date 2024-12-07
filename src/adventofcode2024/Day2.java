package adventofcode2024;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Day2 {
	public static void main(String[] args) throws Exception {
		File reportList = new File("C:\\Users\\coffeabeen\\Desktop\\reportList.txt");
		Scanner scan = new Scanner(reportList);
		int numOfSafeReports = 0;
		
		while (scan.hasNextLine()) {
			ArrayList<Integer> currentReport = new ArrayList<Integer>();	
			String[] currentReportStr = scan.nextLine().split("\\s+");
			for (int i = 0; i < currentReportStr.length; i++) {
				currentReport.add(Integer.parseInt(currentReportStr[i]));
			}
		
			numOfSafeReports += verifySafeReport(currentReport);
		}
		System.out.println(numOfSafeReports);
	}
	
	public static int verifySafeReport(ArrayList<Integer> currentReport) {
		boolean isIncreasing = false;
		boolean initialCheck = true;
		int countOfSafeReport = 1;
		
		// determines if report is all increasing or all decreasing
		for (int i = 0; i < currentReport.size() - 1; i++) {
			if (initialCheck && (currentReport.get(i) < currentReport.get(i + 1))) {
				initialCheck = false;
				isIncreasing = true;
			} else if (initialCheck && (currentReport.get(i) > currentReport.get(i + 1))) {
				initialCheck = false;
			} else if (isIncreasing && (currentReport.get(i) > currentReport.get(i + 1))) {
				return 0;
			} else if (!isIncreasing && (currentReport.get(i) < currentReport.get(i + 1))) {
				return 0;
			} 
		}
		
		// determines if adjacent levels differ by at least 1 or 3 at most
		for (int i = 0 ; i < currentReport.size() - 1; i++) {
			if ((Math.abs(currentReport.get(i) - currentReport.get(i + 1)) > 3 || 
					Math.abs(currentReport.get(i) - currentReport.get(i + 1)) < 1)) {
				countOfSafeReport = 0;
			}
		}
		return countOfSafeReport;
	}
}