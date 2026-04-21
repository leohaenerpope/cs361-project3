package tm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class TM {
    private TMTapeNode head;

    private HashMap<Integer, TMState> states;

    private int currentStateLabel;
    private int amountStates;

    /**
     * Constructor for a Turing Machine node
     * 
     * @param amountStates - the amount of states the TM will have
     * @param tapeSymbols - a preset array of (int) symbols for the tape to start as, empty array if preset tape is empty
     * [1, 2, 3] - preset tape of 123
     * This array should be created in TMSimulator
     * 
     */
    public TM(int amountStates, int[] tapeSymbols) {
        // Turn the tape int array into TMTapeNode linked-list-like tape
        if (tapeSymbols.length == 0) {
            head = new TMTapeNode(null, null, 0);
        } else {
            head = new TMTapeNode(null, null, tapeSymbols[0]);
            TMTapeNode startingHead = head;
            for (int i = 1; i < tapeSymbols.length; i++) {
                head = head.add(tapeSymbols[i]);
            }
            head = startingHead;
        }

        // Add in states
        this.states = new HashMap<>();
        for (int i = 0; i < amountStates-1; i++){
            this.states.put(i, new TMState(false));
        }
        this.states.put(amountStates, new TMState(true));

        
        this.amountStates = amountStates;
    }

    /**
     * Add a single transition for a specific state in the TM
     * 
     * @param stateLabel the state for the new transition to be added to
     * @param onSymbol the symbol for the transition to go on (read symbol)
     * @param newStateLabel new state to go to
     * @param write the new written symbol to be written on the tape
     * @param move direction for the tape to go, either 'L' or 'R'
     * @return
     */
    public boolean addStateTransition(int stateLabel, int onSymbol, int newStateLabel, int write, char move){
        if (states.containsKey(stateLabel)){
            return false;
        }
        TMStateTransition newTransition = new TMStateTransition(newStateLabel, write, move);
        states.get(stateLabel).addTransition(onSymbol, newTransition);
        return true;

    }

    /**
     * Iterates the TM through one transition.
     * 
     * @return false if the machine is in a halt state and can't move, true if machine can move.
     */
    public boolean move(){
        if (currentStateLabel == amountStates-1){
            return false;
        }
        TMStateTransition newTransition = states.get(currentStateLabel).getTransition(head.getValue());
        currentStateLabel = newTransition.getNewStateLabel();
        head.setValue(newTransition.getWrite());
        if (newTransition.getMove() == 'L') { // No support for S
            head = head.goLeft();
        } else {
            head = head.goRight();
        }
        return true;
    }


}
