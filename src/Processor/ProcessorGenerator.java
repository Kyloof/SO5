package Processor;

import java.util.List;
import java.util.Random;

public class ProcessorGenerator {

    public static void generateProcessors(List<Processor> processorList, int noProcessors){
        Random random = new Random();
        for (int i = 0; i<noProcessors; i++) {
            processorList.add(new Processor(random.nextInt()));
        }
    }
}
