import java.util.Queue;

public abstract class Process extends Thread{

	
	private volatile state state;
	private int ID;
	static int counter=1;
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
			System.out.println("blocked    "+ this.getID());
			this.setState(state.BLOCKED);
		}
	}
	
	public void semPost(Semaphore semaphore) {
		if(this.getID() == semaphore.getOwnerID()) {
			if(semaphore.getWaitingProcesses().isEmpty())
				semaphore.setAvailable(true);
			else {
				Process temp = semaphore.getWaitingProcesses().poll();
				BatchSystem.getReady().add(temp);
				//temp.setState(state.READY);
				//System.out.println(temp.getID()+"55555555555555555555555");
				semaphore.setOwnerID(temp.getID());
			}
		}
	}

	@Override
	public abstract void run() ;


}
