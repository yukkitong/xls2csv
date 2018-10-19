package kr.co.uniess.kto.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMain {
  public static void main(String[] args) {
    try {
        String[] commands = {"java",  "-jar", "/home/jason/xls2csv-1.0.jar", "-i", "/data/xls/f7/46/41/b8/1b/f72f076c-46e6-412b-b898-1b2e342838a8.xls", "-s", "8", "0"};
        Process process = Runtime.getRuntime().exec(commands);        
        BufferedReader is = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        while((line = is.readLine()) != null) {
            System.out.println(line);
        }
        is.close();

        int exitCode = process.waitFor();
        System.out.println("exit code: " + exitCode);
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
  }
}
