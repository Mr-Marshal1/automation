package itstep.task8;

import itstep.task2.Strings;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedStrings_test {

    //Task 1: Create 4 simple unit tests for Task_2
    // (modify your code to have 4 different methods in Task_2 solving if need).
    private Strings string1 = new Strings();

    @Test(dataProvider = "testFormatStringProvider")
    public void testFormatString(String name, float salary, String expectedOutput){
        String actual = string1.formatString(name, salary);
        Assert.assertEquals(actual ,expectedOutput, "unexpected result");
    }

    @DataProvider(name = "testFormatStringProvider")
    public Object[][] provideTestData() {
        return new Object[][] {
                {"Maksym", 2000.0f, "My name is Maksym and my salary is 2000,0"},
                {"Andriy", 1000.0f, "My name is Andriy and my salary is 1000,0"},
                {"Sergiy", 500.0f, "My name is Sergiy and my salary is 500,0"},
                {"Yarik", 1200.0f, "My name is Yarik and my salary is 1200,0"},
                {"Lesyk", 1500.0f, "My name is Lesyk and my salary is 1500,0"}
        };
    }
}