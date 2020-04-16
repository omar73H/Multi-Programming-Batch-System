
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;




public class BatchSystem {

	static Queue<Process> Ready = new LinkedList<>() ;

	public static void main(String[] args) {
		Process3 p1 = new Process3();
		Process4 p11 = new Process4();
		//System.out.println(p1.getID()+"  "+p11.getID());
		simulate();
	}
	
	public static void simulate(){
		while(!Ready.isEmpty() || !Kernel.NoBlockedProcesses()) {

			Process p = Ready.poll();
			System.out.println(p.getID()+"****************");
			if(p.getCurrentState() == state.READY)
				p.start();
			else if (p.getCurrentState() == state.BLOCKED)
				p.setState(state.RUNNING);
		}
	}

	public static Queue<Process> getReady() {
		return Ready;
	}

}
