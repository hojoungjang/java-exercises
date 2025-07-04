package programmers_92341;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */

import java.util.*;

class Solution {
    
    String IN = "IN";
    String OUT = "OUT";
    
    private int getTimeDiff(String inTime, String outTime) {
        int inMinutes = 0;
        int outMinutes = 0;
        
        String[] inParts = inTime.split(":");
        String[] outParts = outTime.split(":");
        inMinutes += Integer.parseInt(inParts[0]) * 60 + Integer.parseInt(inParts[1]);
        outMinutes += Integer.parseInt(outParts[0]) * 60 + Integer.parseInt(outParts[1]);
        
        return outMinutes - inMinutes;
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> totalTimes = new HashMap<>();
        Map<String, String> inOut = new HashMap<>();
        
        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carId = parts[1];
            String state = parts[2];
            
            if (state.equals(IN)) {
                inOut.put(carId, time);
            } else {
                String inTime = inOut.get(carId);
                int usedTime = getTimeDiff(inTime, time);
                
                totalTimes.putIfAbsent(carId, 0);
                totalTimes.put(carId, totalTimes.get(carId) + usedTime);
                
                inOut.remove(carId);
            }
        }
        
        for (Map.Entry<String, String> e : inOut.entrySet()) {
            String carId = e.getKey();
            String inTime = e.getValue();
            int usedTime = getTimeDiff(inTime, "23:59");

            totalTimes.putIfAbsent(carId, 0);
            totalTimes.put(carId, totalTimes.get(carId) + usedTime);
        }
        
        String[] carIds = totalTimes.keySet().toArray(new String[0]);
        Arrays.sort(carIds);
        int[] answer = new int[carIds.length];
        
        for (int i=0; i < carIds.length; i++) {
            String carId = carIds[i];
            int t = totalTimes.get(carId);
            int fee = 0;
    
            if (t > 0) {
                fee += fees[1];
                t = Math.max(0, t - fees[0]);
                
                if (t > 0) {
                    fee += (int) Math.ceil((double)t / fees[2]) * fees[3];
                }
            }
            answer[i] = fee;
        }
        
        return answer;
    }
}
