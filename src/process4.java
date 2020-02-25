
public class process4 extends Thread{
	@Override
	public void run() {
		kernel kernel = new kernel();
		for (int i = 500; i <= 1000; i++) {
			kernel.println(i+"");
		}
	}
}