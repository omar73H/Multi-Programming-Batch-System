import java.util.Queue;

public abstract class Process extends Thread{

	
	private state state;
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

	public state getCurrentState() {
		return state;
	}

	public void setState(state state) {
		this.state = state;
	}


	@SuppressWarnings("static-access")
	public Process() {
		ID = counter++;
	//	this.state = state.NEW;
		this.state = state.READY;
		BatchSystem.getReady().add(this);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public void semWait(Semaphore semaphore)  {
		if(semaphore.isAvailable()) {
			semaphore.setOwnerID(this.getID());
			semaphore.setAvailable(false);
		}
		else {
			semaphore.getWaitingProcesses().add(this);
			//System.out.println("blocked    "+ this.getID());
			this.setState(state.BLOCKED);
			//this.Wait();
			System.out.println("wait *****************************************");
		}
	}
	
	public void semPost(Semaphore semaphore) {
		if(this.getID() == semaphore.getOwnerID()) {
			if(semaphore.getWaitingProcesses().isEmpty())
				semaphore.setAvailable(true);
			else {
				Process temp = semaphore.getWaitingProcesses().poll();
				BatchSystem.getReady().add(temp);
				//temp.setState(state.RUNNING);
				//System.out.println(temp.getID()+"55555555555555555555555");
				System.out.println("post ****************************");
				semaphore.setOwnerID(temp.getID());
			}
		}
	}

	@Override
	public abstract void run() ;


}
