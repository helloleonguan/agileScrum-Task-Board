import java.util.Scanner;

/**
 * Created by Administrator on 2015/12/3/0003.
 */
public class Reader {

    public static void main(String[] args) {
        boolean terminate = false;
        Scanner in = new Scanner(System.in);

        while(!terminate) {
            String operation = in.next();
            if (operation.equals("quit")) {
                terminate = true;
            }
//            else if (true) {
//               //Operation A
//            } else if (true){
//                //Operation B
//            } else {
//                // system out error msg.
//            }
        }


    }
}
