package org.example.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class Base2 {


    @Test(priority = 1)
    void testText4() {
        System.out.println(">>> Testing text4");
    }

    @Test(priority = 3, dependsOnMethods = {"testText4"})
    void testText5() {
        System.out.println(">>> Testing text5");
    }

    @Test(priority = 2)
    void testText6() {
        System.out.println(">>> Testing text6");
    }

}
