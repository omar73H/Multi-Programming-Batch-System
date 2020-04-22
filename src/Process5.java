
public class Process4 extends Process{
	
	
	public Process4() {
		super();
	}

	@Override
	public void run() {
		//Running state
		this.setState(ProcessState.RUNNING);
		
		this.semWait(Kernel.printSemaPhore);
		while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

		for (int i = 500; i <= 1000; i++) 
		{
			Kernel.println(i+"");
		}
		this.semPost(Kernel.printSemaPhore);
		
		this.setState(ProcessState.TERMINATED);
	}
}