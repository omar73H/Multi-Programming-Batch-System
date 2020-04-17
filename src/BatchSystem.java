import java.util.LinkedList;
import java.util.Queue;

public class BatchSystem {

	static Queue<Process> Ready = new LinkedList<>() ;

	public static void main(String[] args) throws InterruptedException {
		Process3 p1 = new Process3();
	//	Process3 p2 = new Process3();
		//Process1 p2 = new Process1();
		Process4 p3 = new Process4();
	//	Process4 p4 = new Process4();
		//	Process1 p4 = new Process1();
		/*p1.start();
		p2.start();
		p3.start();
		p4.start();*/
		/*p1.start();
		p3.start();*/
		/*Ready.add(p1);
		Kernel.printSemaPhore.getWaitingProcesses().add(p3);*/
		/*while(!Ready.isEmpty() || !Kernel.NoBlockedProcesses() ){
			System.out.println("*******************************************************");
			Process p = Ready.poll();
			p.start();
		}*/
		simulate();
	}
	
	public static void simulate(){
		if(Ready.isEmpty())
			return ;
		Process p = Ready.poll();
		p.start();
		boolean next = false ;
		while(!Ready.isEmpty() || !Kernel.NoBlockedProcesses()){
			if(p.getCurrentState() == state.TERMINATED)
				next = true ;
			if(next){
				p = Ready.poll();
				if(p == null) continue;
				p.start();
				if (p.getCurrentState() == state.READY)
					p.start();
				else
					p.setState(state.RUNNING);
				next = false ;
			}
		}
	}

	public static Queue<Process> getReady() {
		return Ready;
	}

}
