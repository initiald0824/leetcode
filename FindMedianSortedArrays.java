import java.util.Arrays;
// Q
/**
 * 给定两个大小为m和n的有序数组nums1和nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为O(log(m+n))。
 * 你可以假设nums1和nums2不会同时为空。
 * 示例1：
 *  nums1 = [1, 3]
 *  nums2 = [2]
 *
 *  则中位数是2.0
 *
 * 示例2：
 *  nums1 = [1, 2]
 *  nums2 = [3, 4]
 *
 *  则中位数是(2+3)/2 = 2.5
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3};
        int[] a2 = {2};
    }
}
