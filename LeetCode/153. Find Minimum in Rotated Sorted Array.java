/* Find Minimum in Rotated Sorted Array:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */
class Problem153 {
    public int findMin(int[] nums) {
    	// The minimum element must satisfy one of two conditions: 
    	// 1) If rotate, A[min] < A[min - 1]; 2) If not, A[0]. 
    	// Therefore, we can use binary search: check the middle element, if it is less than previous one, then it is minimum. 
    	// If not, there are 2 conditions as well: 
    	// If it is greater than both left and right element, then minimum element should be on its right, otherwise on its left.
    	
    	// Method 1:
    	// if(nums == null || nums.length == 0) return 0;
    	// if(nums.length == 1) return nums[0];
    	// int start = 0;
    	// int end = nums.length - 1;
    	// while(start < end) {
    	//	int mid = start + (end - start) / 2;
    	//	if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
    		// For example: [2, 1], start = 0, end = 1, mid = 0. nums[mid] = nums[start].
    	//	else if(nums[mid] >= nums[start] && nums[mid] >= nums[end]) start = mid + 1;
    	//	else end = mid - 1;
    	// }
    	// return nums[start];
    	
    	// Method 2:
    	if(nums == null || nums.length == 0) return 0;
    	if(nums.length == 1) return nums[0];
    	int start = 0;
    	int end = nums.length - 1;
    	while(start < end) {
    	    int mid = start + (end - start) / 2;
    	    if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
    	    // It is possible for nums[mid] = nums[start] to happen, to make this question easier, we can only compare
    	    // nums[mid] and nums[end].
    	    else if(nums[mid] > nums[end]) start = mid + 1;
    	    else end = mid - 1;
    	}
    	return nums[start];
    }
}