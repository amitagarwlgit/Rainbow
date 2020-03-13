package algo.arrays;

// Given two arrays, write a function to compute their intersection.
//
// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
//
// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
//
// Note:
// Each element in the result must be unique.
// The result can be in any order.

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ArrayIntersection {

  // Technique 1: Simple Approach using HashMaps. O(m + n) complexity.
  public int[] intersectionHashMap(int[] nums1, int[] nums2) {

    HashMap<Integer, Boolean> nums2Map = new HashMap();
    HashMap<Integer, Boolean> nums1Map = new HashMap();
    for (int j = 0; j < nums2.length; j++) {
      nums2Map.putIfAbsent(nums2[j], true);
    }

    for (int i = 0; i < nums1.length; i++) {
      if (nums2Map.containsKey(nums1[i])) {
        nums1Map.putIfAbsent(nums1[i], true);
      }
    }
    return nums1Map.keySet().stream().mapToInt(i -> i).toArray();
  }

  // Technique 2: Simple Approach using HashSets. O(m + n) complexity.
  public int[] intersectionHashSet(int[] nums1, int[] nums2) {

    HashSet<Integer> num2Set = new HashSet<Integer>();
    HashSet<Integer> num1Set = new HashSet<Integer>();

    for (int n : nums2) num2Set.add(n);

    for (int i = 0; i < nums1.length; i++) {
      if (num2Set.contains(nums1[i])) {
        num1Set.add(nums1[i]);
      }
    }

    return num1Set.stream().mapToInt(i -> i).toArray();
  }
}
