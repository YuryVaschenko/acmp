import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		sc.nextLine();
		String basicLine = sc.nextLine();
		String[] dividedString = basicLine.split(" ");

		int tmp = 0;
		int evenCount = 0;
		int oddCount = 0;
		StringBuilder evenString = new StringBuilder();
		StringBuilder oddString = new StringBuilder();

		for (String num : dividedString) {
			tmp = Integer.valueOf(num);

			if (tmp % 2 == 0) {
				evenString.append(num + " ");
				evenCount++;
			} else {
				oddString.append(num + " ");
				oddCount++;
			}
		}

		writer.println(oddString.toString().trim());
		writer.println(evenString.toString().trim());
		if (evenCount >= oddCount) {
			writer.print("YES");
		} else {
			writer.print("NO");
		}
		writer.flush();
		sc.close();

	}

}
