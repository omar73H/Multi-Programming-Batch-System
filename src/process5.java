import java.io.IOException;

public class process5 extends Thread{

	@Override
	public void run() {
		kernel kernel = new kernel();
		kernel.println("Please Enter the Lower Bound Number:");
		int lo = kernel.takeInt();
		kernel.println("Please Enter the Upper Bound Number:");
		int hi = kernel.takeInt();
		String data = "";
		for (int i = lo; i <= hi; i++)
			data += i+"\n";
		String filePath = lo+"-to-"+hi+".txt";
		if(kernel.isFileExists(filePath)) {
			System.out.println("The Requested File to be Created is Already Exist , to view it try to use process 1 and its Name is "+filePath);
			return;
		}
		try {
			kernel.createFile(filePath);
		} catch (IOException e) {e.printStackTrace();}
		try {
			kernel.WriteData(filePath, data);
			kernel.println("The Task is Done and The File With required Data is Created");
		} catch (IOException e) {e.printStackTrace();}
		
	}
}
