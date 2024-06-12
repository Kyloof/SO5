package System;

import Algorithms.AAMS;
import Algorithms.AAS;
import Algorithms.ACS;
import Algorithms.Algorithm;
import Processor.*;

import java.util.ArrayList;
import java.util.List;

public class System32 {
    List<Processor> processors;
    int totalOverloadTime;
    double avgOverloadTime;
    int totalInquiries;
    int migrationsNo;
    double avgLoad;
    ACS acs;
    AAS aas;
    AAMS aams;

    public System32(){
        this.processors = new ArrayList<>();
        this.totalOverloadTime = 0;
        this.avgOverloadTime = 0;
        this.totalInquiries = 0;
        this.avgLoad = 0;
        this.acs = new ACS();
        this.aas = new AAS();
        this.aams = new AAMS();

    }

    public void showResults(){
        System.out.println("Total inquiries: " + totalInquiries);
        System.out.println("Total migrations: " + migrationsNo);
        System.out.println("Total overload time: " + totalOverloadTime);
        System.out.println("Average overload time: " + avgOverloadTime);
        System.out.println("Average Load: " + avgLoad + "%");

        this.processors = new ArrayList<>();
        this.totalOverloadTime = 0;
        this.avgOverloadTime = 0;
        this.totalInquiries = 0;
        this.avgLoad = 0;
        this.acs = new ACS();
        this.aas = new AAS();
        this.aams = new AAMS();
    }


    public void simulateACS(int noProcessors, int limit, int inquiriesLimit, int time, float generationChance, int timeBound, int loadBound){
        ProcessorGenerator.generateProcessors(processors, noProcessors);

        for (int i = 0; i < time; i++){
            for (Processor processor : processors){
                avgLoad += processor.simulateOneTimeQuantum(generationChance, timeBound, loadBound, acs, limit, inquiriesLimit, processors);
            }
        }

        for (Processor processor : processors){
            this.totalInquiries += processor.getInquiriesNo();
            this.totalOverloadTime += processor.getOverloadTime();
            this.migrationsNo += processor.getMigrations();
        }
        this.avgOverloadTime = (double) this.totalOverloadTime / noProcessors;
        this.avgLoad = avgLoad / (time * noProcessors);
        showResults();
    }

    public void simualteAAS(int noProcessors, int limit, int time, float generationChance, int timeBound, int loadBound){
        ProcessorGenerator.generateProcessors(processors, noProcessors);

        for (int i = 0; i < time; i++){
            for (Processor processor : processors){
                avgLoad += processor.simulateOneTimeQuantum(generationChance, timeBound, loadBound, acs, limit, noProcessors, processors);
            }
        }

        for (Processor processor : processors){
            this.totalInquiries += processor.getInquiriesNo();
            this.totalOverloadTime += processor.getOverloadTime();
            this.migrationsNo += processor.getMigrations();
        }
        this.avgOverloadTime = (double) this.totalOverloadTime / noProcessors;
        this.avgLoad = avgLoad / (time * noProcessors);
        showResults();
    }

    public void simualteAAMS(int noProcessors, int limit, int friendshipLimit, int time, float generationChance, int timeBound, int loadBound){
        ProcessorGenerator.generateProcessors(processors, noProcessors);

        for (int i = 0; i < time; i++){
            for (Processor processor : processors){
                avgLoad += processor.simulateOneTimeQuantum(generationChance, timeBound, loadBound, aams, limit, friendshipLimit, processors);
            }
        }

        for (Processor processor : processors){
            this.totalInquiries += processor.getInquiriesNo();
            this.totalOverloadTime += processor.getOverloadTime();
            this.migrationsNo += processor.getMigrations();
        }
        this.avgOverloadTime = (double) this.totalOverloadTime / noProcessors;
        this.avgLoad = avgLoad / (time * noProcessors);
        showResults();
    }

}
