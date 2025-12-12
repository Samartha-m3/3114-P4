
import java.util.Random;

// All methods have been adapted from openDSA
public class SkipList<T extends Comparable<? super T>> {
    private SkipNode head;
    private int level;
    private int size;
    private Random ran;

    // Inner SkipNode class
    private class SkipNode {
        private String key;
        private T element;
        // Using array instead of the dictionary as shown in openDSA
        private SkipNode[] forward;

        @SuppressWarnings("unchecked")
        public SkipNode(String k, T elem, int level) {
            this.key = k;
            this.element = elem;
            forward = (SkipNode[])new SkipList<?>.SkipNode[level + 1];
        }


        public String key() {
            return key;
        }


        public T element() {
            return element;
        }
    }

    public SkipList(Random r) {
        head = new SkipNode(null, null, 0);
        level = -1;
        size = 0;
        ran = r;
    }


    public T find(String key) {
        SkipNode x = head;
        for (int i = level; i >= 0; i--) {
            while ((x.forward[i] != null) && (x.forward[i].key().compareTo(
                key) < 0)) {
                x = x.forward[i];
            }
        }
        x = x.forward[0];
        if ((x != null) && (x.key().compareTo(key) == 0)) {
            return x.element();
        }
        return null;
    }


    private int randomLevel() {
        int lev;
        for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) { 
            // Do nothing
        }
        return lev;
    }


    public void insert(String key, T elem) {
        int newLevel = randomLevel();
        if (newLevel > level) {
            adjustHead(newLevel);
        }

        @SuppressWarnings("unchecked")
        SkipNode[] update = (SkipNode[])new SkipList<?>.SkipNode[level + 1];
        SkipNode x = head;

        for (int i = level; i >= 0; i--) {
            while ((x.forward[i] != null) && (x.forward[i].key().compareTo(
                key) < 0)) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = new SkipNode(key, elem, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            x.forward[i] = update[i].forward[i];
            update[i].forward[i] = x;
        }
        size++;
    }


    private void adjustHead(int newLevel) {
        SkipNode temp = head;
        head = new SkipNode(null, null, newLevel);
        for (int i = 0; i <= level; i++) {
            head.forward[i] = temp.forward[i];
        }
        level = newLevel;
    }


    public T remove(String key) {
        @SuppressWarnings("unchecked")
        SkipNode[] update = (SkipNode[])new SkipList<?>.SkipNode[level + 1];
        SkipNode x = head;

        for (int i = level; i >= 0; i--) {
            while ((x.forward[i] != null) && (x.forward[i].key().compareTo(
                key) < 0)) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = x.forward[0];
        if ((x != null) && (x.key().compareTo(key) == 0)) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != x) {
                    break;
                }
                update[i].forward[i] = x.forward[i];
            }
            size--;
            return x.element();
        }
        return null;
    }


    public String rangeSearch(String min, String max) {
        StringBuilder sb = new StringBuilder();
        sb.append("Found these records in the range ").append(min);
        sb.append(" to ").append(max).append("\n");

        SkipNode x = head.forward[0];
        boolean foundAny = false;

        while (x != null) {
            if (x.key().compareTo(min) >= 0 && x.key().compareTo(max) <= 0) {
                sb.append(x.element().toString()).append("\n");
                foundAny = true;
            }
            if (x.key().compareTo(max) > 0) {
                break;
            }
            x = x.forward[0];
        }

        return sb.toString();
    }


    public String print() {
        StringBuilder sb = new StringBuilder();

        SkipNode x = head;
        int count = 0;

        while (x != null) {
            int depth = x.forward.length;

            if (x == head) {
                sb.append("Node has depth ").append(depth).append(
                    ", Value (null)\r\n");
            }
            else {
                sb.append("Node has depth ").append(depth).append(", ");
                sb.append("Value (").append(x.element().toString()).append(
                    ")\r\n");
                count++;
            }
            x = x.forward[0];
        }

        sb.append(count).append(" skiplist nodes printed\r\n");
        return sb.toString(); 
    }
    

}
