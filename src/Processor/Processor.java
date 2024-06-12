package Processor;

import Algorithms.Algorithm;

import java.util.*;

public class Processor {

    private List<Process> processes;
    int inquiriesNo;
    int overloadTime;
    private int cpuLoad;
    private final Random random;
    int migrations;

    public Processor(int seed){
        this.inquiriesNo = 0;
        this.overloadTime = 0;
        this.cpuLoad = 0;
        this.migrations = 0;
        this.random = new Random(seed);
        this.processes = new ArrayList<Process>();
    }



    public int simulateOneTimeQuantum(float processGenerationChance, int timeBound, int cpuLoadBound, Algorithm algorithm, int limit, int inquiriesLimit, List<Processor> processors){
        boolean newProcess = false;
        float genChance = random.nextFloat(0,1) * 10;
        if (genChance<processGenerationChance){
            processes.add(new Process(timeBound,cpuLoadBound));
            newProcess = true;
        }

        if (newProcess){
            migrations += algorithm.simulate(this, processors, limit, inquiriesLimit) ;
        }

        calculateCurrentCpuLoad();
        if (this.cpuLoad > 100){
            this.overloadTime++;
        }
        return cpuLoad;
    }

    public void calculateCurrentCpuLoad(){
        this.cpuLoad = 0;

        for (int i = processes.size() - 1; i >= 0; i--){

            processes.get(i).setTime(processes.get(i).getTime() - 1);

            if (processes.get(i).getTime() == 0) {
                processes.remove(i);
            }
            else{

                this.cpuLoad += processes.get(i).getCpuLoad();
            }
        }


    }

    public List<Process> getProcesses() {
        return processes;
    }

    public int getCpuLoad() {
        return cpuLoad;
    }

    public int getOverloadTime() {
        return overloadTime;
    }

    public int getMigrations() {
        return migrations;
    }

    public void setCpuLoad(int cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public int getInquiriesNo() {
        return inquiriesNo;
    }

    public void setInquiriesNo(int inquiriesNo) {
        this.inquiriesNo = inquiriesNo;
    }

}
