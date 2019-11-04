package greedyalgorithms;

class Activity implements Comparable<Activity>{
    int startTime;
    int finishTime;

    public  Activity(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Activity o) {
        return this.finishTime - o.finishTime;
    }
}

public class TestActivitySelectionProblem {

    public static void main(String[] args) {

    }
}
