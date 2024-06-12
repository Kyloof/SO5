package Algorithms;

import Processor.Processor;

import java.util.ArrayList;
import java.util.List;

public interface Algorithm {
    int simulate(Processor processor, List<Processor> processList, int p, int z);
}
