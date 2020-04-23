import java.io.IOException;



public class Process5 extends Process{

	
	public Process5() {
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

		Kernel.println("Please Enter the Lower Bound Number:");
		int lo = Kernel.takeInt();
		Kernel.println("Please Enter the Upper Bound Number:");
		int hi = Kernel.takeInt();

		this.semPost(Kernel.printSemaPhore);
		this.semPost(Kernel.takeInputSemaphore);

		String data = "";
		for (int i = lo; i <= hi; i++)
		{
			data += i+"\n";
		}
		String filePath = lo+"-to-"+hi+".txt";
		
		if(Kernel.isFileExists(filePath)) 
		{
			this.semWait(Kernel.printSemaPhore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.println("The Requested File to be Created is Already Exist , to view it try to use process 1 and its Name is "+filePath);

			this.semPost(Kernel.printSemaPhore);
			this.setState(ProcessState.TERMINATED);
			return;
		}
		try 
		{
			if(!Kernel.createFile(filePath))
			{
				this.semWait(Kernel.printSemaPhore);
				while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

				Kernel.println("Cannot create a file with name: "+filePath);

				this.semPost(Kernel.printSemaPhore);
				this.setState(ProcessState.TERMINATED);
				return;
			}
		}
		catch (IOException e) 
		{
			this.semWait(Kernel.printSemaPhore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.println("Cannot create a file with name: "+filePath);

			this.semPost(Kernel.printSemaPhore);

			this.setState(ProcessState.TERMINATED);
			return;
		}
		
		try 
		{
			this.semWait(Kernel.writeSemaphore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}
			this.semWait(Kernel.printSemaPhore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.WriteData(filePath, data);
			Kernel.println("The Task is Done and The File With required Data is Created");

			this.semPost(Kernel.writeSemaphore);
			this.semPost(Kernel.printSemaPhore);
			
			this.setState(ProcessState.TERMINATED);
		}
		catch (IOException e)
		{
			this.semWait(Kernel.printSemaPhore);
			while(true){ if (this.getCurrentState() == ProcessState.RUNNING) break ;}

			Kernel.println("Cannot write the count in a new file");

			this.semPost(Kernel.printSemaPhore);
			
			this.setState(ProcessState.TERMINATED);
		}
		
	}
}
