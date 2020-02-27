
public class Process3 extends Process{
	
	
	public Process3(int ID) {
		super(ID);
	}

	@Override
	public void run() {
		//Running state
		this.state = State.RUNNING;
				
		for (int i = 0; i <= 300; i++) 
		{
			Kernel.println(i+"");
		}
		
		this.state = State.TERMINATED;
	}
}