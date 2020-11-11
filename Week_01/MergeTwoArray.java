// 方法：双指针。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];// nums1用于输出，因此将nums1_copy拷贝出来
        int p = 0; // 指向nums1_copy的指针
        int q = 0; // 指向nums2的指针
        int g = 0; // 指向nums1的指针
        System.arraycopy(nums1,0,nums1_copy,0,m); // 完成数组的拷贝
        while(p < m && q < n){
            nums1[g++] = nums1_copy[p] < nums2[q] ? nums1_copy[p++]:nums2[q++]; 
        }
        if (p < m){
            System.arraycopy(nums1_copy,p,nums1,g,m+n-g);
        }
        if (q < n){
            System.arraycopy(nums2,q,nums1,g,m+n-g);
        }

    }
}
