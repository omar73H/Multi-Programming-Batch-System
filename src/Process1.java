import java.io.IOException;

public class Process1 extends Process{

	
	public Process1() {
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

		Kernel.println("Please Enter the File Name:");
		String filePath = Kernel.takeString();

		this.semPost(Kernel.printSemaPhore);
		this.semPost(Kernel.takeInputSemaphore);
		
		if(!Kernel.isFile(filePath)) 
		{
			this.semWait(Kernel.printSemaPhore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.println("The File Does Not Exist");

			this.semPost(Kernel.printSemaPhore);
			
			this.setState(ProcessState.TERMINATED);
			return ;
		}
		
		if(Kernel.EmptyFile(filePath)) 
		{
			this.semWait(Kernel.printSemaPhore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.print("The File is Empty");

			this.semPost(Kernel.printSemaPhore);

			this.setState(ProcessState.TERMINATED);
			return ;
		}
		
		try 
		{
			this.semWait(Kernel.readSemaphore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.readFile(filePath);

			this.semPost(Kernel.readSemaphore);
			
			this.setState(ProcessState.TERMINATED);
		} 
		catch (IOException e) 
		{
			this.semWait(Kernel.printSemaPhore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.println("Can NOT print The Data and there is an IO problem");

			this.semPost(Kernel.printSemaPhore);
			
			this.setState(ProcessState.TERMINATED);
		}
	}
}