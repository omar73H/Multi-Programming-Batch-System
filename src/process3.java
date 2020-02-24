
public class process3 extends Thread{
	@Override
	public void run() {
		kernel kernel = new kernel();
		for (int i = 0; i <= 300; i++) {
			kernel.println(i+"");
		}
	}
}