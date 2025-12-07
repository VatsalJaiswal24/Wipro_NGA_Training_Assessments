// Done by Vatsal Jaiswal
package Day6;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        System.out.println("List before sort: " + list);

        Collections.sort(list);

        System.out.println("List after sort: " + list);

        sc.close();
    }
}