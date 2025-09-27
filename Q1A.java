import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

public class Q1A {
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

    public static void main(String[] args) {
        ArrayList<Integer> Monday = new ArrayList<>();
        ArrayList<Integer> Tuesday = new ArrayList<>();
        ArrayList<Integer> Wednesday = new ArrayList<>();
        ArrayList<Integer> Thursday = new ArrayList<>();
        ArrayList<Integer> Friday = new ArrayList<>();
        ArrayList<Integer> Saturday = new ArrayList<>();
        ArrayList<Integer> Sunday = new ArrayList<>();

        System.out.println("random ArrayLists declared");

        for (int i = 0; i < 1000; i++) {Monday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 5000; i++) {Tuesday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 10000; i++) {Wednesday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 50000; i++) {Thursday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 75000; i++) {Friday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 100000; i++) {Saturday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
        for (int i = 0; i < 500000; i++) {Sunday.add((int)(Math.random() * (500000 - 1000 + 1)) + 1000);}
         
        //System.out.println(initQuickSort(Monday));
        //System.out.println(initQuickSort(Tuesday));
        //System.out.println(initQuickSort(Wednesday));
        //System.out.println(initQuickSort(Thursday));
        //System.out.println(initQuickSort(Friday));
        //System.out.println(initQuickSort(Saturday));
        //System.out.println(initQuickSort(Sunday));
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sortedThursday.txt"))) {
            for (int num : initQuickSort(Thursday)) {
                writer.write(num + " ");
            }
            System.out.println("Sorted array written to sortedThursday.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sortedFriday.txt"))) {
            for (int num : initQuickSort(Friday)) {
                writer.write(num + " ");
            }
            System.out.println("Sorted array written to sortedFriday.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sortedSaturday.txt"))) {
            for (int num : initQuickSort(Saturday)) {
                writer.write(num + " ");
            }
            System.out.println("Sorted array written to sortedSaturday.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sortedSunday.txt"))) {
            for (int num : initQuickSort(Sunday)) {
                writer.write(num + " ");
            }
            System.out.println("Sorted array written to sortedSunday.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}

