package FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	public void createTheFile(String link) throws IOException{
		new File(link).createNewFile();
	}
	public void saveInFile(String score,String link) throws IOException {

		File file = new File (link);
		if(!file.exists()) {
			file.createNewFile();
		}else {
			FileWriter writer = new FileWriter(file,true)	;
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(score);
			bw.newLine();
			bw.close();
			writer.close();
		}
	}
	public void deleteAllInFile(String link) throws IOException {
		File file = new File (link);
		if(!file.exists()) {
			file.createNewFile();
		}else {
			new FileWriter(file).close();	;
		}
	}

}
