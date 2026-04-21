package tm;

/**
 * A node points left and right to other nodes, acting like a linked list.
 * However, TM stores a head node to keep track of where it's at, so get()
 * is still O(1) constant time.
 */
public class TMTapeNode {
    private TMTapeNode left;
    private TMTapeNode right;
    private int value;

    public TMTapeNode(TMTapeNode left, TMTapeNode right, int value){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TMTapeNode add(int value){
        this.right = new TMTapeNode(this, null, value);
        return this.right;
    }

    /**
     * Returns the left tapeNode or a new TapeNode with value of 0 if there are no nodes to the left
     * @return left TapeNode
     */
    public TMTapeNode goLeft(){
        if (this.left == null) {
            this.left = new TMTapeNode(null, this, 0);
        }
        return this.left;
    }

    /**
     * Returns the right tapeNode or a new TapeNode with value of 0 if there are no nodes to the right
     * @return right TapeNode
     */
    public TMTapeNode goRight(){
        if (this.right == null) {
            this.right = new TMTapeNode(this, null, 0);
        }
        return this.right;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
