package Sort;

import java.util.ArrayList;
import java.util.List;

public class InversionCount {
    class Element {
        int value;
        int index;
        int count;

        private Element(int value, int index, int count) {
            this.value = value;
            this.index = index;
            this.count = count;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        // pre-process : make integers in nums into Element
        Element[] array = new Element[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = new Element(nums[i], i, 0);
        }
        // recursion
        helper(array, 0, array.length - 1);
        // proccess result
        int[] result = new int[nums.length];
        for (Element e : array) {
            result[e.index] = e.count;
        }
        // return result
        List<Integer> list = new ArrayList<>();
        for (int cur : result) {
            list.add(cur);
        }
        return list;
    }

    // recursion to do merge sort
    private Element[] helper(Element[] array, int left, int right) {
        // base case
        if (left == right) {
            return new Element[] {array[left]};
        }
        // partition
        int mid = left + (right - left) / 2;
        Element[] leftResult = helper(array, left, mid);
        Element[] rightResult = helper(array, mid + 1, right);
        // merge
        // return
        return merge(leftResult, rightResult);
    }
    // merge
    private Element[] merge(Element[] one, Element[] two) {
        Element[] result = new Element[one.length + two.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int rightCount = 0;

        while (i < one.length && j < two.length) {
            Element left = one[i];
            Element right = two[j];
            if (right.value < left.value) {
                rightCount++;
                result[k] = right;
                j++;
            } else {
                left.count += rightCount;
                result[k] = left;
                i++;
            }
            k++;
        }

        // if left half is not finished
        while (i < one.length) {
            one[i].count += rightCount;
            result[k++] = one[i++];
        }

        // if right half is not finished
        while (j < two.length) {
            result[k++] = two[j++];
        }

        // return result array
        return result;
    }
}
