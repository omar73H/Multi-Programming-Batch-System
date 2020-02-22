package systemCalls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadFileData {

	BufferedReader br;
	File file;
	
	public ReadFileData(String filePath) throws FileNotFoundException {
		file = new File(filePath);
		br = new BufferedReader(new FileReader(file));
	}
	
	public void printData() throws IOException {
		if(file.length() == 0) 
		{
			System.out.println("The File is Empty");
			return;
		}
		
		String curr;
		while(br.ready()) 
		{
			curr = br.readLine();
			System.out.println(curr);
		}
		
	}
}
