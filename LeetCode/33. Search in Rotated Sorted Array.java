/* Search in Rotated Sorted Array:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2])
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 */

class Problem33 {
    public int search(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return -1;
    	int low = 0;
    	int high = nums.length - 1;
    	// Since the runtime complexity must be in the order of O(log n), we should use binary search.
    	while(low < high) {
    		int mid = (low + high) / 2;
    		
    		if(target == nums[mid]) return mid;
    		// If nums[low] <= nums[mid], then the first half of the array is in ascending order.
    		if(nums[low] <= nums[mid]) {
    			if(target >= nums[low] && target <= nums[mid]) high = mid - 1;
    			else low = mid + 1;
    		}
    		// Else the last half of the array is in ascending order.
    		else {
    			if(target >= nums[mid] && target <= nums[high]) low = mid + 1;
    			else high = mid - 1;
    		}
    	}
    	return nums[low] == target? low : -1;
    }
}