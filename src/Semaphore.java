import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {
	
	private boolean isAvailable ;
	private int ownerID ;
	private Queue<Process> waitingProcesses ;
	
	public Semaphore () {
		this.isAvailable = true ;
		this.ownerID  = -1 ; // not owned
		waitingProcesses = new LinkedList<>();
	}

	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public int getOwnerID() {
		return ownerID;
	}


	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}


	public Queue<Process> getWaitingProcesses() {
		return waitingProcesses;
	}


	public void setWaitingProcesses(Queue<Process> waitingProcesses) {
		this.waitingProcesses = waitingProcesses;
	}

}
