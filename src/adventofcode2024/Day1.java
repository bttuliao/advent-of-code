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
		ArrayList<Integer> distanceApartList = new ArrayList<Integer>();
		int totalDistance = 0;
		
		while (scan.hasNextLine()) {
			String[] currentLocationIDs = scan.nextLine().split("\\s+");
			leftLocationIDList.add(Integer.parseInt(currentLocationIDs[0]));
			rightLocationIDList.add(Integer.parseInt(currentLocationIDs[1]));
		}
		scan.close();
		
		Collections.sort(leftLocationIDList);
		Collections.sort(rightLocationIDList);
		
		for (int i = 0; i < leftLocationIDList.size(); i++) {
			distanceApartList.add(Math.abs(leftLocationIDList.get(i) - rightLocationIDList.get(i)));
		}
		
		for (Integer currentDistanceApart : distanceApartList) {
			totalDistance += currentDistanceApart;
		}
	
		System.out.println(totalDistance);
	}
}
