package Archive.OS;

import java.util.Scanner;

public class Priority {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of process : ");
        int numberOfProcesses = s.nextInt();
        int processsesId[] = new int[numberOfProcesses];
        int processPriority[] = new int[numberOfProcesses];
        int burstTime[] = new int[numberOfProcesses];
        int waitingTime[] = new int[numberOfProcesses];
        int turnarroundTime[] = new int[numberOfProcesses];
        int temp;

        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Proces ["+(i+1)+"]\n");

            System.out.println("Enter burst time");

            burstTime[i] = s.nextInt();

            System.out.println("Enter priority");
            processPriority[i] = s.nextInt();
            processsesId[i] = i+1;
        }

        //sorting on the basis of priority
        for (int i = 0; i < numberOfProcesses -1; i++) {
            for (int j = i+1; j < numberOfProcesses; j++) {
                if (processPriority[i] > processPriority[j]){
                    temp = processPriority[i];
                    processPriority[i] = processPriority[j];
                    processPriority[j] = temp;

                    temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;

                    temp = processsesId[i];
                    processsesId[i] = processsesId[j];
                    processsesId[j] = temp;
                }
            }
        }

        waitingTime[0] = 0;
        turnarroundTime[0] = burstTime[0];

        int totalWatingTime = 0;
        int totalTurnArroundTime = turnarroundTime[0];

        for (int i = 1; i <numberOfProcesses ; i++) {
            waitingTime[i] = turnarroundTime[i-1];
            turnarroundTime[i] = waitingTime[i] + burstTime[i];
        }
        for (int i = 0; i < numberOfProcesses; i++) {
            totalWatingTime += waitingTime[i];
            totalTurnArroundTime += turnarroundTime[i];
        }
        System.out.println("\nProcess \t Burst Time \t Wait Time \t Turn Around \t Priority");
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println(processsesId[i] + "\t\t\t"+burstTime[i] + "\t\t\t\t"+waitingTime[i]
            +"\t\t\t"+turnarroundTime[i]+"\t\t\t\t"+processPriority[i]);
        }
        int avgWaitingTime = totalWatingTime / numberOfProcesses ;
        int avgTurnArroundTime = totalTurnArroundTime/numberOfProcesses;
        System.out.println("Average Wait Time : "+avgWaitingTime);
        System.out.println("Average Turn Around Time : "+avgTurnArroundTime);
        s.close();
    }
}