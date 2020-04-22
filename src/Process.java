

public abstract class Process extends Thread{

	
	private ProcessState state;
	private int ID;
	static int counter=1;
	private boolean waiting ;

	public  void Wait(){
		this.waiting = true ;
		while(this.waiting);
	}

	public void  Resume (){
		this.waiting = false ;
	}

	public ProcessState getCurrentState() {
		return state;
	}

	public void setState(ProcessState state) {
		this.state = state;
	}


	public Process() {
		ID = counter++;
	//	this.state = state.NEW;
		this.state = ProcessState.READY;
		BatchSystem.getReady().add(this);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public void semWait(Semaphore semaphore)  {
		if(semaphore.isAvailable()) 
		{
			semaphore.setOwnerID(this.getID());
			semaphore.setAvailable(false);
		}
		else 
		{
			semaphore.getWaitingProcesses().add(this);
			this.setState(ProcessState.BLOCKED);
		}
	}
	
	public void semPost(Semaphore semaphore) {
		if(this.getID() == semaphore.getOwnerID()) 
		{
			if(semaphore.getWaitingProcesses().isEmpty())
				semaphore.setAvailable(true);
			else 
			{
				Process p = semaphore.getWaitingProcesses().poll();
				BatchSystem.getReady().add(p);
				semaphore.setOwnerID(p.getID());
			}
		}
	}

	@Override
	public abstract void run() ;


}
