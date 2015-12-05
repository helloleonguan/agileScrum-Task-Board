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
        Board board = new Board();
        assertTrue(board.createStory("A01", "To complete Story A01"));
        assertTrue(board.stories.containsKey("A01"));
        assertTrue(board.stories.get("A01").description.equals("To complete Story A01"));
        assertTrue(board.createStory("A02", "To complete Story A02"));
        assertTrue(board.stories.containsKey("A02"));
        assertTrue(board.stories.get("A02").description.equals("To complete Story A02"));
        assertTrue(!board.createStory("A01", "To complete Story A01"));
    }

    @Test
    public void listStoryTest() {
        Board board = new Board();
        assertTrue(board.listStory().equals(""));
        board.createStory("A01", "To complete Story A01");
        assertTrue(board.listStory().equals("A01: To complete Story A01\n"));
        board.createStory("A02", "To complete Story A02");
        assertTrue(board.listStory().equals("A01: To complete Story A01\nA02: To complete Story A02\n") ||
                board.listStory().equals("A02: To complete Story A02\nA01: To complete Story A01\n"));
    }

    @Test
    public void deleteStoryTest() {
        Board board = new Board();
        board.createStory("A01", "To complete Story A01");
        board.createStory("A02", "To complete Story A02");
        board.createStory("A03", "To complete Story A03");
        board.createStory("A04", "To complete Story A04");
        assertTrue(board.stories.containsKey("A03"));
        assertTrue(board.deleteStory("A03"));
        assertTrue(!board.stories.containsKey("A03"));
        assertTrue(!board.deleteStory("A05"));
    }

    @Test
    public void completeStoryTest() {
        Board board = new Board();
        board.createStory("A01", "To complete Story A01");
        board.createStory("A02", "To complete Story A02");
        board.createStory("A03", "To complete Story A03");
        assertTrue(!board.stories.get("A02").complete);
        assertTrue(board.completeStory("A02"));
        assertTrue(board.stories.get("A02").complete);
        assertTrue(!board.completeStory("A05"));
    }

    @Test
    public void createTaskTest() {
        Board board = new Board();
        board.createStory("A01", "To complete Story A01");
        board.createStory("A02", "To complete Story A02");
        board.createStory("A03", "To complete Story A03");
        assertTrue(!board.createTask("A04", "0001", "To complete Task A04-0001"));
        board.createStory("A04", "To complete Story A04");
        assertTrue(board.createTask("A04", "0001", "To complete Task A04-0001"));
        assertTrue(board.tasks.containsKey("A04 0001"));
        assertTrue(board.tasks.get("0001").description.equals("To complete Task A04-0001"));
        assertTrue(board.tasks.get("0001").movable);
        assertTrue(board.tasks.get("0001").taskStatus == Status.TO_DO);
    }

    @Test
    public void listTasksTest() {
        Board board = new Board();
        board.createStory("A01", "To complete Story A01");
        assertTrue(board.listTasks("A02").equals(""));
        assertTrue(board.listTasks("A01").equals(""));
        board.createTask("A01", "0001", "To complete Task A01-0001");
        assertTrue(board.listTasks("A01").equals("A01 0001: To complete Task A01-0001\n"));
        board.createTask("A01", "0002", "To complete Task A01-0002");
        assertTrue(board.listTasks("A01").equals("A01 0001: To complete Task A01-0001\nA01 0002: To complete Task A01-0002\n")
            || board.listTasks("A01").equals("A01 0002: To complete Task A01-0002\nA01 0001: To complete Task A01-0001\n"));
    }

    @Test
    public void deleteTaskTest() {
        Board board = new Board();
        board.createStory("A01", "To complete Story A01");
        board.createStory("A02", "To complete Story A02");
        board.createTask("A01", "0001", "To complete Task A01-0001");
        board.createTask("A01", "0002", "To complete Task A01-0002");
        assertTrue(board.tasks.containsKey("A01 0001"));
        assertTrue(board.deleteTask("A01", "0001"));
        assertTrue(!board.tasks.containsKey("A01 0001"));
        assertTrue(!board.deleteTask("A02", "0001"));
        assertTrue(!board.deleteTask("A02", "0003"));
    }

    @Test
    public void moveTaskTest() {
        Board board = new Board();
        board.createStory("A01", "To complete Story A01");
        board.createStory("A02", "To complete Story A02");
        board.createTask("A01", "0001", "To complete Task A01-0001");
        board.createTask("A01", "0002", "To complete Task A01-0002");
        assertTrue(!board.moveTask("A01", "0003", Status.IN_PROCESS));
        assertTrue(!board.moveTask("A03", "0002", Status.TO_VERIFY));
        assertTrue(board.moveTask("A02", "0002", Status.IN_PROCESS));
        assertTrue(!board.moveTask("A02", "0002",Status.TO_VERIFY));
        assertTrue(!board.moveTask("A02", "0002",Status.DONE));
        assertTrue(board.moveTask("A02", "0002", Status.TO_VERIFY));
        assertTrue(board.moveTask("A02", "0002", Status.IN_PROCESS));
        assertTrue(board.moveTask("A02", "0002", Status.TO_DO));
        assertTrue(board.moveTask("A02", "0002", Status.IN_PROCESS));
        assertTrue(board.moveTask("A02", "0002", Status.TO_VERIFY));
        assertTrue(board.moveTask("A02", "0002", Status.DONE));
        assertTrue(!board.moveTask("A02", "0002", Status.IN_PROCESS));
        assertTrue(!board.moveTask("A02", "0002", Status.TO_DO));
        assertTrue(!board.moveTask("A02", "0002", Status.TO_VERIFY));

    }

    @Test
    public void updateTaskTest() {
        Board board = new Board();
        board.createStory("A01", "To complete Story A01");
        board.createStory("A02", "To complete Story A02");
        board.createTask("A01", "0001", "To complete Task A01-0001");
        board.createTask("A01", "0002", "To complete Task A01-0002");
        assertTrue(!board.updateTask("A03", "0001", "To complete Task A03-0001"));
        assertTrue(!board.updateTask("A02","0002", "To complete Task A02-0002"));
        assertTrue(board.updateTask("A01","0001", "To complete Task A01-0001#"));
        assertTrue(board.tasks.containsKey("A01 0001"));
        assertTrue(board.tasks.get("A01 0001").description.equals("To complete Task A01-0001#"));
    }


}
