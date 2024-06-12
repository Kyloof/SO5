package Algorithms;

import Processor.Processor;

import java.util.List;

public class AAMS implements Algorithm{
    @Override
    public int simulate(Processor processor, List<Processor> processList, int p, int r) {

        if (processor.getCpuLoad() > p){
            for (Processor processorNeighbour : processList){
                if (processorNeighbour != processor){
                    processor.setInquiriesNo(processor.getInquiriesNo() + 1);
                    if (processorNeighbour.getCpuLoad() < p){
                        processorNeighbour.getProcesses().add(processor.getProcesses().removeLast());
                        return 1;
                    }
                }
            }
        }
        int lastCpuLoad = -1;
        int migrationsDone = 0;
        while (processor.getCpuLoad() < r && processor.getCpuLoad()!=lastCpuLoad){
            lastCpuLoad = processor.getCpuLoad();
            for (Processor processor1 : processList){
                while (processor1.getCpuLoad() > p && processor.getCpuLoad() <= p){

                    processor1.setCpuLoad(processor.getCpuLoad() - processor1.getProcesses().getLast().getCpuLoad());
                    processor.getProcesses().add(processor1.getProcesses().removeLast());
                    migrationsDone++;
                }
            }

        }

        return migrationsDone;
    }
}
