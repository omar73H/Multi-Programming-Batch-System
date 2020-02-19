import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BatchSystem {

	static ArrayList<Runnable> processes ;
	
	public static void main(String[] args) throws Exception {
		
		processes = new ArrayList<Runnable>();
		
		//New State
		process1 p1 = new process1();
		process2 p2 = new process2();
		process3 p3 = new process3();
		process4 p4 = new process4();
		process5 p5 = new process5();
		
		//Ready State
		processes.add(p1);
		processes.add(p2);
		processes.add(p3);
		processes.add(p4);
		processes.add(p5);
		
		//Running & Blocked & Finished states
		simulate();
	}
	
	// this Methode TODO on Milestone 2 ISA
	@SuppressWarnings("deprecation")
	public static void simulate() throws Exception {
		//simulates the processes and synchronizes the I/O recourses
		//TODO
		//Runnable p2 = processes.get(1);
		//Runnable p3 = processes.get(2);
		//System.out.println(p instanceof process2);
		//((process2)(p2)).start();
		//((process3)(p3)).start();
		//System.out.println("********************");
	//	((process1)(p)).resume();

	}
	
	static class process1 extends Thread{

		@Override
		public void run(){
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter the File Name");
			String x = sc.nextLine();
			File file = new File(x);
			if(!file.isFile()) {
				System.out.println("The File does not Exist");
				return;
			}
			if(file.length() == 0) {
				System.out.println("The File Is Empty");
				return;
			}
			try {
				FileReader fileReader = new FileReader(file);
				BufferedReader br = new BufferedReader(fileReader);
				String curr ;
				while((curr = br.readLine()) != null) {
					System.out.println(curr);
				}
			} catch (Exception e) {}
		}
		
	}
	
	static class process2 extends Thread{

		@Override
		public void run() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter the File Name");
			String s = sc.nextLine();
			File file = new File(s);
			if(!file.isFile()) {
				System.out.println("The File does not Exist");
				return;
			}
			String x , input = "";
			System.out.println("Please Start Writting The Content You need to be Written in The File and Then Press Enter Twice");
			try {
				while(( x = br.readLine()).length() > 0) {
					input += x + "\n" ;
				}
			} catch (IOException e) {}
			
			
			try {
				FileWriter writer = new FileWriter( file , true );
				BufferedWriter bw = new BufferedWriter(writer);
				bw.write(input);
				bw.close();
			} catch (Exception e) {}
			
		}
		
	}
	
	static class process3 extends Thread{

		@Override
		public void run() {
			for (int i = 0; i <= 300 ; i++)
				System.out.println(i);
		}
		
	}
	
	static class process4 extends Thread{

		@Override
		public void run() {
			for (int i = 500; i <= 1000 ; i++)
				System.out.println(i);
		}
		
	}
	
	static class process5 extends Thread{

		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter the Lower Bound Number");
			int lo = sc.nextInt();
			System.out.println("Please Enter the Upper Bound Number");
			int hi = sc.nextInt();
			for (int i = lo; i <= hi; i++)
				System.out.println(i);
		}
		
	}

}
