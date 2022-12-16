public class MergeSort {

    public static void merge (int[] arr, int l, int r, int mid){
        int p1 = l;
        int p2 = mid+1;
        int[] copy = new int[r-l+1];
        for (int i=0; i < r-l+1; i++){
            if (p2 > r || p1 <= mid && arr[p1] <= arr[p2]){
                copy[i] = arr[p1];
                p1++;
            }
            else {
                copy[i] = arr[p2];
                p2++;
            }
        }
        for (int i=0; i < r-l+1; i++){
            arr[l+i] = copy[i];
        }
    }

    public static void mergeSort (int[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort (arr, l, mid);
        mergeSort (arr, mid+1, r);
        merge (arr, l, r, mid);
    }

    public static void main (String[] args){
        int[] arr = {-1, 5, 10, 9, 3, 6};
        mergeSort(arr, 0, arr.length-1);
        for (int i : arr) System.out.println(i);
    }
}
