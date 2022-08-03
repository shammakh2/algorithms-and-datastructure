import java.util.Arrays;

public class Main{

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void Quicksort(int[] arr, int low, int high) {
        if(low < high) {
            int partition_index = Partition(arr, low, high);
            Quicksort(arr, low, partition_index - 1);
            Quicksort(arr, partition_index + 1, high);
        }
    }

    public static int Partition(int[] arr, int low, int high) {
        int i = low;
        int pivot = arr[high];

        for(int j = low; j < high;j++) {
            if(arr[j] <= pivot) {
                swap(i, j, arr);
                i++;
            }
        }
        swap(i, high, arr);

        return i;
    }
    public static void main(String[] args) {

        // Driver code
        int[] array = {323,5,12,56,7,8,9,3,5,3,6,8,3,2,4,6,7,9,25,5,3,3,4,7,9,0,42,7,42,12};
        int len = array.length;
        Quicksort(array, 0, (len - 1));
        System.out.println(Arrays.toString(array));
    }
}