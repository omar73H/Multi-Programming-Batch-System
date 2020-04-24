import java.io.IOException;



public class Process2 extends Process{

	
	
	public Process2() {
		super();
	}

	@Override
	public void run() {
		//Running state
		this.setState(ProcessState.RUNNING);
		
		this.semWait(Kernel.printSemaPhore);
		while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}
		this.semWait(Kernel.takeInputSemaphore);
		while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

		Kernel.println("Please Enter the File Name");
		String filePath = Kernel.takeString();

		this.semPost(Kernel.printSemaPhore);
		this.semPost(Kernel.takeInputSemaphore);
		
//		if(!Kernel.isFile(filePath)) 
//		{
//			Kernel.println("The File does not Exist");
//			this.state = State.TERMINATED;
//			return;
//		}
//		
		
		String s , input = "";
		this.semWait(Kernel.printSemaPhore);
		while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}
		this.semWait(Kernel.takeInputSemaphore);
		while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}
		Kernel.println("Please Start Writting The Content needed to be Written in The File and Then Press Enter Twice");

		while(( s = Kernel.takeString()).length() > 0)
		{
			input += (s + "\n");
		}
		this.semPost(Kernel.printSemaPhore);
		this.semPost(Kernel.takeInputSemaphore);
		
		try 
		{
			this.semWait(Kernel.writeSemaphore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.WriteData(filePath, input);

			this.semPost(Kernel.writeSemaphore);
			
			this.setState(ProcessState.TERMINATED);
		}
		catch (IOException e) 
		{
			this.semWait(Kernel.printSemaPhore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.println("Cannot write data to this file");

			this.semPost(Kernel.printSemaPhore);
			
			this.setState(ProcessState.TERMINATED);
		}
	}
	
}
