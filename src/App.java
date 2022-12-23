import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import FileUtils.Reader;
import FileUtils.Writer;
import Server_Repo.ServerPart1;

public class App {

    public static void main(String[] args) throws Exception {
       
        System.out.println( new File("").getAbsolutePath());
    }
    static boolean get_port( ArrayList<Integer> list_port,String d){
        String temp = d ;
        int size = Integer.valueOf( d.substring(d.indexOf(":")+1, d.indexOf(":")+2));
        String regex=  "|";
        for (int i = 0; i < size; i++) {
            temp = temp.substring(temp.indexOf(regex)+1);
            if(list_port.indexOf(Integer.valueOf(temp.substring(0, temp.indexOf(","))))==-1) return false;
            regex=",";
        }
        return true ;
    }
}

