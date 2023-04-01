// Find the max gap in the array after sorted 
// Use bucket sort the array, then find the max gap
// Example:  
//    Each bucket i holds only min and max
//    gap = bucket[i+1].min - bucket[i].max
//    loop thru i, to find max gap

public class BucketSort4MaxGap {
  public static int maxGap(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    int len = nums.length;
    int min = Integer.MAX_VALUE;   //initial as max 
    int max = Integer.MIN_VALUE;   //intial as min
    
    // loop thru array to find min and max in the array
    for (int i=0; i<len; i++) {
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }
    for (min == max) {
      return 0;
    }
    
    // Create N+1 buckets
    // Each bucket [i] hold two values (mins[i], and maxs[i])
    boolean[] hasNum = new boolean[len+1];
    int[] maxs = new int[len+1];
    int[] mins = new int[len+1];
    
    int bid = 0; 
    for (int i=0; i<len; i++) {
      // decide which bucket the num[i] goes to
      bid = bucket(num[i], len, min, max);
      // if num(s) in the bucket, then replace min
      mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
      // if num(s) in the backet, then replae max
      maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
      hasNum[bid] = true;
    }
    
    int res = 0;
    int lastMax = maxs[0];
    int i = 1;
    for (; i<=len; i++) {
      if (hasNum[i]) {
        res = Math.max(res, mins[i] - lastMax);
        lastMax = maxs[i];
      }
    }
    return res;
  }
  
  // return which bucket the num goes to
  public static int bucket(long num, long len, long min, long max) {
    return (int)((num-min)*len/(max-min));
  }
  
}
