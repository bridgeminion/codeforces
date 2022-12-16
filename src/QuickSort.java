public class QuickSort {

    public static void quickSort (int[] arr, int l, int r){
        if (l >= r) return;
        int index = (int)(Math.random()*(r - l) + l);
        int pivot = arr[index];
        // swap pivot and last element
        arr[index] = arr[r];
        arr[r] = pivot;
        int lo = l;
        int hi = r;
        while (true){
            while (lo < r && arr[lo] <= pivot){
                lo++;
            }
            while (hi >= l && arr[hi] >= pivot){
                hi--;
            }
            if (lo > hi){
                // swap arr[lo] and pivot
                arr[r] = arr[lo];
                arr[lo] = pivot;
                quickSort(arr, l, hi);
                quickSort(arr, lo+1, r);
                return;
            }
            // swap arr[lo] and arr[hi]
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
        }
    }

    public static void main (String[] args){
        int[] arr = {-1, 5, 10, 9, 3, 6};
        quickSort(arr, 0, arr.length-1);
        for (int i : arr) System.out.println(i);
    }
}
