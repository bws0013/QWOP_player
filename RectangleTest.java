import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by bensmith on 7/12/16.
 *
 * This takes an image of a piece of the screen and examines it for "white"
 * values. A white value is defined as a pixel in which the robot class getRGB
 * method returns a value of -1 for its numerical color representation.
 *
 * Note: the images examined must be placed in a specific location for
 * them to be read. Run the Distance_Reader.java to see exactly where
 * on the screen the reading will take place. It will take control of
 * your mouse and run it over exactly what is read. Slight adjustments
 * may need to be made.
 */

public class RectangleTest {

    public static void main(String[] args) {
        int[] print = getNums();

        for(int i = 0; i < print.length; i++) {
            System.out.print(print[i] + " ");
        }

    }

    public static int[] getNums() {
        int x = 860;
        int y = 98;

        int[] ret = new int[4];

        Rectangle rec = new Rectangle(x, y, 162, 31);
        BufferedImage bi = null;

        try {
            Robot rob = new Robot();

            bi = rob.createScreenCapture(rec);


        } catch (java.awt.AWTException awt) {
            System.out.println("DangerZone");
        }

        //System.out.println(bi.getWidth() + " " + bi.getHeight());

        int maxNums = 0;
        int totalWhite = 0;

        boolean broken = false;

        for(int i = 0; i < 162; i++) {

            boolean lineCount = false;

            for(int j = 0; j < 31; j++) {
                int rVal = ((bi.getRGB(i, j)));
                //System.out.print(((rVal % 256)) + " ");
                if(rVal == -1) {
                    //System.out.print(1 + " ");
                    totalWhite++;
                    lineCount = true;
                } else {
                    //System.out.print(0 + " ");
                }
            }

            if(lineCount == true) {
                broken = true;
            }
            if(broken == true && lineCount == false) {
                broken = false;
                //System.out.print(totalWhite + " ");
                ret[maxNums] = totalWhite;
                totalWhite = 0;
                maxNums++;
                if(maxNums == 4) {
                    break;
                }
            }
            //System.out.println();
        }

        return ret;
    }



}
