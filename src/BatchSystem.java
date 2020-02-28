
import java.util.ArrayList;




public class BatchSystem {

	static ArrayList<Runnable> processes ;
	
	public static void main(String[] args) {
		
		
	
		processes = new ArrayList<Runnable>();
		
		//New State
		Process1 p1 = new Process1();
		Process2 p2 = new Process2();
		Process3 p3 = new Process3();
		Process4 p4 = new Process4();
		Process5 p5 = new Process5();
		
		//System.out.println(p1.getCurrentState());
		
		//Ready State
		processes.add(p1);
		p1.setState(state.READY);
		
		processes.add(p2);
		p2.setState(state.READY);
		
		processes.add(p3);
		p2.setState(state.READY);
		
		processes.add(p4);
		p2.setState(state.READY);
		
		processes.add(p5);
		p2.setState(state.READY);
		
		
		
		//Test 
		//((Process1)p1).start();
		((Process2)p2).start();
		//((Process3)p3).start();
		//((Process4)p4).start();
		//((Process5)p5).start();
		
		//Running & Blocked & Finished states
		simulate();
		//File file = new File("os1.txt");
		//System.out.println(file.exists());
	}
	
//	// this Methode TODO on Milestone 2 ISA
//	@SuppressWarnings("deprecation")
	public static void simulate() {
		//simulates the processes and synchronizes the I/O recourses
		//TODO
	//	Runnable p = processes.get(4);
		//Runnable p3 = processes.get(2);
		//System.out.println(p instanceof process2);
	//	((process5)(p)).start();
		//((process3)(p3)).start();
		//System.out.println("********************");
	//	((process1)(p)).resume();

	}
}
