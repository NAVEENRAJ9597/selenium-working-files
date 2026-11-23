package dev.selenium.tests.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoreTasks {

    /**
     * TASK: Write a test that retrieves all cookies via driver.manage().getCookies(),
     * prints them out, clears them all via deleteAllCookies(), 
     * and asserts the cookie set size is 0.
     */
    @Test
    @Deprecated
    @DisplayName("TASK: Read and Delete all cookies")
    public void taskReadAndDeleteCookies() {
        // TODO: Implement this task
    }
    
    /**
     * TASK: Implement a Configuration test that asserts 
     * dev.selenium.config.ConfigReader correctly retrieves the "browser" property.
     */
    @Test
    @Deprecated
    @DisplayName("TASK: Config Properties Verification")
    public void taskConfigProperties() {
        // TODO: Implement this task
    }

    /**
     * TASK: Implement a test utilizing the dev.selenium.utils.ScreenshotUtil
     * to capture a screenshot of the Hero Section on the HomePage.
     */
    @Test
    @Deprecated
    @DisplayName("TASK: Capture an Element Screenshot")
    public void taskElementScreenshot() {
        // TODO: Implement this task
    }
}
