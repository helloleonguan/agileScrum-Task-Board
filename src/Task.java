/**
 * Created by Administrator on 2015/12/2/0002.
 */
public class Task {
    public String Sid;
    public String Tid;
    public String description;
    public Status taskStatus;
    public boolean movable;

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
