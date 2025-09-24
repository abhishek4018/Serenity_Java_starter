package starter.helpers;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PageConfigs {
    private static final Properties properties = new Properties();

    static {
        String environment = System.getProperty("environment", "default").trim();
        String resource = "pages/pages-" + environment + ".properties";
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource)) {
            if (in == null) {
                throw new IllegalStateException("Page properties not found on classpath: " + resource);
            }
            properties.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load page properties: " + resource, e);
        }
    }

    public static String get(String key) {
        return Optional.ofNullable(properties.getProperty(key))
                .orElseThrow(() -> new IllegalArgumentException("Missing page property key: " + key));
    }
}


