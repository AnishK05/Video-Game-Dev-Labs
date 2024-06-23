package programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWrite {
	private ArrayList<String> out = new ArrayList<String>();
	BufferedWriter writer;
	private String fileName;

	public FileWrite(String file) {
		fileName = file;
	}

	public void writeAppend() {
		try {
			writer = new BufferedWriter(new FileWriter(fileName, true)); //Instantiating Writer. Comma true makes it append.
			for (String data : out) {
				writer.write(data);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeOver() {
		try {
			writer = new BufferedWriter(new FileWriter(fileName)); //Since you are not appending, no need for true. 
			for (String data : out) {
				writer.write(data);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setData(String s) {
		out.add(s);
	}

	public void removeData(int i) {
		out.remove(i);
	}
}
