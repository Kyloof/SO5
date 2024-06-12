import Algorithms.ACS;
import System.System32;

public class Main {
    public static void main(String[] args) {
        System32 system32 = new System32();
        System.out.println("ACS");
        system32.simulateACS(50,40, 5,100,30, 20, 10);
        System.out.println();
        System.out.println("AAS");
        system32.simualteAAS(50,70, 100,30, 20, 10);
        System.out.println();
        System.out.println("AAMS");
        system32.simualteAAMS(50,70, 50,100,30, 20, 10);

    }
}