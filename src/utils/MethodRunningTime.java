package utils;

public class MethodRunningTime {
    private long startTime;
    private long endTime;

    public MethodRunningTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public void printRunningTime(String operation) {
        endTime = System.currentTimeMillis();
        System.out.println("Операция: " + operation +
                ". Заняла: " + (endTime - this.startTime) + " мс");
    }
}
