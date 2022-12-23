package FileUtils;
import Exceptions.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {
	String link ;
	public Reader(String link) {
		setLink(link);
	}
	public String [] readContentFile() throws NoFileToReadException {
		try {
			File file = new File (getLink());
	
			if(!file.exists()) {
				
				System.out.println("no file to read");
				throw new NoFileToReadException() ;
			}else {
				BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
				String line = reader.readLine();
				ArrayList<String> contents = new ArrayList<String>();
				while(line != null) {
					contents.add(line);
					line =reader.readLine();
				}
				reader.close();
				System.out.println("vita");
				return contents.toArray(new String [contents.size()]);
			}
		} catch (IOException e) {
			if(e instanceof java.io.FileNotFoundException) throw new NoFileToReadException() ;
			return null;
		}
	}

	public String [] readContentFile(int nb) throws NoFileToReadException {
		try {
			File file = new File (getLink());
			if(!file.exists()) {
				System.out.println("no file to read");
				throw new NoFileToReadException() ;
			}else {
				int status =0 ;
				BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
				String line = reader.readLine();
				ArrayList<String> contents = new ArrayList<String>();
				while(status < nb) {
					contents.add(line);
					line =reader.readLine();
					status++;
				}
				reader.close();
				return contents.toArray(new String [contents.size()]);
			}
		} catch (IOException e) {
			if(e instanceof java.io.FileNotFoundException) throw new NoFileToReadException() ;
			return null;
		}
	}


	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
