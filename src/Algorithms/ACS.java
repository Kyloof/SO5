package Algorithms;

import Processor.Processor;

import java.util.ArrayList;
import java.util.List;

public class ACS implements Algorithm{
    @Override
    public int simulate(Processor processor, List<Processor> processList, int p, int z) {
        int currentInquiries = 0;
        for (Processor processorNeighbour : processList){
            if (processorNeighbour != processor){
                processor.setInquiriesNo(processor.getInquiriesNo() + 1);
                if (processorNeighbour.getCpuLoad() < p){
                    processorNeighbour.getProcesses().add(processor.getProcesses().removeLast());
                    return 1;
                }
            }
            currentInquiries++;
            if (currentInquiries>=z){
                return 0;
            }
        }
        return 0;
    }
}
