import java.io.IOException;
import java.util.Arrays;

public class p4 {

    public double findTarget (int targetIndex, int[] nums1, int[] nums2){
        int l1 = nums1.length;
        int lo = 0;
        int hi = l1-1;
        boolean subtractNums1 = false;
        while (lo <= hi){
            int mid = (lo+hi)/2;
            int index1 = Arrays.binarySearch(nums2, nums1[mid]);
            if (index1 < 0) index1 = -(index1 + 1);
            if (index1 + mid == targetIndex){
                return nums1[mid];
            }
            if (mid < l1-1){
                int index2 = Arrays.binarySearch(nums2, nums1[mid+1]);
                if (index2 < 0) index2 = -(index2 + 1);
                if (index2 + mid + 1 == targetIndex){
                    return nums1[mid + 1];
                }
                if (index1 + mid < targetIndex && index2 + mid + 1 > targetIndex){
                    return nums2[targetIndex - mid - 1];
                }
                if (index1 + mid > targetIndex){
                    hi = mid-1;
                }
                else {
                    lo = mid+1;
                }
            }
            else {
                subtractNums1 = index1 + mid < targetIndex;
                break;
            }
        }
        if (subtractNums1){
            return nums2[targetIndex - l1];
        }
        return nums2[targetIndex];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2) return findMedianSortedArrays(nums2, nums1);
        if ((l1 + l2) % 2 == 0){
            double lower = findTarget ((l1+l2)/2 - 1, nums1, nums2);
            double higher = findTarget ((l1+l2)/2, nums1, nums2);
            return (lower + higher)/2;
        }
        else {
            return findTarget ((l1+l2)/2, nums1, nums2);
        }
    }

    public static void main(String[] args) throws IOException {
        p4 test = new p4();
        System.out.println(test.findMedianSortedArrays(new int[] {3}, new int[] {-2, -1}));
        System.out.println(test.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(test.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
        System.out.println(test.findMedianSortedArrays(new int[] {3}, new int[] {}));
        System.out.println(test.findMedianSortedArrays(new int[] {2, 4}, new int[] {1, 3}));
    }
}
