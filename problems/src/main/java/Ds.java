package src.main.java;

import java.io.PrintWriter;
import java.util.*;

public class Ds {

    PrintWriter pw = new PrintWriter(System.out);


    class Val {
        int id;
        int content;

        public Val(int id, int content) {
            this.id = id;
            this.content = content;
        }

        public String toString() {
            return String.format("[id=%d,content=%d]", id, content);
        }
    }

    void solve() {



        int arrA[] = new int[] {5, 10, 30};
        int arrB[] = new int[10];

        pw.println("arraylist sort");

        ArrayList<Val> vals = new ArrayList<>();

        Val id0c10 = new Val(0, 10);
        Val id1c5 = new Val(1, 5);
        Val id2c15 = new Val(2, 15);
        Val id3c5 = new Val(3, 5);
        Val id4c0 = new Val(4, 0);

        vals.add(id0c10);
        vals.add(id1c5);
        vals.add(id2c15);
        vals.add(id3c5);
        vals.add(id4c0);

        // whatever order you want, make it true and return -1
        // that will keep the order you want.
        vals.sort((x, y) -> {
            if(x.content == y.content) {
                if(x.id < y.id) return -1;
                return 1;
            }
            if(x.content > y.content) return -1;
            return 1;
        });

        pw.println(vals);


       BitSet bs = new BitSet(10);

       Deque<Integer> dq = new LinkedList<>();

       dq.addFirst(10);
       pw.println(dq.removeLast());


       pw.println("bit manipulation");
       int x = 3;

       //4,2,1

        pw.println((x >> 1) << 1);

        int y = 40; // 101000 => 100111 => &

        pw.println((y - 1) & y);

        pw.flush();


        TreeMap<Integer, Val> treeMap = new TreeMap<>();


        vals.forEach( v -> {
            treeMap.put(v.content, v);
        });

        SortedMap<Integer, Val> left = treeMap.tailMap(5);


        PriorityQueue<Val> minHeap = new PriorityQueue<>((a, b) -> {
            if(a.content == b.content) {
                if(a.id < b.id) return -1;
                return 1;
            }
            if(a.content < b.content) return -1;
            return 1;
        });

        pw.println("min heap");

        Random r = new Random();

        for(int i=0; i<10; i++) {
         minHeap.add(new Val(i, r.nextInt(100)));
        }

        while(!minHeap.isEmpty()) {
            pw.println(minHeap.poll());
        }

        pw.println("max heap");


        PriorityQueue<Val> maxHeap = new PriorityQueue<>((a, b) -> {
           if(a.content == b.content) {
               if(a.id < b.id) return -1;
               return 1;
           }
           if(a.content > b.content) return -1;
           return 1;
        });

        for(int i=0; i<10; i++) {
            maxHeap.add(new Val(i, r.nextInt(100)));
        }

        while(!maxHeap.isEmpty()) {
            pw.println(maxHeap.poll());
        }

        pw.println("hash map");

        HashMap<Integer, Val> hashMap = new HashMap<>();



        pw.flush();

    }


    public static void main(String[] args) {
        Ds ds = new Ds();
        ds.solve();
    }
}
