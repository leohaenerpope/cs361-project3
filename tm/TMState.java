package tm;

import java.util.HashMap;

/**
 * A state class for TM. This holds the transitions for a state.
 * The state identification is the key that is held in the TM states HashMap which points to these TMStates.
 */
public class TMState {
    private HashMap<Integer, TMStateTransition> transitions;

    public TMState(boolean halt) {
        this.transitions = new HashMap<>();
    }

    public void addTransition(int onSymbol, TMStateTransition newTransition){
        this.transitions.put(onSymbol, newTransition);
    }

    public TMStateTransition getTransition(int readSymbol) {
        return transitions.get(readSymbol);
    }
}
