package itstep.task_2;

public class Formatting_Strings {
    public static void main(String[] args) {
        String name = "hello";
        float salary = 1000;
        String s = String.format("My name is %s and my salary is %s", name, salary);
        System.out.println(s);
    }
}
