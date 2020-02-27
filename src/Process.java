
public class Process extends Thread{

	public enum State{NEW,READY,RUNNING,BLOCKED,TERMINATED};
	
	State state;
	int ID;
	static int counter=1;

	public Process() {
		ID = counter++;
		this.state = State.NEW;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
