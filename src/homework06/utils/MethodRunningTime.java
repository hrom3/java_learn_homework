package homework06.utils;

public class MethodRunningTime {
    private long startTime;
    private long endTime;
    private String operation;

    public MethodRunningTime(String operation) {
        this.operation = operation;
        this.startTime = System.currentTimeMillis();
    }

    public MethodRunningTime() {
        this.startTime = System.currentTimeMillis();
    }

 //   public long getStartTime() {
//        return startTime;
//    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public void printRunningTime() {
        System.out.println("Операция: " + this.operation +
                ". Заняла: " + (this.endTime - this.startTime) + " мс");
    }

    public String toString() {
        return "Операция: " + this.operation + ". Заняла: " +
                (this.endTime - this.startTime) + " мс";
    }

    public String setEndTimeAndToString() {
        endTime = System.currentTimeMillis();
        return "Операция: " + operation + ". Заняла: " +
                (this.endTime - this.startTime) + " мс";
    }
}
