package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {


    public static String loadProperty(String propertyName) throws IOException {
        InputStream inputStream =
                new FileInputStream("C:\\Users\\PC\\Desktop\\Selenium kurs\\AplikacjaHotelowaTesty\\AplikacjaHotelowaTesty\\src\\main\\test\\resources\\Config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
       return properties.getProperty(propertyName);
    }
}
