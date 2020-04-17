import java.util.LinkedList;
import java.util.Queue;

public class BatchSystem {

	static Queue<Process> Ready = new LinkedList<>() ;

	public static void main(String[] args) {
		Process3 p1 = new Process3();
		Process1 p2 = new Process1();
		Process4 p3 = new Process4();
		Process1 p4 = new Process1();
		simulate();
	}
	
	public static void simulate(){
		if(Ready.isEmpty())
			return ;
		Process p = Ready.poll();
		p.start();
		boolean next = false ;
		while(!Ready.isEmpty()){
			if(p.getCurrentState() == state.TERMINATED)
				next = true ;
			if(next){
				p = Ready.poll();
				p.start();next = false ;
			}
		}
	}

	public static Queue<Process> getReady() {
		return Ready;
	}

}
