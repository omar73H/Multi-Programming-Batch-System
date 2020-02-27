import java.io.IOException;

public class Process1 extends Process{

	
	public Process1(int ID) {
		super(ID);
	}

	@Override
	public void run(){
		//Running state
		this.state = State.RUNNING;
		
		Kernel.println("Please Enter the File Name:");
		String filePath = Kernel.takeString();
		if(!Kernel.isFile(filePath)) 
		{
			Kernel.println("The File Does Not Exist");
			this.state = State.TERMINATED;
			return ;
		}
		
		if(Kernel.EmptyFile(filePath)) 
		{
			Kernel.print("The File is Empty");
			this.state = State.TERMINATED;
			return ;
		}
		
		try 
		{
			Kernel.readFile(filePath);
			this.state = State.TERMINATED;
		} 
		catch (IOException e) 
		{
			Kernel.println("Can NOT print The Data and there is an IO problem");
			this.state = State.TERMINATED;
		}
	}
}