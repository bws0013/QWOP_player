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
 * Created by bensmith on 7/30/16.
 */
public class Colors {

    public static void main(String[] args) throws Exception {
        Robot rob = new Robot();

        Color pixel = rob.getPixelColor(1120, 352);

        //pixel.getRGB() == -256
        System.out.println(pixel.getRGB());
        rob.mouseMove(1120, 352);
    }


}
