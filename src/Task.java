/**
 * Created by Administrator on 2015/12/2/0002.
 */
public class Task {
    private String Sid;
    private String Tid;
    private String description;
    private Status taskStatus;
    private boolean movable;

    public Task(String Sid, String Tid, String description) {
        this.Sid = Sid;
        this.Tid = Tid;
        this.description = description;
        this.taskStatus = Status.TO_DO;
        this.movable = true;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
