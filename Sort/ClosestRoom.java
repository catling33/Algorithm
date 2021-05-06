package Sort;

import java.util.*;

public class ClosestRoom {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        // sanity check
        // result array
        int[] result = new int[queries.length];
        int index = 0;
        // TreeMap to store <room size, list of room ID>
        TreeMap<Integer, List<Integer>> roomMap = new TreeMap<>();
        for (int[] room : rooms) {
            int size = room[1];
            int ID = room[0];
            if (!roomMap.containsKey(size)) {
                List<Integer> list = new ArrayList<>();
                roomMap.put(size, list);
            }
            roomMap.get(size).add(ID);
        }
        // for each query
        // find the entry with least room size equal to or bigger than required size
        // get list of valid room id
        // binary search closest room ID in the list
        for (int[] query : queries) {
            int size = query[1];
            int ID = query[0];
            Map<Integer, List<Integer>> subMap = roomMap.tailMap(size);
            if (subMap == null) {
                result[index++] = -1;
            } else {
                List<Integer> list = new ArrayList<>();
                for (List<Integer> cur : subMap.values()) {
                    for (int i = 0; i < cur.size(); i++) {
                        list.add(cur.get(i));
                    }
                }
                Collections.sort(list);
                result[index++] = getID(list, ID);
            }
        }
        // return
        return result;
    }
    // getID
    private int getID(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int num = list.get(mid);
            if (num == target) {
                return num;
            } else if (num < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // post processing
        int leftNum = list.get(left);
        int rightNum = list.get(right);
        return Math.abs(leftNum - target) <= Math.abs(rightNum - target) ? leftNum : rightNum;
    }
    public static void main(String[] args) {
        ClosestRoom sol = new ClosestRoom();
        int[][] rooms = {{2, 2}, {1, 2}, {3, 2}};
        int[][] queries = {{3, 1}, {3, 3}, {5, 2}};
        System.out.println(Arrays.toString(sol.closestRoom(rooms, queries)));
    }
}
