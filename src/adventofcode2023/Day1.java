package adventofcode2023;
import java.io.File;
import java.util.Scanner;

public class Day1 {
	public static void main(String[] args) throws Exception {
		int sum = 0;
		File calibrationDoc = new File("C:\\Users\\coffeabeen\\Desktop\\CalibrationDocument.txt");
		Scanner scanner = new Scanner(calibrationDoc);
		
		while (scanner.hasNextLine()) {
			String currentLineDigits = scanner.nextLine().replaceAll("\\D+","");
			String calibrationValue = "";
			
			if (currentLineDigits.length() > 1) {
				calibrationValue = currentLineDigits.charAt(0) + "" + currentLineDigits.charAt(currentLineDigits.length() - 1);
			} else {
				calibrationValue = currentLineDigits.charAt(0) + "" + currentLineDigits.charAt(0);
			}
			sum += Integer.parseInt(calibrationValue);
		}
		scanner.close();
		
		System.out.println("sum of all calibration values = " + sum);
	}
}