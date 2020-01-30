import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class subSet {
    static List<Integer> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your set (0 will be end of set!) : ");
        set = new ArrayList<>();
        int input;
        while (true) {
            input = sc.nextInt();
            if (input == 0) {
                break;
            } else set.add(input);
        }

        quicksort(set, 0, set.size() - 1);
        System.out.println("Please enter your goal number : ");
        int k = sc.nextInt();
        boolean map[] = new boolean[k + 1];
        map[0] = true;

        for (int i = 0; i < set.size(); i++) {
            for (int j = i; j < k + 1; j++) {
                try {
                    if (map[j])
                        map[j + set.get(i)] = true;
                } catch (Exception e) {
                }
            }
        }

        if (map[k])
            System.out.println("YES");
        else
            System.out.println("NO");

    }


    public static void quicksort(List<Integer> list, int left, int right) {
        int q;
        if (right > left) {
            q = partition(list, left, right);
            // after ‘partition’
            // list[left..q-1] ≤ list[q] ≤ list[q+1..right]
            quicksort(list, left, q - 1);
            quicksort(list, q + 1, right);
        }
    }

    static int partition(List<Integer> list, int left, int right) {
        int P = list.get(left);
        int i = left;
        int j = right + 1;
        for (; ; ) { // infinite for-loop, break to exit
            while (list.get(++i) < P)
                if (i >= right)
                    break;
            // Now, list[i]≥P
            while (list.get(--j) > P)
                if (j <= left)
                    break;
            // Now, list[j]≤P
            if (i >= j)
                break; // break the for-loop
            else
                // swap(list[i],list[j]);
                Collections.swap(list, i, j);
        }
        if (j == left)
            return j;
        // swap (list[left],list[j]);
        Collections.swap(list, left, j);
        return j;
    }

}
