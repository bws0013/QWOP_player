import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by bensmith on 7/15/16.
 *
 * This class is my attempt at performing binary image analysis.
 * I want to put numbers into a 50x50 array (because I know they will fit),
 * then determine what unique points each number contains.
 *
 * This is turning out to be a bit more complicated then I thought as certain
 * numbers have very different numbers of points.
 *
 * TODO: Find a algorithm that has already been made.
 */
public class PrintBinaryRepresentation {

    public static void main(String[] args) {
        int[][] image = getImage();
        printImage(image);
    }

    public static void printImage(int[][] image) {
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                System.out.print(image[i][j]);
            }
            System.out.println();
        }


    }

    public static int[][] getImage() {
        int[][] img = new int[50][50];

        int x = 860;
        int y = 98;

        Rectangle rec = new Rectangle(x, y, 162, 31);
        BufferedImage bi = null;

        try {
            Robot rob = new Robot();

            bi = rob.createScreenCapture(rec);


        } catch (java.awt.AWTException awt) {
            System.out.println("DangerZone");
        }

        int maxNums = 0;


        boolean broken = false;

        for(int i = 0; i < 162; i++) {

            boolean lineCount = false;

            int currentRow = 0;

            for(int j = 0; j < 31; j++) {
                int rVal = ((bi.getRGB(i, j)));
                if(rVal == -1) {
                    lineCount = true;
                    img[j][currentRow] = 1;
                }

            }
            currentRow++;

            if(lineCount == true) {
                broken = true;
            }
            if(broken == true && lineCount == false) {
                broken = false;
                maxNums++;
                if(maxNums == 1) {
                    break;
                }
            }

        }

        return img;

    }
}
