package itstep_test.task_8;
import itstep.task2.Strings;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedStrings_test {

    //Task 1: Create 4 simple unit tests for Task_2
    // (modify your code to have 4 different methods in Task_2 solving if need).
    private Strings string1 = new Strings();

    @Parameters({ "name", "salary", "expectedOutput" })
    @Test
    public void testFormatString(String name, float salary, String expectedOutput){
        String actual = string1.formatString("Maksym", 2000.0f);
        Assert.assertEquals(actual ,expectedOutput, "unexpected result");
    }
}
