/**
 * Created by Administrator on 2015/12/2/0002.
 */
public class Story {
    private String Sid;
    private String description;
    private boolean complete;

    public Story(String Sid, String description){
        this.Sid = Sid;
        this.description = description;
        this.complete = false;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
