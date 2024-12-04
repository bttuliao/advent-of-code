package adventofcode2024;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Day1 {
	public static void main(String[] args) throws Exception {
		File locationIDList = new File("C:\\Users\\coffeabeen\\Desktop\\locationIDs.txt");
		Scanner scan = new Scanner(locationIDList);
		ArrayList<Integer> leftLocationIDList = new ArrayList<Integer>();
		ArrayList<Integer> rightLocationIDList = new ArrayList<Integer>();
		int totalDistance = 0;
		
		while (scan.hasNextLine()) {
			String[] currentLocationIDs = scan.nextLine().split("\\s+");
			leftLocationIDList.add(Integer.parseInt(currentLocationIDs[0]));
			rightLocationIDList.add(Integer.parseInt(currentLocationIDs[1]));
		}
		scan.close();
		
		Collections.sort(leftLocationIDList);
		Collections.sort(rightLocationIDList);
		
		// finds total distance by the sum of the difference between smallest numbers on left and right lists
		for (int i = 0; i < leftLocationIDList.size(); i++) {
			totalDistance += Math.abs(leftLocationIDList.get(i) - rightLocationIDList.get(i));
		}
		System.out.println(totalDistance);
		
		// finds similarity score by sum of multiplying each number from the left list to the number of its occurrences in the right list
		int similarityScore = 0;
		for (Integer currentLeftLocationID : leftLocationIDList) {
			int numOfAppearances = 0;
			for (int i = 0; i < rightLocationIDList.size(); i++) {
				if (currentLeftLocationID.equals(rightLocationIDList.get(i))) {
					numOfAppearances++;
				}
			}
			similarityScore += currentLeftLocationID * numOfAppearances;
		}
		System.out.println(similarityScore);
	}
}
