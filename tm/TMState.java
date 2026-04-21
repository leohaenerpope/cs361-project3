package tm;

import java.util.HashMap;

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
