package Algorithms;

import Processor.Processor;

import java.util.List;

public class AAS implements Algorithm{
    @Override
    public int simulate(Processor processor, List<Processor> processList, int p, int z) {
        if (processor.getCpuLoad() <= p){
            return 0;
        }
        else{
            for (Processor processorNeighbour : processList){
                if (processorNeighbour != processor){
                    processor.setInquiriesNo(processor.getInquiriesNo() + 1);
                    if (processorNeighbour.getCpuLoad() < p){
                        processorNeighbour.getProcesses().add(processor.getProcesses().removeLast());
                        return 1;
                    }
                }
            }
            return 0;
        }
    }
}
