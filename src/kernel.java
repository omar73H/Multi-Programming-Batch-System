import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class kernel {

	public kernel() {
		// TODO Auto-generated constructor stub
	}
	
	public int takeInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public String takeString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public void print(String x) {
		System.out.print(x);
	}
	
	public void println(String x) {
		System.out.println(x);
	}
	
	public void readFile(String filePath) throws IOException {
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String curr;
		while(br.ready()) 
		{
			curr = br.readLine();
			this.println(curr);
		}

	}
	
	public boolean isFile(String filePath) {
		File file = new File(filePath);
		return file.isFile();
	}

	public boolean isFileExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	} 
	public boolean EmptyFile(String filePath) {
		File file = new File(filePath);
		return file.length() == 0 ;
	}

	public void WriteData(String filePath , String data) throws IOException {
		File file = new File(filePath);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
		bw.write(data);
		bw.close();
	}
	
	public boolean createFile(String filePath) throws IOException {
		File file = new File(filePath);
		return file.createNewFile();
	}
}
