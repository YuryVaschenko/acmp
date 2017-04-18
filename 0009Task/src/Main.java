import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		sc.nextLine();
		String basicLine = sc.nextLine();
		String[] dividedString = basicLine.split(" ");

		List<Integer> basicList = new ArrayList<>();
		int number = 0;
		int sum = 0;
		int min = Integer.valueOf(dividedString[0]);
		int max = min;
		int min_index = 0;
		int max_index = 0;

		for (int i = 0; i < dividedString.length; i++) {
			number = Integer.valueOf(dividedString[i]);
			if (number > 0) {
				sum += number;
			}
			if (min > number) {
				min = number;
				min_index = i;
			}
			if (max < number) {
				max = number;
				max_index = i;
			}
			basicList.add(number);
		}

		if (min_index > max_index) {
			int tmp = max_index;
			max_index = min_index;
			min_index = tmp;
		}

		int mult = 1;

		for (int i = min_index + 1; i < max_index; i++) {
			mult *= basicList.get(i);
		}

		writer.print(sum + " " + mult);
		writer.flush();
		sc.close();

	}

}
