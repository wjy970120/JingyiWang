/* Find First and Last Position of Element in Sorted Array:
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return new int[] {-1, -1};
    	
    	int start = 0;
    	int end = nums.length - 1;
    	
    	int left = findStartingPosition(nums, target, start, end);
    	int right = findEndingPosition(nums, target, start, end);
    	
    	return new int[] {left, right};
    }
    
    // find starting position of target value
    private int findStartingPosition(int[] nums, int target, int start, int end) {
    	while(start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if(nums[mid] == target) {
    			end = mid;
    		} else if(nums[mid] < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	
    	// judge starting element first
    	if(nums[start] == target) return start;
    	if(nums[end] == target) return end;
    	
    	return -1;
    }
    
    // find ending position of target value
    private int findEndingPosition(int[] nums, int target, int start, int end) {
    	while(start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if(nums[mid] == target) {
    			start = mid;
    		} else if(nums[mid] < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	
    	// judge ending element first
    	if(nums[end] == target) return end;
    	if(nums[start] == target) return start;
    	
    	return -1;
    }
}