package itstep.task4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

//V11.
//b)	Create your own custom class with a few constructors, and make an object for it.
// Use getDeclaredConstructors() to print out all the constructors of the class and their parameter types.
// Choose a specific constructor and create a new instance of the class using newInstance(). Print out your
// results or processing progress.

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Cars car = new Cars("Ferrari", "red", 300000);
        System.out.println("String Constructors are:");
        Constructor c[] = Cars.class.getDeclaredConstructors();
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        // Choose a specific constructor and create a new instance of the class using newInstance(). Print out your
        Cars cars = Cars.class.getDeclaredConstructor(String.class, String.class, int.class).newInstance("brand", "color", 666);
        System.out.println(cars.toString());

        //c)	Create a generic class that can store a list of elements of any type, and add elements to it using List<T> and add().
        Printer printer = new Printer();
        printer.add("hello");
        printer.add(5);
        System.out.println(printer.list);
    }

}