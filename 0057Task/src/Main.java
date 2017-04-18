
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		int pointsCount = sc.nextInt();
		double cableCost = sc.nextDouble();
		double moneyExist = sc.nextDouble();
		int[] xCoordArr = new int[pointsCount + 1];
		int[] yCoordArr = new int[pointsCount + 1];
		double resultLenght = Double.MAX_VALUE;
		double ispLenght = 0;

		for (int i = 0; i < pointsCount + 1; i++) {
			sc.nextLine();
			xCoordArr[i] = sc.nextInt();
			yCoordArr[i] = sc.nextInt();
		}

		for (int i = 0; i < xCoordArr.length - 1; i++) {
			ispLenght = lenghtCalcResult(xCoordArr[xCoordArr.length - 1], yCoordArr[xCoordArr.length - 1], xCoordArr[i],
					yCoordArr[i]);
			for (int j = 0; j < pointsCount; j++) {
				ispLenght += lenghtCalcResult(xCoordArr[i], yCoordArr[i], xCoordArr[j], yCoordArr[j]);
			}

			if (ispLenght < resultLenght) {
				resultLenght = ispLenght;
			}
		}

		if (cableCost * resultLenght > moneyExist) {
			writer.print("NO");
		} else {
			writer.print("YES");
		}

		writer.flush();
		writer.close();
		sc.close();
	}

	private static double lenghtCalcResult(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

}
