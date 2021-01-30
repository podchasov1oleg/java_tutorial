package homework8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class InOutTest {
    private static char getRandomChar() {
        return (char) (Math.random() * (126 - 32) + 32);
    }

    public static void generateFiles(int count) throws IOException {
        FileOutputStream fos;
        for (int i = 0; i < count; i++) {
            File file = new File("test_files/test_file" + (i + 1) + ".txt");
            fos = new FileOutputStream(file);
            int contentLength = (int) (Math.random() * (100 - 50) + 50);
            for (int j = 0; j < contentLength; j++) {
                fos.write(getRandomChar());
            }
        }
    }

    public static void checkDir(File dir) {
        if (!dir.exists() && !dir.mkdir()) System.out.println("Не удалось создать директорию для тестовых файлов");
    }

    public static void concatFilesInFolder(File folder) throws IOException {
        File[] files = Objects.requireNonNull(folder.listFiles());
        String[] names = new String[files.length];
        FileInputStream fis;
        byte[][] content = new byte[files.length][];

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().contains("concat")) continue;

            content[i] = new byte[(int) files[i].length()];
            fis = new FileInputStream(files[i]);

            if (fis.read(content[i]) < 0) System.out.println("Конец файла");
            names[i] = (files[i].getName());
        }

        File result = new File("test_files/" + String.join("_and_", names) + "_concat.txt");
        FileOutputStream fos = new FileOutputStream(result);

        for (byte[] fileContent : content) {
            fos.write(fileContent);
        }
    }
}
