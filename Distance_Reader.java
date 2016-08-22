/**
 * Created by bensmith on 7/6/16.
 *
 * This was my initial attempt at examining the color value of every pixel
 * in a given rectangle. It is too slow to be viable so I switched from
 * getting each RGB value separately and adding them to just using the
 * Robot class built in method.
 *
 * This should be considered obsolete.
 */
import java.awt.*;

public class Distance_Reader {

    public static void main(String[] args) {

        //System.out.println("Hello world");

        /*
        try {
            Thread.sleep(5000);
        } catch (java.lang.InterruptedException IE) {
            System.out.println("Sleep fail");
        }
        */


        int x1, x2, y1, y2;
        x1 = 860;
        x2 = 1022;

        y1 = 243;
        y2 = 274;
        // y1 = 693;
        // y2 = 722;

        //int[][] toPrint = getImg(x1, x2, y1, y2);

        //printMatrix(x1, x2, y1, y2, toPrint);
        moveMouse(x1, x2, y1, y2);


    }

    /*
        Given 2 corners of an image, return a 2d array of the colors as
        represented by ints determined by the robot class
    */
    public static int[][] getImg(int x1, int x2, int y1, int y2) {
        int[][] ret = new int[x2 - x1 + 1][y2 - y1 + 1];

            int incX = 0;
            int incY = 0;

        try {
            Robot r = new Robot();

            incX = 0;
            incY = 0;

            for (int i = x1; i <= x2; i++) {

                incY = 0;
                for (int j = y1; j <= y2; j++) {
                    Color pixel = r.getPixelColor(i, j);
                    int pixelColor =
                            pixel.getRed() + pixel.getBlue() + pixel.getGreen();
                    ret[incX][incY] = pixelColor;
                    incY++;
                }
                incX++;
            }
        } catch (java.awt.AWTException ex) {
            System.out.println("Robot Error 0");
        } catch (java.lang.ArrayIndexOutOfBoundsException abe) {
            System.out.println("Error x and y " + incX + " " + incY);
        }

        return ret;
    }

    // Print the values of the rectangle you took the values of
    public static void printMatrix(int x1, int x2, int y1, int y2, int[][] arr) {

        for (int i = 0; i <= x2 - x1; i++) {
        for (int j = 0; j <= y2 - y1; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    // See the area where you are going to be getting the colors from
    public static void moveMouse(int x1, int x2, int y1, int y2) {

        try {
            Robot r = new Robot();

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    r.mouseMove(i, j);
                    r.delay(2);
                }
            }

        } catch (java.awt.AWTException ex) {
            System.out.println("Robot Error 0");
        }

    }



}


