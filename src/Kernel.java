import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Kernel {

	static Scanner sc;
	static BufferedReader br;
	static BufferedWriter bw;
	static Semaphore printSemaPhore = new Semaphore() ;
	static Semaphore readSemaphore = new Semaphore() ;
	static Semaphore writeSemaphore = new Semaphore() ;
	static Semaphore takeInputSemaphore = new Semaphore() ;
	
	public Kernel() {
	}
	
	public static int takeInt() {
		sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static String takeString() {
		sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static void print(String x) {
		System.out.print(x);
	}
	
	public static void println(String x) {
		System.out.println(x);
	}
	
	public static void readFile(String filePath) throws IOException {
		File file = new File(filePath);
		br = new BufferedReader(new FileReader(file));
		String curr = "";
		while(br.ready()) 
		{
			curr = br.readLine();
			println(curr);
		}
	}
	
	public static boolean isFile(String filePath) {
		File file = new File(filePath);
		return file.isFile();
	}

	public static boolean isFileExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}
	
	public static boolean EmptyFile(String filePath) {
		File file = new File(filePath);
		return file.length() == 0 ;
	}

	public static void WriteData(String filePath , String data) throws IOException {
		File file = new File(filePath);
		// set the flag with true if you like to append the data .. false to override it every time you write data
		bw = new BufferedWriter(new FileWriter(file,false));
		bw.write(data);
		bw.close();
	}
	
	public static boolean createFile(String filePath) throws IOException {
		File file = new File(filePath);
		return file.createNewFile();
	}

	public static boolean NoBlockedProcesses (){
		return  printSemaPhore.getWaitingProcesses().isEmpty() && takeInputSemaphore.getWaitingProcesses().isEmpty()
				&& readSemaphore.getWaitingProcesses().isEmpty() && writeSemaphore.getWaitingProcesses().isEmpty() ;
	}
	
}
