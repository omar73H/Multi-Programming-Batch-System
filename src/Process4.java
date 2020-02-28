
public class Process4 extends Process{
	
	
	public Process4() {
		super();
	}

	@Override
	public void run() {
		//Running state
		this.setState(state.RUNNING);
		
		for (int i = 500; i <= 1000; i++) 
		{
			Kernel.println(i+"");
		}
		
		this.setState(state.TERMINATED);
	}
}