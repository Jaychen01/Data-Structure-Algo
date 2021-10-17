package Assignment5;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q7 {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for(int[] item : items){
            int id = item[0];
            int score = item[1];
            PriorityQueue<Integer> pq;
            if(!map.containsKey(id)){
                pq = new PriorityQueue<Integer>(5);
                pq.offer(score);
            }else{
                pq = map.get(id);
                pq.offer(score);
                if(pq.size() > 5){
                    pq.poll();
                }
            }
            map.put(id, pq);
        }

        int index = 0;
        int[][] res = new int[map.size()][2];
        for(int id : map.keySet()){
            res[index][0] = id;
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            int size = pq.size();
            while(!pq.isEmpty()){
                sum += pq.poll();
            }
            res[index][1] = sum/size;
            index++;
        }
        return res;
    }
}
// Time complexity: O(n log n);
// Space complexity: O(n);
