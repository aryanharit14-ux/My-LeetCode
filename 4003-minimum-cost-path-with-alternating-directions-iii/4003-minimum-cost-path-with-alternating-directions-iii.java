class Solution {
    public long minCost(int m, int n, int[][] penalty) {
        int halfAns = m * n;
        long[] dist = new long[halfAns * 2];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[1] = 1;

        LongHeap pq = new LongHeap(halfAns * 4);
        pq.add((1L << 24) | 1);

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while(!pq.isEmpty()) {
            long curr = pq.poll();
            long d = curr >>> 24;
            int state = (int) (curr & 0xFFFFFF);
            if(d > dist[state]) {
                continue;
            }
            int p = state & 1;
            int rc = state >>> 1;
            int r =  rc / n;
            int c = rc % n;

            if(r == m - 1 && c == n - 1) {
                return d;
            }

            long waitCost = d + penalty[r][c];
            int waitState = state ^ 1;
            if(waitCost < dist[waitState]) {
                dist[waitState] = waitCost;
                pq.add((waitCost << 24) | waitState);
            }
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < m && nc >=0 && nc < n) {
                    boolean isRightOrDown = (i == 0 || i == 1);
                    boolean isFreeMove = (p == 1 && isRightOrDown) || (p == 0 && !isRightOrDown);
                    long moveCost = d + (long) (nr + 1) * (nc + 1) + (isFreeMove ? 0 : penalty[r][c]);
                    int nextState = (((nr * n) + nc) << 1) | (1 - p);
                    if(moveCost < dist[nextState]) {
                        dist[nextState] = moveCost;
                        pq.add((moveCost << 24) | nextState);
                    }
                }
            }
        }
        return -1;
    }

    class LongHeap {
        long[] data;
        int size;
        public LongHeap(int cap) {
            data = new long[cap];
            size = 0;
        }
        public void add(long val){
            if(size == data.length) {
                data = Arrays.copyOf(data, data.length * 2);
            }
            data[size] = val;
            shiftUp(size);
            size++; 
        }

        public long poll() {
            long res = data[0];
            size--;
            data[0] = data[size];
            shiftDown(0);
            return res;
        }
            public boolean isEmpty() {
                return size == 0;
                
            }
        private void shiftUp(int i) {
            long val = data[i];
            while(i > 0) {
                int p = (i - 1) >>> 1;
                if(data[p] <= val) break;
                data[i] = data[p];
                i = p;
            }
            data[i] = val;
        }
        private void shiftDown(int i) {
            long val = data[i];
            int half = size >>> 1;
            while(i < half) {
                int child = (i << 1) + 1;
                int right = child + 1;
                long c = data[child];
                if(right < size && data[right] < c) {
                    c = data[child = right];
                }
                if(val <= c) break;
                data[i] = c;
                i = child;
            }
            data[i] = val;
        }
    }
}