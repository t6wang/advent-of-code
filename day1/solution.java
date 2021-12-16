package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class solution{
    public static Map<Integer, List<Integer>> map;
    public static void main(String[] args) {
        part1();
        part2();
    }
    /* part 1: How many measurements are larger than the previous measurement? */
    public static void part1(){
      
        final long startTime = System.currentTimeMillis();
        int count = 0;
        File file = new File("day1/input.txt");
        map = new HashMap<Integer, List<Integer>>();
        try {
            Scanner sc = new Scanner(file);
            int prev_int = sc.nextInt();
            while (sc.hasNext()) {
                int next_int = sc.nextInt();
                if(map.keySet().contains(prev_int)){
                    map.get(prev_int).add(next_int);
                    map.put(prev_int, map.get(prev_int));
                }
                else{
                    List<Integer> valueList = new ArrayList<Integer>();
                    valueList.add(next_int);
                    map.put(prev_int, valueList);
                }
                prev_int = next_int;
            }
            System.out.println(map.toString());
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> values = entry.getValue();
            int k = entry.getKey();
            for(int i = 0; i < values.size(); i++){
                if(k < values.get(i)){
                    count = count + 1;
                }
                
            }   
        }
        System.out.println("Total # of increased depths: " + count);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time (part 1): " + (endTime - startTime) + "ms");
    }
    /* part 1: How many 3-measurements are larger than the previous 3-measurements? <=> compare current index to (current index + 3) */
    public static void part2(){
        final long startTime = System.currentTimeMillis();
        int count = 0;
        File file = new File("day1/input.txt");
        List<Integer> numbers = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                numbers.add(sc.nextInt());
            }
            sc.close();
            for(int i = 0; i < numbers.size()-3; i++){
                if(numbers.get(i) < numbers.get(i+3)){
                    count = count + 1;
                }
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total # of increased 3-measurement depths: " + count);
        System.out.println("Total execution time (part 2): " + (endTime - startTime) + "ms");
        // note that list is wayy faster than map. Oops!
    }

    
}
