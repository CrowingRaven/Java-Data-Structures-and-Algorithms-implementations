import java.util.ArrayList;
import java.util.Collections;

/*
quickSort(list, low , high):
    if low < high:
        pivotIndex = partition(list, low, high)
        quickSort(list, low, pivotIndex-1)
        quickSort(list, pivotIndex+1, high)
    return list

partition(list, low, high):
    mid = low + (high - low) / 2
    if list[low] > list[mid]:
        swap(list[low], list[mid])

    if list[low] > list[high]:
        swap(list[low], list[high])
    
    if list[mid] > list[high]:
        swap(list[mid], list[high])

    pivot = list[mid]
    swap(list[mid], list[high])

    i = low-1
    for j = low to high-1:
        if list[j] <= pivot:
            i++
            swap(list[i], list[j])

    swap(list[i+1], list[high])
    return i+1

*/

public class Q1B {
    public static ArrayList<Integer> initQuickSort(ArrayList<Integer> list) {
        ArrayList<Integer> listToSort = new ArrayList<>(list);
        quickSort(listToSort, 0, listToSort.size() - 1);
        return listToSort;
    }

    public static void quickSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> list, int low, int high) {
        int mid = low + (high - low) / 2;
        if (list.get(low) > list.get(mid)) {
            int temp = list.get(low);
            list.set(low, list.get(mid));
            list.set(mid, temp);
        }
        if (list.get(low) > list.get(high)) {
            int temp = list.get(low);
            list.set(low, list.get(high));
            list.set(high, temp);
        }
        if (list.get(mid) > list.get(high)) {
            int temp = list.get(mid);
            list.set(mid, list.get(high));
            list.set(high, temp);
        }
        int pivot = list.get(mid);
        int temp = list.get(mid);
        list.set(mid, list.get(high));
        list.set(high, temp);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    public static void efficiencyTest(ArrayList<Integer> list, int iterations) {
        long start = System.currentTimeMillis();
        for (int i=0; i < iterations; i++) {
            initQuickSort(list);
        }
        long end = System.currentTimeMillis();
        System.out.println("Average time taken to sort list: " + ((end - start)/iterations) + "ms");
    }

    public static void main(String[] args) {
        ArrayList<Integer> randMonday = new ArrayList<>();
        ArrayList<Integer> randTuesday = new ArrayList<>();
        ArrayList<Integer> randWednesday = new ArrayList<>();
        ArrayList<Integer> randThursday = new ArrayList<>();
        ArrayList<Integer> randFriday = new ArrayList<>();
        ArrayList<Integer> randSaturday = new ArrayList<>();
        ArrayList<Integer> randSunday = new ArrayList<>();

        System.out.println("random ArrayLists declared");

        for (int i = 0; i < 1000; i++) {randMonday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 5000; i++) {randTuesday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 10000; i++) {randWednesday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 50000; i++) {randThursday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 75000; i++) {randFriday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 100000; i++) {randSaturday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 500000; i++) {randSunday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}

        System.out.println("random ArrayLists filled");

        ArrayList<Integer> sortedMonday = initQuickSort(randMonday);
        System.out.println("Monday's list sorted");
        ArrayList<Integer> sortedTuesday = initQuickSort(randTuesday);
        System.out.println("Tuesday's list sorted");
        ArrayList<Integer> sortedWednesday = initQuickSort(randWednesday);
        System.out.println("Wednesday's list sorted");
        ArrayList<Integer> sortedThursday = initQuickSort(randThursday);
        System.out.println("Thursday's list sorted");
        ArrayList<Integer> sortedFriday = initQuickSort(randFriday);
        System.out.println("Friday's list sorted");
        ArrayList<Integer> sortedSaturday = initQuickSort(randSaturday);
        System.out.println("Saturday's list sorted");
        ArrayList<Integer> sortedSunday = initQuickSort(randSunday);
        System.out.println("Sunday's list sorted");

        System.out.println("random ArrayLists sorted");

        ArrayList<Integer> reversedMonday = new ArrayList<>(sortedMonday);
        ArrayList<Integer> reversedTuesday = new ArrayList<>(sortedTuesday);
        ArrayList<Integer> reversedWednesday = new ArrayList<>(sortedWednesday);
        ArrayList<Integer> reversedThursday = new ArrayList<>(sortedThursday);
        ArrayList<Integer> reversedFriday = new ArrayList<>(sortedFriday);
        ArrayList<Integer> reversedSaturday = new ArrayList<>(sortedSaturday);
        ArrayList<Integer> reversedSunday = new ArrayList<>(sortedSunday);

        System.out.println("reversed ArrayLists declared");

        Collections.reverse(reversedMonday);
        Collections.reverse(reversedTuesday);
        Collections.reverse(reversedWednesday);
        Collections.reverse(reversedThursday);
        Collections.reverse(reversedFriday);
        Collections.reverse(reversedSaturday);
        Collections.reverse(reversedSunday);

        System.out.println("reversed ArrayLists filled");

        System.out.println("Efficieny test for Random Monday list:");
        efficiencyTest(randMonday, 10000);
        System.out.println("Efficieny test for Sorted Monday list:");
        efficiencyTest(sortedMonday, 10000);
        System.out.println("Efficieny test for Reversed Monday list:");
        efficiencyTest(reversedMonday, 10000);
        System.out.println();
        System.out.println("Efficieny test for Random Tuesday list:");
        efficiencyTest(randTuesday, 1000);
        System.out.println("Efficieny test for Sorted Tuesday list:");
        efficiencyTest(sortedTuesday, 1000);
        System.out.println("Efficieny test for Reversed Tuesday list:");
        efficiencyTest(reversedTuesday, 1000);
        System.out.println();
        System.out.println("Efficieny test for Random Wednesday list:");
        efficiencyTest(randWednesday, 1000);
        System.out.println("Efficieny test for Sorted Wednesday list:");
        efficiencyTest(sortedWednesday, 1000);
        System.out.println("Efficieny test for Reversed Wednesday list:");
        efficiencyTest(reversedWednesday, 1000);
        System.out.println();
        System.out.println("Efficieny test for Random Thursday list:");
        efficiencyTest(randThursday, 1000);
        System.out.println("Efficieny test for Sorted Thursday list:");
        efficiencyTest(sortedThursday, 100);
        System.out.println("Efficieny test for Reversed Thursday list:");
        efficiencyTest(reversedThursday, 100);
        System.out.println();
        System.out.println("Efficieny test for Random Friday list:");
        efficiencyTest(randFriday, 100);
        System.out.println("Efficieny test for Sorted Friday list:");
        efficiencyTest(sortedFriday, 100);
        System.out.println("Efficieny test for Reversed Friday list:");
        efficiencyTest(reversedFriday, 100);
        System.out.println();
        System.out.println("Efficieny test for Random Saturday list:");
        efficiencyTest(randSaturday, 100);
        System.out.println("Efficieny test for Sorted Saturday list:");
        efficiencyTest(sortedSaturday, 100);
        System.out.println("Efficieny test for Reversed Saturday list:");
        efficiencyTest(reversedSaturday, 100);
        System.out.println();
        System.out.println("Efficieny test for Random Sunday list:");
        efficiencyTest(randSunday, 50);
        System.out.println("Efficieny test for Sorted Sunday list:");
        efficiencyTest(sortedSunday, 50);
        System.out.println("Efficieny test for Reversed Sunday list:");
        efficiencyTest(reversedSunday, 50);

    }
}

