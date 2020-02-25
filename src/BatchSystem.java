import java.util.ArrayList;

public class BatchSystem {

	static ArrayList<Runnable> processes ;
	
	public static void main(String[] args) throws Exception {
		
		
	
		processes = new ArrayList<Runnable>(5);
		
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
		//File file = new File("os1.txt");
		//System.out.println(file.exists());
	}
	
	// this Methode TODO on Milestone 2 ISA
	@SuppressWarnings("deprecation")
	public static void simulate() throws Exception {
		//simulates the processes and synchronizes the I/O recourses
		//TODO
		Runnable p = processes.get(4);
		//Runnable p3 = processes.get(2);
		//System.out.println(p instanceof process2);
		((process5)(p)).start();
		//((process3)(p3)).start();
		//System.out.println("********************");
	//	((process1)(p)).resume();

	}
}
