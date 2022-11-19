import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IntersectionofTwoArrays2
 */
public class IntersectionofTwoArrays2 {

    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 2, 3 };
        int[] nums2 = { 2, 3 };
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        List<Integer> myList = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) == 0) {
                    map.remove(num);
                } else {
                    myList.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
        }
        int[] res = new int[myList.size()];

        for (int i = 0; i < myList.size(); i++) {
            res[i] = myList.get(i);
        }
        return res;
    }
}