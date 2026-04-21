package tm;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class TMSimulator {
    public static void main(String[] args) throws IOException{
        if (args.length == 0){
            System.out.println("Provide a file name for TM");
            return;
        }
        String fileName = args[0];
        Path path = Paths.get(fileName);
        
        List<String> lines = Files.readAllLines(path);

        int stateAmount = Integer.parseInt(lines.get(0));
        int symbolAmount = Integer.parseInt(lines.get(1));

        String tapeInputString = lines.get(lines.size()-1);
        boolean hasTapeInput = !tapeInputString.contains(",");
        int[] tapeInput;
        if (hasTapeInput){
            tapeInput = new int[tapeInputString.length()];
            for (int i = 0; i < tapeInputString.length(); i++){
                tapeInput[i] = tapeInputString.charAt(i) - '0';
            }
        } else {
            tapeInput = new int[0];
        }

        TM tm = new TM(stateAmount, tapeInput);


        // Add in transitions parsed from input .txt files
        // Keeps track of the currentState and currentSymbol from where we are in the for loop
        int forLoopEnd = lines.size();
        if (hasTapeInput){
            forLoopEnd -= 1;
        }
        
        for (int i = 2; i < forLoopEnd; i++){
            int currentState = (i-2) / (symbolAmount+1);
            int currentSymbol = (i-2) % (symbolAmount + 1); // symbolAmount + 1 accounts for 0 symbol
            String[] stringInfo = lines.get(i).split(",");
            int newState = Integer.parseInt(stringInfo[0]);
            int write = Integer.parseInt(stringInfo[1]);
            char direction = stringInfo[2].charAt(0);
            tm.addStateTransition(currentState, currentSymbol, newState, write, direction);
        }

        boolean notHalted = true;
        while (notHalted) {
            notHalted = tm.move();
        }

        System.out.println(tm.toString());
    }
}