import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.math.*;

/**
 * Created by bensmith on 7/29/16.
 *
 * This will contain the timing capability and the ability to load moves into the bot
 */
public class Player {

    // The time and moves can optionally be set prior to starting the bot
    public static int time = 30;
    public static LinkedList<Integer> moves = new LinkedList<Integer>();

    public static void main(String[] args) {
        try {



            Robot rob = new Robot();
            Random rand = new Random();
            RectangleTest rt = new RectangleTest();

            rob.delay(10000);
            int num = 0;
            while (timer()) {

                Color pixel = rob.getPixelColor(1120, 352);
                if(pixel.getRGB() == -256) {
                    rob.keyPress(KeyEvent.VK_R);
                    rob.delay(50);
                    rob.keyRelease(KeyEvent.VK_R);
                    rob.delay(50);
                    releaseMoves();
                    action();
                }

                num = rand.nextInt(4);

                if(num == 0) {
                    rob.keyPress(KeyEvent.VK_Q);
                    rob.delay(26);
                    rob.keyRelease(KeyEvent.VK_Q);
                    moves.add(0);
                } else if(num == 1) {
                    rob.keyPress(KeyEvent.VK_W);
                    rob.delay(26);
                    rob.keyRelease(KeyEvent.VK_W);
                    moves.add(1);
                } else if(num == 2) {
                    rob.keyPress(KeyEvent.VK_O);
                    rob.delay(26);
                    rob.keyRelease(KeyEvent.VK_O);
                    moves.add(2);
                } else {
                    rob.keyPress(KeyEvent.VK_P);
                    rob.delay(26);
                    rob.keyRelease(KeyEvent.VK_P);
                    moves.add(3);
                }
            }

            printMoves();

        } catch(AWTException awt) {
            System.out.println("Problem with player");
        }
    }

    // Release up to the last 3 moves.
    public static void releaseMoves() {

        for(int i = 0; i < moves.size(); i++) {
            if(i == 6) {
                break;
            }
            moves.pollLast();
        }
    }

    public static void action() {

        try {
            Robot temp = new Robot();

            int num = 0;
            for(int i = moves.size() - 1; i >= 0; i--) {
                num = moves.get(i);

                if(num == 0) {
                    temp.keyPress(KeyEvent.VK_Q);
                    temp.delay(26);
                    temp.keyRelease(KeyEvent.VK_Q);
                } else if(num == 1) {
                    temp.keyPress(KeyEvent.VK_W);
                    temp.delay(26);
                    temp.keyRelease(KeyEvent.VK_W);
                } else if(num == 2) {
                    temp.keyPress(KeyEvent.VK_O);
                    temp.delay(26);
                    temp.keyRelease(KeyEvent.VK_O);
                } else {
                    temp.keyPress(KeyEvent.VK_P);
                    temp.delay(26);
                    temp.keyRelease(KeyEvent.VK_P);
                }
            }
            temp.delay(26);

        } catch(AWTException awt) {
            System.out.println("Problem with player");
        }
    }


    // Until I multithread the timer this is going to be the timer.
    public static boolean timer() {
        if(getTime() > 0) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException IE) {
                System.out.println("Timer Problem (Player");
                System.exit(0);
            }
            setTime(getTime() - 1);
            return true;
        }
        else {
            return false;
        }
    }

    // Used to retrieve global value
    public static int getTime() {
        return time;
    }

    public static void setTime(int num) {
        time = num;
    }

    // Used to give sequence of moves performed.
    public static void printMoves() {
        System.out.print(moves.size());
        for(int i = 0;  i < moves.size(); i++) {
            System.out.print(" " + moves.pollFirst());
        }
    }

    // Used to enter in a sequence of moves performed.
    public static void loadMoves() {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for(int i = 0; i < length; i++) {
            moves.add(sc.nextInt());
        }
    }


}
