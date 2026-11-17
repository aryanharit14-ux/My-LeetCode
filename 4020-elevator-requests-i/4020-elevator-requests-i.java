class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int currentFloor = 0;
        int totalTime = 0;
        for(int floor:requests){
            totalTime+=Math.abs(currentFloor-floor);
            currentFloor = floor;
        }
    return totalTime;
    }
}