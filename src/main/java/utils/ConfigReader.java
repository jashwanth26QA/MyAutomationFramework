package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties intiliaseProperties() throws IOException {

        Properties prop=new Properties();
        File f=new File(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
        FileInputStream fis=new FileInputStream(f);
        prop.load(fis);
        return prop;
    }
}
