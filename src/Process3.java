
public class Process3 extends Process{
	
	
	public Process3() {
		super();
	}

	@Override
	public void run() {
		//Running state
		this.setState(state.RUNNING);
				
		this.semWait(Kernel.printSemaPhore);
		while(true){ if (this.getCurrentState() == state.RUNNING) break ;}
		//System.out.println("here***********************************");
		for (int i = 0; i <= 300; i++) 
		{
			Kernel.println(i+"");
		}
		this.semPost(Kernel.printSemaPhore);
		
		this.setState(state.TERMINATED);
	}
}