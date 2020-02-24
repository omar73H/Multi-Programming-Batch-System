import java.io.IOException;

public class process1 extends Thread{

	@Override
	public void run(){
		kernel kernel = new kernel();
		kernel.println("Please Enter the File Name:");
		String filePath = kernel.takeString();
		if(!kernel.isFile(filePath)) {
			kernel.println("The File Does Not Exist");
			return ;
		}
		if(kernel.EmptyFile(filePath)) {
			kernel.print("The File is Empty");
			return ;
		}
		try {
			kernel.readFile(filePath);
		} catch (IOException e) {
			kernel.println("Can NOT print The Data");
			e.printStackTrace();
		}
	}
}