import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		int height = sc.nextInt();
		int lenght = sc.nextInt();
		int width = sc.nextInt();
		List<Integer> xCoords = new ArrayList<>();
		List<Integer> yCoords = new ArrayList<>();
		List<Integer> zCoords = new ArrayList<>();
		int princessCoordX = 0;
		int princessCoordY = 0;
		int princessCoordZ = 0;

		String readedLine = "";

		int[][][] field = new int[height + 2][lenght + 2][width + 2];

		for (int i = 0; i < height + 2; i++) {
			for (int j = 0; j < lenght + 2; j++) {
				for (int z = 0; z < width + 2; z++) {
					field[i][j][z] = -1;
				}
			}
		}

		for (int i = 1; i < height + 1; i++) {
			sc.nextLine();
			for (int j = 1; j < lenght + 1; j++) {
				readedLine = sc.nextLine();
				for (int z = 0; z < readedLine.length(); z++) {
					if (readedLine.charAt(z) == '.') {
						field[i][j][z + 1] = 0;
					}
					if (readedLine.charAt(z) == 'o') {
						field[i][j][z + 1] = -1;
					}
					if (readedLine.charAt(z) == '1') {
						field[i][j][z + 1] = 1;
						xCoords.add(i);
						yCoords.add(j);
						zCoords.add(z + 1);
					}
					if (readedLine.charAt(z) == '2') {
						field[i][j][z + 1] = 0;
						princessCoordX = i;
						princessCoordY = j;
						princessCoordZ = z + 1;
					}
				}
			}
		}

		while (xCoords.size() > 0) {
			findNeighbours(field, xCoords, yCoords, zCoords);
		}

		int pathValue = field[princessCoordX][princessCoordY][princessCoordZ];

		writer.print(pathValue * 5 - 5);
		writer.flush();
		writer.close();
		sc.close();

	}

	private static void findNeighbours(int[][][] field, List<Integer> xCoords, List<Integer> yCoords,
			List<Integer> zCoords) {

		int x = xCoords.remove(0);
		int y = yCoords.remove(0);
		int z = zCoords.remove(0);

		if (field[x + 1][y][z] == 0) {
			field[x + 1][y][z] = field[x][y][z] + 1;
			xCoords.add(x + 1);
			yCoords.add(y);
			zCoords.add(z);
		}
		if (field[x][y + 1][z] == 0) {
			field[x][y + 1][z] = field[x][y][z] + 1;
			xCoords.add(x);
			yCoords.add(y + 1);
			zCoords.add(z);
		}
		if (field[x][y - 1][z] == 0) {
			field[x][y - 1][z] = field[x][y][z] + 1;
			xCoords.add(x);
			yCoords.add(y - 1);
			zCoords.add(z);
		}
		if (field[x][y][z + 1] == 0) {
			field[x][y][z + 1] = field[x][y][z] + 1;
			xCoords.add(x);
			yCoords.add(y);
			zCoords.add(z + 1);
		}
		if (field[x][y][z - 1] == 0) {
			field[x][y][z - 1] = field[x][y][z] + 1;
			xCoords.add(x);
			yCoords.add(y);
			zCoords.add(z - 1);
		}

	}

}
