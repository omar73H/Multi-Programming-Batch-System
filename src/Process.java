
public class Process extends Thread{

	public enum State{NEW,READY,RUNNING,BLOCKED,TERMINATED};
	
	State state;
	int ID;
	

	public Process(int ID) {
		this.ID = ID;
		this.state = State.NEW;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
