
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		String basicLine = sc.nextLine();
		if (!basicLine.matches("[A-H][1-8][-][A-H][1-8]")) {
			writer.print("ERROR");
		} else {
			char[] charr = basicLine.toCharArray();
			if ((char) (charr[0] - 1) == charr[3] || (char) (charr[0] + 1) == charr[3]) {
				if ((char) (charr[1] + 2) == charr[4] || (char) (charr[1] - 2) == charr[4]) {
					writer.print("YES");
				}
			} else if ((char) (charr[0] - 2) == charr[3] || (char) (charr[0] + 2) == charr[3]) {
				if ((char) (charr[1] + 1) == charr[4] || (char) (charr[1] - 1) == charr[4]) {
					writer.print("YES");
				} else {
					writer.print("NO");
				}
			} else {
				writer.print("NO");
			}
		}

		writer.flush();
		sc.close();

	}

}
