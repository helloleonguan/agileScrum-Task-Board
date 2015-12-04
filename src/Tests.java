import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2015/12/3/0003.
 */
public class Tests {
    //Sample data for testing purpose.
    Story[] stories = {new Story("A01", "To complete Story A01"), new Story("A02", "To complete Story A02"),
            new Story("A03", "To complete Story A03"), new Story("A04", "To complete Story A04"),
            new Story("A05", "To complete Story A05"), new Story("A06", "To complete Story A06"),
            new Story("A07", "To complete Story A07"), new Story("A08", "To complete Story A08"),
            new Story("A09", "To complete Story A09"), new Story("A10", "To complete Story A10")};

    Task[] tasks = {new Task("A01", "0001", "To complete Task A01-0001"), new Task("A01", "0002", "To complete Task A01-0002"),
            new Task("A01", "0003", "To complete Task A01-0003"), new Task("A01", "0004", "To complete Task A01-0004"),
            new Task("A02", "0001", "To complete Task A02-0001"), new Task("A02", "0002", "To complete Task A02-0002"),
            new Task("A03", "0001", "To complete Task A03-0001"), new Task("A04", "0001", "To complete Task A04-0001"),
            new Task("A05", "0001", "To complete Task A05-0001"), new Task("A06", "0001", "To complete Task A06-0001"),
            new Task("A07", "0001", "To complete Task A07-0001"), new Task("A08", "0001", "To complete Task A08-0001"),
            new Task("A09", "0001", "To complete Task A09-0001"), new Task("A10", "0001", "To complete Task A10-0001"),};


    // To Test the Story class
    @Test
    public void StoryTest() {
        assertTrue(stories[0].toString().equals("To complete Story A01"));
        assertTrue(stories[1].toString().equals("To complete Story A02"));
        assertTrue(stories[0].Sid.equals("A01"));
        assertTrue(stories[1].Sid.equals("A02"));
        assertTrue(! stories[0].complete);

    }

    // To Test the Task class
    @Test
    public void TaskTest() {
        assertTrue(tasks[0].Sid.equals("A01"));
        assertTrue(tasks[0].Tid.equals("0001"));
        assertTrue(tasks[0].description.equals("To complete Task A01-0001"));
        assertTrue(tasks[0].movable);
        assertTrue(tasks[0].taskStatus == Status.TO_DO);

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
