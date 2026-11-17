class Solution {

    class Event {
        int x;
        int y1;
        int y2;
        int type; 

        Event(int x, int y1, int y2, int type) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.type = type;
        }
    }

    public int rectangleArea(int[][] rectangles) {

        List<Event> events = new ArrayList<>();

        for (int[] r : rectangles) {
            events.add(new Event(r[0], r[1], r[3], 1));   
            events.add(new Event(r[2], r[1], r[3], -1));  
        }

        events.sort((a, b) -> a.x - b.x);

        List<int[]> active = new ArrayList<>();

        long area = 0;
        int MOD = 1_000_000_007;

        int prevX = events.get(0).x;

        for (Event e : events) {

            int dx = e.x - prevX;

            long coveredY = getCoveredLength(active);

            area += coveredY * dx;
            area %= MOD;

            if (e.type == 1) {
                active.add(new int[]{e.y1, e.y2});
            } else {

                for (int i = 0; i < active.size(); i++) {

                    if (active.get(i)[0] == e.y1 &&
                        active.get(i)[1] == e.y2) {

                        active.remove(i);
                        break;
                    }
                }
            }

            prevX = e.x;
        }

        return (int) area;
    }

    private long getCoveredLength(List<int[]> active) {

        if (active.isEmpty())
            return 0;

        active.sort((a, b) -> a[0] - b[0]);

        long length = 0;

        int start = active.get(0)[0];
        int end = active.get(0)[1];

        for (int i = 1; i < active.size(); i++) {

            int[] cur = active.get(i);

            if (cur[0] <= end) {
                end = Math.max(end, cur[1]);
            } else {
                length += end - start;
                start = cur[0];
                end = cur[1];
            }
        }

        length += end - start;

        return length;
    }
}