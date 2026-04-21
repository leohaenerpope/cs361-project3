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

        System.out.println(lines.get(0));
    }
}