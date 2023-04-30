package itstep.task8;

import itstep.task2.Strings;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderStrings_test {

    // Task 3. add Data provider for each test

    //1. parameters
    //2. dataprovider method
    //3. linking
    private Strings string1 = new Strings();

    @DataProvider(name = "testFormatStringProvider")
    private Object[][] testFormatStringProvider(){
        int n=5; // number of test data sets
        int m=3; // argument number (String name, float salary, String expectedOutput)
        Object[][] res = new Object[n][m];
        res[0]=new Object[]{"Maksym",2000.0f,"My name is Maksym and my salary is 2000,0"};
        res[1]=new Object[]{"Andriy",1000.0f,"My name is Andriy and my salary is 1000,0"};
        res[2]=new Object[]{"Sergiy",500.0f,"My name is Sergiy and my salary is 500,0"};
        res[3]=new Object[]{"Yarik",1200.0f,"My name is Yarik and my salary is 1200,0"};
        res[4]=new Object[]{"Lesyk",1500.0f,"My name is Lesyk and my salary is 1500,0"};
        return res;
    }

    @DataProvider
    private Object[][] testPrintOutputProvider(){
        int n=3; // number of test data sets
        int m=3; // argument number (String name, float salary, String expectedOutput)
        Object[][] res = new Object[n][m];
        res[0]=new Object[]{"hello", "hello"};
        res[1]=new Object[]{"gg", "gg"};
        res[2]=new Object[]{"wp", "wp"};
        return res;
    }

    @DataProvider
    private Object[][] testGetSalaryProvider(){
        int n=3; // number of test data sets
        int m=3; // argument number (String name, float salary, String expectedOutput)
        Object[][] res = new Object[n][m];
        res[0]=new Object[]{1000.0f, 1000.0f};
        res[1]=new Object[]{1200.0f, 1200.0f};
        res[2]=new Object[]{1300.0f, 1300.0f};
        return res;
    }

    @DataProvider
    private Object[][] testCalculateTaxProvider(){
        int n=3; // number of test data sets
        int m=3; // argument number (String name, float salary, String expectedOutput)
        Object[][] res = new Object[n][m];
        res[0]=new Object[]{1000.0f, 0.2f, 200.0f};
        res[1]=new Object[]{1500.0f, 0.3f, 450.0f};
        res[2]=new Object[]{2000.0f, 0.5f, 1000.0f};
        return res;
    }

    @Test(dataProvider = "testFormatStringProvider")
    public void testFormatString(String name, float salary, String expectedOutput) {
        String actualOutput = string1.formatString(name, salary);
        Assert.assertEquals(actualOutput, expectedOutput);
    }

    @Test(dataProvider = "testPrintOutputProvider")
    public void testPrintOutput(String output, String expectedOutput){
        String actual = string1.printOutput(output);
        Assert.assertEquals(output ,expectedOutput, "unexpected result");
    }

    @Test(dataProvider = "testGetSalaryProvider")
    public void testGetSalary(Object[] testData){
        float input = (float) testData[0];
        float expectedOutput = (float) testData[1];
        float actual = string1.getSalary(input);
        Assert.assertEquals(actual, expectedOutput, "unexpected result");
    }
    @Test(dataProvider = "testCalculateTaxProvider")
    public void testCalculateTax(float salary, float taxRate, float expectedOutput) {
        float actual = string1.calculateTax(salary, taxRate);
        Assert.assertEquals(actual, expectedOutput, 0.001f, "unexpected result");
    }
}