package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class solution{
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        int count = 0;
        File file = new File("day1/input.txt");
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
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
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> values = entry.getValue();
            for(int i = 0; i < values.size(); i++){
                if(entry.getKey() < values.get(i)){
                    count = count + 1;
                }
            }
           
        }
        System.out.println(count);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }

    
}
