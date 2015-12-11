/**
 * Created by Administrator on 2015/12/2/0002.
 */
public enum Status {
    TO_DO("To Do"),
    IN_PROCESS("In Process"),
    TO_VERIFY("To Verify"),
    DONE("Done");

    private String status; // For printing Status.DONE.status.

    Status(String s) {
        this.status = s;
    }

    @Override
    public String toString() {
        return this.status;
    }

    public static Status toStatus(String stat) {
        String stdStat = stat.toLowerCase();
        if (stdStat.equals("to do")) {
            return Status.TO_DO;
        } else if (stdStat.equals("to verify")) {
            return Status.TO_VERIFY;
        } else if (stdStat.equals("in process")) {
            return Status.IN_PROCESS;
        } else if (stdStat.equals("done")) {
            return Status.DONE;
        } else {
            return null;
        }
    }
}
