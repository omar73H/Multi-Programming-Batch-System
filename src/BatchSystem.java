import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import systemCalls.*;

public class BatchSystem {

	static ArrayList<Runnable> processes ;
	
	public static void main(String[] args) throws Exception {
		
		
	
		processes = new ArrayList<Runnable>(5);
		
		//New State
		process1 p1 = new process1();
		process2 p2 = new process2();
//		process3 p3 = new process3();
//		process4 p4 = new process4();
		process5 p5 = new process5();
		
		
		//Ready State
		processes.add(p1);
		processes.add(p2);
//		processes.add(p3);
//		processes.add(p4);
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
			System.out.println("Please Enter the File Name:");
			String x = sc.nextLine();
			try 
			{
				ReadFileData readFileSysCall = new ReadFileData(x);	
				readFileSysCall.printData();
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("File Name does not exist");
			} 
			catch (IOException e) 
			{
				System.out.println("Cannot print the File data");
			}
		}
	}
	
	static class process2 extends Thread{

		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter the File Name");
			String x = sc.nextLine();
			File file = new File(x);
			if(!file.isFile()) {
				System.out.println("The File does not Exist");
				return;
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s , input = "";
			System.out.println("Please Start Writting The Content needed to be Written in The File and Then Press Enter Twice");
			try 
			{	
				while(( s = br.readLine()).length() > 0) 
				{
					input += (s + "\n");
				}
			}
			catch (IOException e) 
			{	
				System.out.println("You input data incorrectly");
			}
			
			try 
			{
				WriteData writeSysCall = new WriteData(x);
				writeSysCall.write(input);
				writeSysCall.endOfWrite();
			}
			catch (IOException e) 
			{
				System.out.println("Cannot write on that file");
			}
		}
		
	}
	
	//process3
	
	
	
	
	
	
	//process4
	
	
	
	
	
	
	
	static class process5 extends Thread{

		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter the Lower Bound Number:");
			int lo = sc.nextInt();
			System.out.println("Please Enter the Upper Bound Number:");
			int hi = sc.nextInt();
			for (int i = lo; i <= hi; i++)
				System.out.println(i);
		}
		
	}

}
