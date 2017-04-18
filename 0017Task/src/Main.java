
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		sc.nextLine();
		String[] template = sc.nextLine().split(" ");
		int[] array = new int[template.length - 1];

		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.valueOf(template[i]);
		}

		int result = calculate(array);

		writer.print(result);
		writer.flush();

	}

	private static int calculate(int[] source) {

		int lengthIndex = 0;
		boolean flag = false;

		for (int i = 1; i <= source.length / 2; i++) {
			if (source.length % i == 0) {

				flag = true;

				for (int j = 1; j < source.length - i; j++) {
					if (source[j] != source[j + i]) {
						flag = false;
						break;
					}
				}

				if (flag) {
					lengthIndex = i;
					break;
				}
			}
		}
		if (lengthIndex == 0) {
			lengthIndex = source.length;
		}

		return lengthIndex;

	}

}
