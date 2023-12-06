package adventofcode2023;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day1 {
	public static void main(String[] args) throws Exception {
		int sum = 0;
		File calibrationDoc = new File("C:\\Users\\coffeabeen\\Desktop\\CalibrationDocument.txt");
		Scanner scanner = new Scanner(calibrationDoc);
		HashMap<String, Integer> letterNumbersToDigits = mapLetterNumbersToDigits();

		while (scanner.hasNextLine()) {
			String currentLineDigits = replaceLetterNumbersAsDigits(scanner.nextLine(), letterNumbersToDigits).replaceAll("\\D+", "");
			String calibrationValue = "";
			
			if (currentLineDigits.length() > 1) {
				calibrationValue = currentLineDigits.charAt(0) + "" + currentLineDigits.charAt(currentLineDigits.length() - 1);
			} else {
				calibrationValue = currentLineDigits.charAt(0) + "" + currentLineDigits.charAt(0);
			}
			sum += Integer.parseInt(calibrationValue);
		}
		scanner.close();

		System.out.println("sum = " + sum);
	}

	public static HashMap<String, Integer> mapLetterNumbersToDigits() {
		HashMap<String, Integer> letterNumbersToDigits = new HashMap<String, Integer>();
		
		letterNumbersToDigits.put("one", 1);
		letterNumbersToDigits.put("two", 2);
		letterNumbersToDigits.put("three", 3);
		letterNumbersToDigits.put("four", 4);
		letterNumbersToDigits.put("five", 5);
		letterNumbersToDigits.put("six", 6);
		letterNumbersToDigits.put("seven", 7);
		letterNumbersToDigits.put("eight", 8);	
		letterNumbersToDigits.put("nine", 9);

		return letterNumbersToDigits;
	}

	public static String replaceLetterNumbersAsDigits(String currentLine, HashMap<String, Integer> letterNumbersToDigits) {
		ArrayList<String> currentLineNumberAsDigitList = new ArrayList<String>();
		HashMap<Integer, String> letterNumbersToLocations = new HashMap<Integer, String>();
		
		for (Map.Entry<String, Integer> number : letterNumbersToDigits.entrySet()) {
			if (currentLine.contains(number.getKey())) {
				String currentLineNumberAsDigit = currentLine.replaceAll(number.getKey(), number.getValue().toString());
				currentLineNumberAsDigitList.add(currentLineNumberAsDigit);
				letterNumbersToLocations.put(currentLine.indexOf(number.getKey()), currentLineNumberAsDigit);
			}
		}
		
		ArrayList<Integer> sortedLetterNumberLocations = new ArrayList<Integer>(letterNumbersToLocations.keySet());
		Collections.sort(sortedLetterNumberLocations);	
		String currentLineWithDigitReplacements = "";
		
		if (sortedLetterNumberLocations.size() > 0) {
			for (Integer letterNumberLocation : sortedLetterNumberLocations) {
				currentLineWithDigitReplacements += letterNumbersToLocations.get(letterNumberLocation).replaceAll("\\D+", "");
			}
			return currentLineWithDigitReplacements;
		}

		return currentLine;
	}
}
