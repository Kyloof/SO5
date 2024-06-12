package Processor;

import java.util.Random;

public class Process {
    private int time;
    private int cpuLoad;
    Random random;

    public Process(int timeBound, int cpuLoadBound){
        random = new Random();
        this.time = random.nextInt(1,timeBound);
        this.cpuLoad = random.nextInt(1,cpuLoadBound);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(int cpuLoad) {
        this.cpuLoad = cpuLoad;
    }
}
