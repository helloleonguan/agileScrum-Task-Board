/**
 * Created by Administrator on 2015/12/2/0002.
 */
public enum Status {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    TO_VERIFY("To Verify"),
    DONE("Done");

    private String status; // For printing Status.DONE.status. 

    Status(String s) {
        this.status = s;
    }
}
