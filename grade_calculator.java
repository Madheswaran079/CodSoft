package gradeCalculator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of subjects: ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the subject name along with mark");
		LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
		String subName, grade = "E";
		int mark;
		float totMark = 0, avgPer;
		for(int i=0; i<n; i++) {
			subName = sc.next();
			mark = sc.nextInt();
			sc.nextLine();
			totMark += mark;
			map.put(subName, mark);
		}
		avgPer = totMark/n;
		if(avgPer > 90) {
			grade = "A+";
		}
		else if(avgPer > 80 && avgPer <= 90) {
			grade = "A";
		}
		else if(avgPer > 70 && avgPer <= 80) {
			grade = "B+";
		}
		else if(avgPer > 60 && avgPer <= 70) {
			grade = "B";
		}
		else if(avgPer > 50 && avgPer <= 60) {
			grade = "C";
		}
		else if(avgPer > 40 && avgPer <= 50) {
			grade = "D";
		}
		System.out.println("\nSubjects - Marks");
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println("\nTotal marks obtained: " + (int)totMark);
		System.out.println("Average percentage: " + avgPer + "%");
		System.out.println("Grade: " + grade);
		sc.close();
	}
}
