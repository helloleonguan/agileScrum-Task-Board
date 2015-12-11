import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/12/3/0003.
 */
public class Reader {

    public static String[] parseCommand(String command) {
        String[] info = command.split("\\s+");
        return info;
    }

    public static void main(String[] args) {
        Board board = new Board();
        boolean terminate = false;
        Scanner in = new Scanner(System.in);

        while(!terminate) {
            String operation = in.nextLine();
            String[] info = parseCommand(operation);

            if (operation.equals("quit")) {
                terminate = true;
            } else if (operation.lastIndexOf("create story") == 0 && info.length >= 4) {
                for (int i = 4; i < info.length; i ++) {
                    info[3] += " " + info[i];
                }
                if (board.createStory(info[2],info[3])) {
                    System.out.println("0");
                } else {
                    System.out.println("1"); // Error
                }
            } else if (operation.lastIndexOf("list stories") == 0 && info.length == 2){
                System.out.print(board.listStory());
                System.out.println("0");
            } else if (operation.lastIndexOf("delete story") == 0 && board.deleteStory(info[2]) && info.length == 3){
                System.out.println("0"); // Success
            } else if (operation.lastIndexOf("complete story") == 0 && board.completeStory(info[2]) && info.length == 3) {
                System.out.println("0");
            } else if (operation.lastIndexOf("create task") == 0 &&  info.length >= 5) {
                for (int i = 5; i < info.length; i ++) {
                    info[4] += " " + info[i];
                }
                if(board.createTask(info[2], info[3], info[4])) {
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
            } else if (operation.lastIndexOf("list tasks") == 0 && info.length == 3) {
                System.out.print(board.listTasks(info[2]));
                System.out.println("0");
            } else if (operation.lastIndexOf("delete task") == 0 && board.deleteTask(info[2], info[3]) && info.length == 4) {
                System.out.println("0");
            } else if (operation.lastIndexOf("move task") == 0 && (info.length == 4 || info.length == 5)) {
                Status s;
                if (info.length == 4) {
                    s = Status.toStatus(info[3]);
                } else {
                    s = Status.toStatus(info[3] + " " + info[4]);
                }

                if (board.moveTask(info[2], info[3], s)) {
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
            } else if (operation.lastIndexOf("update task") == 0 && info.length >= 5) {
                for (int i = 5; i < info.length; i ++) {
                    info[4] += " " + info[i];
                }
                if (board.updateTask(info[2], info[3], info[4])){
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
            } else {
                System.out.println("1");
            }

        }


    }
}
