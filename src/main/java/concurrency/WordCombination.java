package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordCombination {

        static long counter = 0;
        static String[] c;
        public static void main(String[] args) {

            //c = Arrays.asList("a", "b", "c", "d", "e", "f","g","h","i","j","k","l","m","n","o","p","q","r","s","t", "u","v","x","y","z","1","2","3","4","5","6","7","8","9","0",
            //        "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z").toArray(new String[0]);
            c = Arrays.asList("a", "b", "c", "d").toArray(new String[0]);
            permutation(0);
            System.out.println(counter);
        }
        static void swap(int pos1, int pos2) {
            String temp = c[pos1];
            c[pos1] = c[pos2];
            c[pos2] = temp;
        }
        public static void permutation(int start) {
            if (start != 0) {
                List<String> tmp = new ArrayList<>();
                for (int i = 0; i < start; i++){
                    tmp.add(c[i]);
                    //System.out.print(c[i]);
                }

               if(tmp.size()>=3) {
                    counter++;
               }
               System.out.println();
            }
            for (int i = start; i < c.length; i++) {
                swap(start, i);
                permutation(start + 1);
                swap(start, i);
            }
        }
    }
    //combinatorik

