
public class Process3 extends Process{
	
	
	public Process3() {
		super();
	}

	@Override
	public void run() {
		//Running state
		this.setState(state.RUNNING);
				
		for (int i = 0; i <= 300; i++) 
		{
			Kernel.println(i+"");
		}
		
		this.setState(state.TERMINATED);
	}
}