package itstep.task3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
/*V11.
Array Reverse: Write a Java program that takes an array of integers and reverses its elements. Your program
should prompt the user to enter the array size and the elements of the array, and then output the reversed array.
*/
/* Make ArrayList from the result array and performs the following operations:
a) Add an element to the end of the list;
b) Remove an element from the list;
c) Replace an element in the list;
d) Sort the list in alphabetical order;
e) Print the elements of the list;
Make up the situation for NullPointerException. Catch it and display the explanation for your custom case */

public class Array_reverse {
    public static void main(String[] args) {
        Integer[] a;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = scanner.nextInt();
        a = new Integer[n];
        for(int i=0; i<a.length; i++) {
            System.out.println("Enter a [" + i + "] element");
            a[i] = scanner.nextInt();
        }
        Integer[] reversed = new Integer[n];
        int b = 0;
        for(int i=a.length-1; i>=0; i--){
            reversed[i] = a[b];
            b++;
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(reversed));
        list.add(55);
        list.remove(list.size()-1);
        list.set(0, 22);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        String str = null;
        System.out.println(str.length()); /* Отримуємо Exception, оскільки змінна не ссилається на жоден об'єкт і ми намагаємось з нею щось виконати" */
    }}