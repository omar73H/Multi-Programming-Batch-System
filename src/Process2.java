import java.io.IOException;



public class Process2 extends Process{

	
	
	public Process2() {
		super();
	}

	@Override
	public void run() {
		//Running state
		this.setState(state.RUNNING);
		
		
		Kernel.println("Please Enter the File Name");
		String filePath = Kernel.takeString();
//		if(!Kernel.isFile(filePath)) 
//		{
//			Kernel.println("The File does not Exist");
//			this.state = State.TERMINATED;
//			return;
//		}
//		
		
		String s , input = "";
		Kernel.println("Please Start Writting The Content needed to be Written in The File and Then Press Enter Twice");
		
		while(( s = Kernel.takeString()).length() > 0) 
		{
			input += (s + "\n");
		}
		
		try 
		{
			Kernel.WriteData(filePath, input);
			this.setState(state.TERMINATED);
		}
		catch (IOException e) 
		{
			Kernel.println("Cannot write data to this file");
			this.setState(state.TERMINATED);
		}
	}
	
}
