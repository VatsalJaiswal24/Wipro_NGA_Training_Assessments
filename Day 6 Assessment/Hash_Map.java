// Done by Vatsal Jaiswal
package Day6;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Hash_Map {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<Integer, String> map = new HashMap<>();

        String s1 = s.next();
        String s2 = s.next();
        String s3 = s.next();
        String s4 = s.next();

        map.put(1, s1);
        map.put(2, s2);
        map.put(3, s3);
        map.put(4, s4);

        System.out.println("Mappings of HashMap are : " + map);

        int keyToRemove = s.nextInt();

        map.remove(keyToRemove);

        System.out.println("Mappings after removal are : " + map);

        s.close();
    }
}
