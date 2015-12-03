import java.util.HashMap;

/**
 * Created by Administrator on 2015/12/3/0003.
 */
public class Board {
    private HashMap<String, Story> stories = new HashMap<>(); // Key is the story id and the value is the Story.
    private HashMap<String, Task> tasks = new HashMap<>(); // Key is the task id and the value is the Task.


    public boolean createStory(String Sid, String description) {
        return false;
    }

    public boolean listStory() {
        return false;
    }

    public boolean deleteStory(String Sid) {
        return false;
    }

    public boolean completeStory(String Sid) {
        return false;
    }

    public boolean createTask(String storyID, String Tid, String description) {
        return false;
    }

    public boolean listTasks(String Sid) {
        return false;
    }

    public boolean deleteTask(String Sid, String Tid ) {
        return false;
    }

    public boolean moveTask(String Sid, String Tid, Status s){
        return false;
    }

    public boolean updateTask(String Sid, String Tid, String description) {
        return false;
    }
}
