import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        List<String> directories = List.of("C:Games/src",
                "C:Games/res","C:Games/savegames",
                "C:Games/temp",
                "C:Games/src/test/","C:Games/src/main",
                "C:Games/res/drawables/",
                "C:Games/res/vectors/",
                "C:Games/reicons");
        for (int i = 0; i < directories.size(); i++) {
            createDirectory(directories.get(i));
        }
        createFile("C:Games/src/main/","Main.java");
        createFile("C:Games/src/main/","Utils.java");
        createFile("C:Games/temp/","temp.txt");

        try {
            FileWriter writer = new FileWriter("C:Games/temp/temp.txt",false);
            writer.write(String.valueOf(stringBuilder));
            writer.flush();
            writer.close();
        } catch (IOException exx){
            System.out.println(exx.getMessage());
        }
    }
    static void createDirectory(String path) {
        File file = new File(path);
        if (file.mkdir()) {
            stringBuilder.append("Директория " + path + " создана\n");
        } else {
            stringBuilder.append("Директория " + path + " не создана\n");
        }
    }

    static void createFile(String path, String fileName) {
        File file1 = new File(path+fileName);
        try {
            if (file1.createNewFile()) {
                stringBuilder.append("В директории " + path + " файл с именем " + fileName + " создан\n");
            }else {
                stringBuilder.append("В директории " + path + " файл с именем " + fileName + " не создан\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

