
public class Process extends Thread{

	
	private state state;
	public state getCurrentState() {
		return state;
	}

	public void setState(state state) {
		this.state = state;
	}

	int ID;
	static int counter=1;

	@SuppressWarnings("static-access")
	public Process() {
		ID = counter++;
		this.state = state.NEW;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
