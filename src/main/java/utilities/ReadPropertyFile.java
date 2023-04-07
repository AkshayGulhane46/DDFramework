package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\akshay.gulhane\\IdeaProjects\\TestNGDemo_Maven\\src\\main\\java\\resources\\config.properties");
        Properties p = new Properties();
        p.load(fr);

        System.out.println(p.get("browser"));
        System.out.println(p.get("testURL"));
    }
}
