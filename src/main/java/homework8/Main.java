package homework8;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File dir = new File("test_files");

        InOutTest.checkDir(dir);

        //п.1
        try {
            InOutTest.generateFiles(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //п.2
        try {
            InOutTest.concatFilesInFolder(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //п.3
        try {
            System.out.println(LightGrep.grepInFile("someRandomString", "src/main/java/homework8/LightGrep.java"));
            System.out.println(LightGrep.grepInFile("lightGrepFile", "src/main/java/homework8/LightGrep.java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //п.4
        try {
            System.out.println(LightGrep.grepInFolder("test_files", "src/main/java/homework8"));
            System.out.println(LightGrep.grepInFolder("someRandomString", "src/main/java/homework7"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
