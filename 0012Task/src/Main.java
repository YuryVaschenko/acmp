
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		int farmersCount = sc.nextInt();
		int resultCount = 0;
		long[] farmersStaff;

		for (int i = 0; i < farmersCount; i++) {
			sc.nextLine();
			farmersStaff = new long[10];

			for (int j = 0; j < 10; j++) {
				farmersStaff[j] = sc.nextLong();
			}

			if (isInclude(farmersStaff)) {
				resultCount++;
			}
		}

		writer.print(resultCount);
		writer.flush();
		sc.close();

	}

	private static boolean isInclude(long[] farmersStaff) {

		double trianglesResultArea;
		double squareResultArea;

		trianglesResultArea = triangleArea(farmersStaff[0], farmersStaff[1], farmersStaff[2], farmersStaff[3],
				farmersStaff[4], farmersStaff[5]);
		trianglesResultArea += triangleArea(farmersStaff[0], farmersStaff[1], farmersStaff[4], farmersStaff[5],
				farmersStaff[6], farmersStaff[7]);
		trianglesResultArea += triangleArea(farmersStaff[0], farmersStaff[1], farmersStaff[6], farmersStaff[7],
				farmersStaff[8], farmersStaff[9]);
		trianglesResultArea += triangleArea(farmersStaff[0], farmersStaff[1], farmersStaff[8], farmersStaff[9],
				farmersStaff[2], farmersStaff[3]);

		squareResultArea = calcSquareArea(farmersStaff[2], farmersStaff[3], farmersStaff[4], farmersStaff[5],
				farmersStaff[6], farmersStaff[7]);

		if (Math.abs(trianglesResultArea - squareResultArea) < 0.0001) {
			return true;
		}

		return false;

	}

	private static double calcSquareArea(long x1, long y1, long x2, long y2, long x3, long y3) {

		double firstSide = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		double secondSide = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));

		return firstSide * secondSide;

	}

	private static double triangleArea(long x1, long y1, long x2, long y2, long x3, long y3) {

		double tmp = ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) * 0.5d;
		if (tmp < 0) {
			return -tmp;
		}

		return tmp;

	}

}
