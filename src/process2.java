import java.io.BufferedReader;
import java.io.InputStreamReader;

public class process2 extends Thread{

	@Override
	public void run() {
		kernel kernel = new kernel();
		kernel.println("Please Enter the File Name");
		String filePath = kernel.takeString();
		if(!kernel.isFile(filePath)) {
			kernel.println("The File does not Exist");
			return;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s , input = "";
		kernel.println("Please Start Writting The Content needed to be Written in The File and Then Press Enter Twice");
		try 
		{	
			while(( s = br.readLine()).length() > 0) 
			{
				input += (s + "\n");
			}
		}
		catch (Exception e) {e.printStackTrace();}
		
		try 
		{
			kernel.WriteData(filePath, input);
		}
		catch (Exception e) {e.printStackTrace();}
	}
	
}
