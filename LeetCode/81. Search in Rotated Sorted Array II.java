/* Search in Rotated Sorted Array II:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
class Problem81 {
    public boolean search(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return false;
    	int low = 0;
    	int high = nums.length - 1;
       	while(low <= high) {
    		int mid = (low + high) / 2;
    		
    		if(target == nums[mid]) return true;

    		if(nums[low] < nums[mid]) { // In this case, left side cannot have inflection point, and it is in ascending order.
    			if(target >= nums[low] && target < nums[mid]) high = mid - 1;
    			else low = mid + 1;
    		} else if(nums[low] > nums[mid]) {
    			if(target > nums[mid] && target <= nums[high]) low = mid + 1;
    			else high = mid - 1;
    		} else { // This iteration of while loop did not divide problem in half.
    			low++; // Remove just one invalid match.
    		}
    	}
    	return false;
    }
}
