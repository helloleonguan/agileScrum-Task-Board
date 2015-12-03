import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2015/12/3/0003.
 */
public class Tests {

    //Sample data for testing purpose.

    // To Test the Story class
    @Test
    public void StoryTest() {

    }

    // To Test the Task class
    @Test
    public void TaskTest() {

    }

    // To test the Status class
    @Test
    public void StatusTest() {
        assertTrue(Status.TO_DO.toString().equals("To Do"));
        assertTrue(Status.IN_PROCESS.toString().equals("In Process"));
        assertTrue(Status.TO_VERIFY.toString().equals("To Verify"));
        assertTrue(Status.DONE.toString().equals("Done"));
    }


    // To test the Board class
    @Test
    public void  createStoryTest() {

    }

    @Test
    public void listStoryTest() {

    }

    @Test
    public void deleteStoryTest() {

    }

    @Test
    public void completeStoryTest() {

    }

    @Test
    public void createTaskTest() {

    }

    @Test
    public void listTasksTest() {

    }

    @Test
    public void deleteTaskTest() {

    }

    @Test
    public void moveTaskTest() {

    }

    @Test
    public void updateTaskTest() {

    }


}
