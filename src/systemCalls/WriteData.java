package systemCalls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteData {
	
	File file;
	BufferedWriter br;
	
	public WriteData(String filePath) throws IOException  {
		file = new File(filePath);
		br = new BufferedWriter(new FileWriter(file,true));
	}
	
	public void write(String data) throws IOException {
		br.write(data);
	}
	
	public void endOfWrite() throws IOException {
		br.close();
	}
}
