package greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Override
    public String toString() {
        return "Activity["+startTime+","+finishTime+"]";
    }
}

public class TestActivitySelectionProblem {

    public static void main(String[] args) {
        List<Activity> activityList = new ArrayList<>();
        activityList.add(new Activity(5,9));
        activityList.add(new Activity(1,2));
        activityList.add(new Activity(3,4));
        activityList.add(new Activity(0,6));
        activityList.add(new Activity(5,7));
        activityList.add(new Activity(8,9));

        Collections.sort(activityList);
        //System.out.println(activityList);
        TestActivitySelectionProblem tasp = new TestActivitySelectionProblem();
        tasp.activitySelectionProblemWithUnsortedInput(activityList);
        int[] startTime = {1,3,0,5,8,5};
        int[] finishTime = {2,4,6,7,9,9};
        tasp.activitySelectionProblemWithSortedInput(startTime, finishTime);

    }

    public void activitySelectionProblemWithUnsortedInput(List<Activity> activityList) {
        int activitiesSize = activityList.size();
        int i=0, j=0;

        System.out.println(activityList.get(i));
        for(i=1;i<activitiesSize;i++) {
            Activity prevActivity = activityList.get(j);
            Activity currentActivity = activityList.get(i);
            if(prevActivity.finishTime <= currentActivity.startTime) {
                System.out.println(currentActivity);
                j = i;
            }

        }
    }

    public void activitySelectionProblemWithSortedInput(int[] startTime, int[] finishTime) {
        int i=0,j=0;
        int length = startTime.length;
        System.out.println(i+" -> "+ startTime[i] + "," + finishTime[i]);
        for(i=1;i<length;i++) {
            if(finishTime[j] <= startTime[i]) {
                System.out.println(i+" -> "+startTime[i]+ "," + finishTime[i]);
                j = i;
            }
        }
    }


}
