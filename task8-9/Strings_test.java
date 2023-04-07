package itstep_test.task_8;
import itstep.task2.Strings;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Strings_test {

    //Task 1: Create 4 simple unit tests for Task_2 (modify your code to have 4 different methods in Task_2 solving if need).
   // Task 2. Create testng.xml which should execute your test class. Execute this file
   // Task 3. add Data provider for each test
   // Task 4. Create a test with parameters loaded from testng.xml.
         //   Hint: url how to do it
    private Strings string1 = new Strings();

    @Test
    public void testFormatString(){
        String expectedOutput = "My name is hello and my salary is 5,0";
        String actual = string1.formatString("hello", 5);
        Assert.assertEquals(actual ,expectedOutput, "unexpected result");
    }
    @Test
    public void testPrintOutput(){
        String expectedOutput = "someString";
        String actual = string1.printOutput("someString");
        Assert.assertEquals(actual ,expectedOutput, "unexpected result");
    }

    @Test
    public void testGetSalary(){
        float expectedOutput = 1000.0f;
        float actual = string1.getSalary(1000.0f);
        Assert.assertEquals(actual ,expectedOutput, "unexpected result");
    }
    @Test
    public void testCalculateTax(){
        float expectedOutput = 200;
        float actual = string1.calculateTax(1000, 0.2f);
        Assert.assertEquals(actual ,expectedOutput, "unexpected result");
    }
}
