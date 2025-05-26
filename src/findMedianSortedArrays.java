public class findMedianSortedArrays
{
    public double solution(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;

        if (total % 2 == 1) {
            // 奇数，返回第 (total / 2 + 1) 小的数
            return getk(nums1, nums2, 0, 0, total / 2 + 1);
        } else {
            // 偶数，取第 (total / 2) 和 (total / 2 + 1) 小的数平均
            int left = getk(nums1, nums2, 0, 0, total / 2);
            int right = getk(nums1, nums2, 0, 0, total / 2 + 1);
            return (left + right) / 2.0;
        }
    }
    public int getk(int[] nums1,int[]nums2,int i,int j,int k)
    {
        if(i>=nums1.length) return nums2[j+k/2-1];
        if(j>=nums2.length) return nums1[i+k/2-1];
        if(k == 1) return Math.min(nums1[i],nums2[j]);

        int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        if(mid1> mid2)
        {
            return getk(nums1,nums2,i,j+k/2,k-k/2);
        }
        else{
            return getk(nums1,nums2,i+k/2,j,k-k/2);
        }
    }
    public static void main(String[] args) {
        findMedianSortedArrays obj = new findMedianSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double res = obj.solution(nums1, nums2);
        System.out.println("Median is: " + res);
    }
}