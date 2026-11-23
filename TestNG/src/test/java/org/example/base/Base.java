package org.example.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Base {

    @BeforeSuite
    void preprocess() {
        System.out.println(">>> @BeforeSuite: Executes before tests in the suite.");
    }

    @Test
    void testText1() {
        System.out.println(">>> Testing text1");
    }

    @Test
    void testText2() {
        System.out.println(">>> Testing text2");
    }

    @Test
    void testText3() {
        System.out.println(">>> Testing text3");
    }

    @AfterSuite
    void postprocess() {
        System.out.println(">>> @AfterSuite: Executes after tests in the suite.");
    }
}
