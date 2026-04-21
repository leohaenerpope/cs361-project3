package tm;

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

    public TMTapeNode goLeft(){
        if (this.left == null) {
            this.left = new TMTapeNode(null, this, 0);
        }
        return this.left;
    }

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
