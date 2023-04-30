package itstep.task2;


//Task 1: Create 4 simple unit tests for Task_2 (modify your code to have 4 different methods in Task_2 solving if need).
       // Task 2. Create testng.xml which should execute your test class. Execute this file
       // Task 3. add Data provider for each test
       // Task 4. Create a test with parameters loaded from testng.xml.

public class Strings {
        public static void main(String[] args) {
            String name = "hello";
            float salary = getSalary(1000.0f);
            String output = formatString(name, salary);
            printOutput(output);
        }

        public static String formatString(String name, float salary) {
            return String.format("My name is %s and my salary is %.1f", name, salary);
        }

        public static String printOutput(String output) {
            System.out.println(output);
            return output;
        }

        public static float getSalary(float input) {
            return input;
        }

        public static float calculateTax(float salary, float taxRate) {
            return salary * taxRate;
        }
}
