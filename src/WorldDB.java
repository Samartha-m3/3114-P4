import java.util.Random;

/**
 * The world for this project. We have a Skip List and a Bintree
 *
 * @author Samartha Madhyastha (samartha), Trisha Bajpai (trisha23)
 * @version 11/15/25
 */
public class WorldDB implements ATC {
    private final int worldSize = 1024;
    private Random rnd;
    private SkipList<AirObject> skipList;
    private BinTree binTree;

    /**
     * Create a brave new World.
     * 
     * @param r
     *            A random number generator to use
     *
     */
    public WorldDB(Random r) {
        rnd = r;
        clear();
    }


    /**
     * Clear the world
     *
     */
    public void clear() {
        skipList = new SkipList<>(rnd);
        binTree = new BinTree(worldSize);
    }


    // ----------------------------------------------------------
    /**
     * (Try to) insert an AirObject into the database
     * 
     * @param a
     *            An AirObject.
     * @return True iff the AirObject is successfully entered into the database
     */
    public boolean add(AirObject a) {
        if (!isValid(a)) {
            return false;
        }

        // Check if name already exists
        if (skipList.find(a.getName()) != null) {
            return false;
        }

        skipList.insert(a.getName(), a);
        return true;
    }


    public boolean isValid(AirObject a) {
        if (a == null || a.getName() == null || a.getName().isEmpty()) {
            return false;
        }
        if (a.isInvalid()) {
            return false;
        }

        if (a.getXorig() < 0 || a.getXorig() > worldSize - 1 || a.getYorig() < 0
            || a.getYorig() > worldSize - 1 || a.getZorig() < 0 || a
                .getZorig() > worldSize - 1) {
            return false;
        }
        if (a.getXwidth() < 1 || a.getXwidth() > worldSize || a.getYwidth() < 1
            || a.getYwidth() > worldSize || a.getZwidth() < 1 || a
                .getZwidth() > worldSize) {
            return false;
        }
        return !(a.getXorig() + a.getXwidth() > worldSize || a.getYorig() + a
            .getYwidth() > worldSize || a.getZorig() + a
                .getZwidth() > worldSize);

    }


    // ----------------------------------------------------------
    /**
     * The AirObject with this name is deleted from the database (if it exists).
     * Print the AirObject's toString value if one with that name exists.
     * If no such AirObject with this name exists, return null.
     * 
     * @param name
     *            AirObject name.
     * @return A string representing the AirObject, or null if no such name.
     */
    public String delete(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }

        AirObject obj = skipList.remove(name);
        if (obj == null) {
            return null;
        }

        return obj.toString();
    }


    // ----------------------------------------------------------
    /**
     * Return a listing of the Skiplist in alphabetical order on the names.
     * See the sample test cases for details on format.
     * 
     * @return String listing the AirObjects in the Skiplist as specified.
     */
    public String printskiplist() {
        return skipList.print();
    }


    // ----------------------------------------------------------
    /**
     * Return a listing of the Bintree nodes in preorder.
     * See the sample test cases for details on format.
     * 
     * @return String listing the Bintree nodes as specified.
     */
    public String printbintree() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Print an AirObject with a given name if it exists
     * 
     * @param name
     *            The name of the AirObject to print
     * @return String showing the toString for the AirObject if it exists
     *         Return null if there is no such name
     */
    public String print(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }

        AirObject obj = skipList.find(name);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }


    // ----------------------------------------------------------
    /**
     * Return a listing of the AirObjects found in the database between the
     * min and max values for names.
     * See the sample test cases for details on format.
     * 
     * @param start
     *            Minimum of range
     * @param end
     *            Maximum of range
     * @return String listing the AirObjects in the range as specified.
     *         Null if the parameters are bad
     */
    public String rangeprint(String start, String end) {
        if (start == null || end == null) {
            return null;
        }

        if (start.compareTo(end) > 0) {
            return null;
        }

        return skipList.rangeSearch(start, end);
    }


    // ----------------------------------------------------------
    /**
     * Return a listing of all collisions between AirObjects bounding boxes
     * that are found in the database.
     * See the sample test cases for details on format.
     * Note that the collision is only reported for the node that contains the
     * origin of the intersection box.
     * 
     * @return String listing the AirObjects that participate in collisions.
     */
    public String collisions() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Return a listing of all AirObjects whose bounding boxes
     * that intersect the given bounding box.
     * Note that the collision is only reported for the node that contains the
     * origin of the intersection box.
     * See the sample test cases for details on format.
     * 
     * @param x
     *            Bounding box upper left x
     * @param y
     *            Bounding box upper left y
     * @param z
     *            Bounding box upper left z
     * @param xwid
     *            Bounding box x width
     * @param ywid
     *            Bounding box y width
     * @param zwid
     *            Bounding box z width
     * @return String listing the AirObjects that intersect the given box.
     *         Return null if any input parameters are bad
     */
    public String intersect(int x, int y, int z, int xwid, int ywid, int zwid) {
        return null;
    }
}
