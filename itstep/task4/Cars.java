package itstep.task4;

public class Cars {
    String brand;
    String color;
    int price;

    Cars(String brand, String color, int price){
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    Cars(String brand, String color){
        this.brand = brand;
        this.color = color;
    }

    Cars(String brand){
        this.brand = brand;
    }

    Cars(){}
    public String toString(){
        return String.format("%s , %s, %d", this.brand, this.color, this.price);
    }
}