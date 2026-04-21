package tm;

public class TMStateTransition {
    private int newStateLabel;
    private int write;
    private char move;

    public TMStateTransition(int newStateLabel, int write, char move) {
        this.newStateLabel = newStateLabel;
        this.write = write;
        this.move = move;
    }

    public int getNewStateLabel() {
        return this.newStateLabel;
    }

    public int getWrite() {
        return this.write;
    }
    public char getMove() {
        return this.move;
    }
}
