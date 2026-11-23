package dev.selenium.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties from " + CONFIG_PATH, e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key '" + key + "' not found in config.properties");
        }
        return value.trim();
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue).trim();
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static String getBrowser() {
        return get("browser", "chrome");
    }

    public static boolean isHeadless() {
        return getBoolean("headless");
    }

    public static int getImplicitWait() {
        return getInt("implicit.wait");
    }

    public static int getExplicitWait() {
        return getInt("explicit.wait");
    }

    public static int getPageLoadTimeout() {
        return getInt("page.load.timeout");
    }

    public static boolean screenshotOnFailure() {
        return getBoolean("screenshot.on.failure");
    }

    public static String getScreenshotDir() {
        return get("screenshot.dir", "target/screenshots");
    }
}
