package by.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		writer.println(a + b);
		writer.flush();
		writer.close();
		sc.close();
		
	}

}
