package itstep.task5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.awt.Color.*;

public class Streamtask {
    public static void main(String[] args) {
        //Stream:
        //a) Generate 10 random object using class from previous class
        // b) Sort it using any two fields using stream.
        // b) Filter it by any two fields custom filter.
        //c) Collect it to List with *main field(s).

        // 3. Write a maven command for executing one of your tasks with arguments (number of elements).
        Integer n = 10;
        if(args.length>0){
            try{
                n = Integer.parseInt(args[0]);} catch(Exception e) {
                System.out.println("cant parse int from " + args[0]);
                e.printStackTrace();
            }
        }

        // step 1 generate 10 objects
        List<Color> colorList = generateColorList(10);
        System.out.println(colorList);

        // step 2 sort
        System.out.println("Sort");
        System.out.println(colorList.stream().sorted().collect(Collectors.toList()));
        System.out.println(colorList.stream().sorted(new Comparator<Color>() {
            @Override
            public int compare(Color o1, Color o2) {
                return Boolean.compare(o1.GetIsPrimary(), o2.GetIsPrimary()) * o1.getRgb().get("r").compareTo(o2.getRgb().get("r"));
            }
        }).collect(Collectors.toList()));

        // step 3 filter
        System.out.println("filter");
        System.out.println(colorList.stream().filter(color -> color.getColors().stream()
                        .anyMatch(primalColor -> primalColor.contains("1")) && color.GetIsPrimary())
                .collect(Collectors.toList()));

        // step 4 mapping
        System.out.println("List");
        List<String> nameList = colorList.stream()
                .map(obj -> obj.getColors() + ", " + obj.GetIsPrimary() + ", " + obj.getRgb())  // extract only the "name" field
                .collect(Collectors.toList());  // collect the result to a new List<String>
        System.out.println(nameList);


        // #run main method
        //  C:\Users\MARSHAL\.m2\mvn clean install exec:java -Dexec.mainClass="itstep.task_5.Streamtask" -Dexec.args="5"
    }





    private static List<Color> generateColorList(int count) {
        Random random = new Random();
        List<Color> colorList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Color color = new Color();
            List<String> colors = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                colors.add(String.format("#%06X", random.nextInt(0xFFFFFF + 1)));
            }
            color.setColors(colors);
            color.setIsPrimary(random.nextBoolean());
            HashMap<String, Integer> rgb = new HashMap<>();
            for (String channel : new String[]{"r", "g", "b"}) {
                rgb.put(channel, random.nextInt(256));
            }
            color.setRgb(rgb);
            colorList.add(color);
        }
        return colorList;
    }
}