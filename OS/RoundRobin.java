package Archive.OS;

public class RoundRobin {


    static void findavgTime(int processes[], int bTimes[], int quantum) {
        int waitingTimes[] = new int[processes.length];
        int totalWaitingTime = 0;

        findWaitingTime(processes, bTimes, waitingTimes,quantum);



        for (int i=0; i<processes.length; i++)
        {
            totalWaitingTime = totalWaitingTime + waitingTimes[i];
        }

        System.out.println("Average waiting time = " +
                (float)totalWaitingTime / (float)processes.length);
    }
    static void findWaitingTime(int processes[],  int burstTime[], int waitingTime[], int quantum) {

        int remainBurstTime[] = new int[processes.length];
        for (int i = 0 ; i < processes.length ; i++)
            remainBurstTime[i] =  burstTime[i];

        int t = 0;

        while(true) {
            boolean done = true;

            for (int i = 0 ; i < processes.length; i++) {

                if (remainBurstTime[i] > 0) {
                    done = false;
                    if (remainBurstTime[i] > quantum) {
                        t += quantum;
                        remainBurstTime[i] -= quantum;
                    }

                    else {
                        t = t + remainBurstTime[i];
                        waitingTime[i] = t - burstTime[i];
                        remainBurstTime[i] = 0;
                    }
                }
            }

            if (done == true){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int processes [] = {1,2,3,4,5};

        int burst_time[] = {8,2,7,3,5};

        int quantum = 3;

        findavgTime(processes,  burst_time, quantum);
    }
}