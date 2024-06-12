package Algorithms;

import Processor.Processor;

import java.util.List;

public class AAMS implements Algorithm {
    @Override
    public int simulate(Processor processor, List<Processor> processList, int p, int r) {
        int migrationsDone = 0;
        if (processor.getCpuLoad() <= p) {
            int lastLoad = -1;
            while (processor.getCpuLoad() <= r && lastLoad != processor.getCpuLoad()){
                lastLoad = processor.getCpuLoad();
                for (Processor processorNeighbour : processList) {
                    if (processorNeighbour != processor) {
                        processor.setInquiriesNo(processor.getInquiriesNo() + 1);
                        if (processorNeighbour.getCpuLoad() > p) {
                            processorNeighbour.setCpuLoad(processorNeighbour.getProcesses().getLast().getCpuLoad());
                            processor.getProcesses().add(processorNeighbour.getProcesses().removeLast());
                            processor.setCpuLoad(processor.getCpuLoad() + processor.getProcesses().getLast().getCpuLoad());
                            migrationsDone++;
                        }
                    }
                }
                return migrationsDone;
            }
        } else {
            for (Processor processorNeighbour : processList) {
                if (processorNeighbour != processor) {
                    processor.setInquiriesNo(processor.getInquiriesNo() + 1);
                    if (processorNeighbour.getCpuLoad() < p) {
                        processorNeighbour.getProcesses().add(processor.getProcesses().removeLast());
                        return 1;
                    }
                }
            }
            return 0;
        }

        return 0;
    }
}
