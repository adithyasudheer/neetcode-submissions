class Node {
    int enq, pr, ind;

    Node(int e, int p, int i) {
        enq = e;
        pr = p;
        ind = i;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        int[] res = new int[n];

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Node(tasks[i][0], tasks[i][1], i));
        }

        list.sort((a, b) -> Integer.compare(a.enq, b.enq));

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.pr != b.pr)
                return Integer.compare(a.pr, b.pr);
            return Integer.compare(a.ind, b.ind);
        });

        long time = 0;
        int arrPos = 0;
        int resPos = 0;

        while (!pq.isEmpty() || arrPos < n) {

            // CPU idle -> jump to next task arrival
            if (pq.isEmpty()) {
                time = Math.max(time, list.get(arrPos).enq);
            }

            // Add all tasks available at current time
            while (arrPos < n && list.get(arrPos).enq <= time) {
                pq.offer(list.get(arrPos));
                arrPos++;
            }

            Node curr = pq.poll();

            time += curr.pr;
            res[resPos++] = curr.ind;
        }

        return res;
    }
}