/* Find Minimum in Rotated Sorted Array II:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * The array may contain duplicates.
 */
class Problem154 {
    public int findMin(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	int start = 0;
    	int end = nums.length - 1;
    	while(start < end) {
    		int mid = start + (end - start) / 2;
    		if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
    		else if(nums[mid] > nums[end]) start = mid + 1;
    		else if(nums[mid] < nums[end]) end = mid - 1;
    		else end--;
    	}
    	return nums[start];
    }
}