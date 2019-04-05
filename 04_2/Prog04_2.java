package prog_assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Prog04_2 {
	static String type = null;
	static Diamond[] arr = new Diamond[1000000];
	static int n = 0;
	private static Scanner file;
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);		
		while(true) {
			System.out.print("$ ");;
			String command = kb.next();
			String str;
			if(command.equals("read")) {
				str = kb.next();
				read(str);
			}
			else if (command.equals("sort")) {
				str = kb.next();
				type = str;
				sort(str);
			}
			else if (command.equals("print")) {
				print();
			}
			else if (command.equals("exit"))
				break;
		}
		kb.close();
	}

	private static void sort(String str) {		
		if(str.equals("-ip"))
			sortIp();
		else if(str.equals("-t"))
			sortTime();
	}

	private static void print() {
		if(type.equals("-ip"))
			printIp();
		else if(type.equals("-t"))
			printTime();
	}

	private static void printTime() {
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i].Time);
			System.out.println("    IP : " + arr[i].IP);
			System.out.println("    URL : " + arr[i].URL);
			System.out.println("    Status : " + arr[i].Status);
		}
	}

	private static void printIp() {
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i].IP);
			System.out.println("    Time : " + arr[i].Time);
			System.out.println("    URL : " + arr[i].URL);
			System.out.println("    Status : " + arr[i].Status);
		}
	}

	private static void read(String str) {
		try {
			file = new Scanner(new File(str));
			String line = file.nextLine();
			while(file.hasNext()) {
				line = file.nextLine();
				arr[n++] = new Diamond(line.split(",")[0], 
						line.split(",")[1].substring(1), 		// [ »©±â
						line.split(",")[2], line.split(",")[3]);
			}
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		}
	}

	private static void sortTime() {
		Arrays.sort(arr, 0, n, Diamond.TimeComparator);
	}

	private static void sortIp() {
		Arrays.sort(arr, 0, n, Diamond.IpComparator);
	}

}
