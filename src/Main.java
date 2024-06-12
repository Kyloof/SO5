import Algorithms.ACS;
import System.System32;

public class Main {
    public static void main(String[] args) {
        System32 system32 = new System32();
        system32.simulateACS(50,40, 5,100,30, 20, 10);
        System.out.println();
        system32.simualteAAS(50,70, 5,100,30, 20, 10);
        System.out.println();
        system32.simualteAAMS(50,70, 5,100,30, 20, 10);

    }
}