import java.util.HashMap;

/**
 * Created by Administrator on 2015/12/3/0003.
 */
public class Board {
    public HashMap<String, Story> stories = new HashMap<>(); // Key is the story id and the value is the Story.
    public HashMap<String, Task> tasks = new HashMap<>(); // Key is the (story id +" "+ task id) and the value is the Task.


    public boolean createStory(String Sid, String description) {
        if (stories.containsKey(Sid)) {
            return false;
        } else {
            Story s = new Story(Sid,description);
            stories.put(Sid,s);
            return true;
        }
    }

    public String listStory() {
        String rst = "";
        for(String id : stories.keySet()) {
            rst += id + ": " + stories.get(id).description + "\n";
        }
        return rst;
    }

    public boolean deleteStory(String Sid) {
        if (! stories.containsKey(Sid)) {
            return false;
        } else {
            stories.remove(Sid);
            return true;
        }
    }

    public boolean completeStory(String Sid) {
        if (! stories.containsKey(Sid)) {
            return false;
        } else {
            stories.get(Sid).complete = true;
            return true;
        }
    }

    public boolean createTask(String storyID, String Tid, String description) {
        if(tasks.containsKey(storyID + " " +Tid) || (! stories.containsKey(storyID))) {
            return false;
        } else {
            Task t = new Task(storyID, Tid, description);
            tasks.put(storyID + " " +Tid, t);
            return true;
        }
    }

    public String listTasks(String Sid) {
        String rst = "";
        if (! stories.containsKey(Sid)) {
            return rst;
        } else {
            for (String k : tasks.keySet()) {
                if ( tasks.get(k).Sid.equals(Sid)) {
                    rst += k + ": " + tasks.get(k).description + "\n";
                }
            }
            return rst;
        }
    }

    public boolean deleteTask(String Sid, String Tid ) {
        if (! tasks.containsKey(Sid + " " + Tid)) {
            return false;
        } else {
            tasks.remove(Sid + " " + Tid);
            return true;
        }
    }

    public boolean moveTask(String Sid, String Tid, Status s){
        if (! tasks.containsKey(Sid + " " + Tid)) {
            return false;
        } else {
            Status stat = tasks.get(Sid + " " + Tid).taskStatus;
            if (stat == Status.DONE) {
                return false;
            } else {
                if (stat == Status.TO_DO && (s == Status.TO_VERIFY || s == Status.DONE)) {
                    return false;
                } else if (stat == Status.IN_PROCESS && s == Status.DONE) {
                    return false;
                } else {
                    tasks.get(Sid + " " + Tid).taskStatus = s;
                    return true;
                }
            }
        }
    }

    public boolean updateTask(String Sid, String Tid, String description) {
        if (! tasks.containsKey(Sid + " " + Tid)) {
            return false;
        } else {
            tasks.get(Sid + " " + Tid).description = description;
            return true;
        }
    }
}
