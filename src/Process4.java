
public class Process4 extends Process{
	
	
	public Process4() {
		super();
	}

	@Override
	public void run() {
		//Running state
		this.setState(state.RUNNING);
		
		this.semWait(Kernel.printSemaPhore);
		//System.out.println(getCurrentState()+"0000000000000000000000000000");
		while(true){ if (this.getCurrentState() == state.RUNNING) break ;}
		System.out.println("here ****************************");
		for (int i = 500; i <= 1000; i++) 
		{
			Kernel.println(i+"");
		}
		this.semPost(Kernel.printSemaPhore);
		
		this.setState(state.TERMINATED);
	}
}