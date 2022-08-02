import static java.lang.System.out;

import java.util.Arrays;

/* Tackling the problem step by step:
 * 1. Heapify array
 * 2. Turn it into max heap
 * 3. swap last element and root
 * 4. remove last element
 */


public class Main {

    static int[] arr = {4,5,6,3,2,5,3,5,6,3,2,7,9,5}; // array
    static int arrLen = arr.length; // n


    public void Heapify(int[] array, int n, int i ) {
        int parent = i;
        int left = 2 * i + 1;
        int right = 2* i + 2;
        int temp;
        

        // if we are not at the last node aka has children and check if the left or right are bigger and if so switch with its parent

        if(left < n && arr[left] > arr[parent]) {
            parent = left;
        }

        if(right < n && arr[right] > arr[parent]) {
            parent = right;
        }

        if(parent != i) {

            temp = arr[i];
            arr[i] = arr[parent];
            arr[parent] = temp; 

            Heapify(array, n, parent); // recursion if the parent was swapped so all other nodes are also updated
        }

    }

    public void HeapSort(int[] array, int n) {
        for (int m = n/2 - 1;m>=0;m--) {
            Heapify(array, n, m);
        };
        for (int m = n - 1;m>0;m--) {
            int temp;
            temp = array[0];
            array[0] = array[m];
            array[m] = temp;
            Heapify(array, m, 0);
        }

    }
    public static void main(String[] args) {
        out.println("Array before: " + Arrays.toString(arr));
        Main ob = new Main();
        ob.HeapSort(arr, arrLen);
        out.println("Array after: " + Arrays.toString(arr));
    }
}
