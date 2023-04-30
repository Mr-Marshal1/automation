package itstep.task4;

import java.util.ArrayList;
import java.util.List;

//c)	Create a generic class that can store a list of elements of any type, and add elements to it using List<T> and add().
public class Printer <T>{

    List<T> list=new ArrayList<>();
    public void add(T element){
        this.list.add(element);
    }
}