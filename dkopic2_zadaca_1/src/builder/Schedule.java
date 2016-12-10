package builder;

/**
 * POJO Schedule
 */
public class Schedule {
    private String divingDate;
    private String divingTime;
    private int maxDivingDepth;
    private int diversNum;

    private Schedule(ScheduleBuilder scheduleBuilder) {
        this.divingDate = scheduleBuilder.divingDate;
        this.divingTime = scheduleBuilder.divingTime;
        this.maxDivingDepth = scheduleBuilder.maxDivingDepth;
        this.diversNum = scheduleBuilder.diversNum;
    }

    public String getDivingDate() {
        return divingDate;
    }

    public String getDivingTime() {
        return divingTime;
    }

    public int getMaxDivingDepth() {
        return maxDivingDepth;
    }

    public int getDiversNum() {
        return diversNum;
    }

    /**
     * Builder class
     */
    public static class ScheduleBuilder {
        private String divingDate;
        private String divingTime;
        private int maxDivingDepth;
        private int diversNum;
        private String line;

        public ScheduleBuilder(String line) {
            this.line = line;
        }

        public Schedule build() {
            String[] parts = line.split(";");

            if (parts.length == 4) {
                divingDate = parts[0];
                divingTime = parts[1];
                maxDivingDepth = Integer.parseInt(parts[2]);
                diversNum = Integer.parseInt(parts[3]);
                return new Schedule(this);
            }

            return null;
        }
    }
}
