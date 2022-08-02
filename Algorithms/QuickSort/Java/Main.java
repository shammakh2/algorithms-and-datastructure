import java.util.Arrays;

public class Main{

    /* 1. First select a pivot (pivot selection code)
       2. Swap pivot with the end of the array
       3. Values left of pivot have to be less than pivtot, right of pivot more than pivot 
       4. itemFromLeft > p and itemFromRight < p
       5. Search for itemFromLeft and itemFromRight (first one matching condition) then swap them
       6. Stop when index of item from left > index of item from right
       7. swap itemFromLeft with pivot
       8. Recursion
    */

    public static int temp;
    public static int[] arr = {5,3,3,2,3,2,4,5,4,6,53};
    public static int leng = arr.length;
    public static int itemFromLeft; //index
    public static int itemFromRight; //index

    public static void swap(int a, int b) {
        temp = a;
        a = b;
        b = temp;
    }

    public static void Partition(int[] array,int len,int pivot_index) {
       swap(array[pivot_index],array[len - 1]);
       for(int i = 0; i < (len - 2);i++) {
        if(i < pivot_index) {
            if(array[i] > array[pivot_index]) {
                 itemFromLeft = i;
                };
        }
        if(i > pivot_index) {
            if(array[i] < array[pivot_index]) {
                 itemFromRight = i;
                };
        }
        swap(array[itemFromLeft], array[itemFromRight]);
        if(itemFromLeft < itemFromRight) {
            // Reverse operator to account for swap
            break;
        }
       }
       swap(array[itemFromLeft], array[len - 1]); // Swap itemFromLeft and pivot
       itemFromLeft = pivot_index; 
    }
    public static void QuickSort(int[] array, int len, int pivot_index) {
        Partition(array, len, pivot_index);
        /*for(int i = 0;i < len;i++) {
            if(i == pivot_index) {
                continue;
            }
            Partition(array, len, i);
        }*/
    }

    public static void main(String[] args) {
        String str_arr = Arrays.toString(arr);
        System.out.printf("Array before sort: %s%n",str_arr);
        QuickSort(arr, leng, 6);
        System.out.printf("Array after sort: %s%n",str_arr);
    }
}