package homework8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class LightGrep {

    public static boolean grepInFile(String str, String filepath) throws IOException {
        File file = new File(filepath);

        return grepInFile(str, file);
    }

    public static boolean grepInFile(String str, File file) throws IOException {
        if (!file.exists()) {
            System.out.println("Не найден файл по указанному пути");
            return false;
        }
        char[] chars = str.toCharArray();
        FileInputStream fis = new FileInputStream(file);
        int index = 0, current;
        while (index < chars.length - 1) {
            current = fis.read();
            if (current >= 0) {
                if ((char) current == chars[index]) {
                    index++;
                } else {
                    index = 0;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean grepInFolder(String str, String path) throws IOException {
        if (!(new File(path)).exists()) {
            System.out.println("Не найден файл по указанному пути");
            return false;
        } else if (!(new File(path)).isDirectory()) {
            System.out.println("Указанный путь не является директорией");
            return false;
        }
        boolean result;
        File[] files = Objects.requireNonNull((new File(path)).listFiles());

        for (File file : files) {
            result = file.isDirectory() ? grepInFolder(str, file.getPath()) : grepInFile(str, file);
            if (result) return true;
        }

        return false;
    }
}
