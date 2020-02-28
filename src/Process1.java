import java.io.IOException;

public class Process1 extends Process{

	
	public Process1() {
		super();
	}

	@Override
	public void run(){
		//Running state
		this.setState(state.RUNNING);
		
		Kernel.println("Please Enter the File Name:");
		String filePath = Kernel.takeString();
		if(!Kernel.isFile(filePath)) 
		{
			Kernel.println("The File Does Not Exist");
			this.setState(state.TERMINATED);
			return ;
		}
		
		if(Kernel.EmptyFile(filePath)) 
		{
			Kernel.print("The File is Empty");
			this.setState(state.TERMINATED);
			return ;
		}
		
		try 
		{
			Kernel.readFile(filePath);
			this.setState(state.TERMINATED);
		} 
		catch (IOException e) 
		{
			Kernel.println("Can NOT print The Data and there is an IO problem");
			this.setState(state.TERMINATED);
		}
	}
}