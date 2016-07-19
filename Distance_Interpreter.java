/**
 * Created by bensmith on 7/7/16.
 *
 *
 * This uses the slow method of getting the values of the pixels in a given
 * area.
 *
 * This should be considered obsolete.
 */
public class Distance_Interpreter {

    public static void main(String[] args) {

        Distance_Reader d = new Distance_Reader();

        int x1, x2, y1, y2;
        x1 = 860;
        x2 = 1022;

        y1 = 103;
        y2 = 129;

        int xLength = x2 - x1;
        int yLength = y2 - y1;

        int[][] toPrint = d.getImg(x1, x2, y1, y2);
        // d.printMatrix(x1, x2, y1, y2, toPrint);

        int[] r = countWhite(xLength, yLength, toPrint);

        for(int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }

    }

    public static int[] countWhite(int x, int y, int[][] arr) {
        int[] ret = new int[3];

        int maxNums = 0;
        int totalWhite = 0;

        boolean broken = false;
        for (int i = 0; i <= x; i++) {

            boolean lineCount = false;

            for (int j = 0; j <= y; j++) {

                if(arr[i][j] == 765) {
                    totalWhite++;
                    lineCount = true;
                }

            }
            //System.out.println("Total = " + totalWhite);

            if(lineCount == true) {
                broken = true;
            }
            if(broken == true && lineCount == false) {
                broken = false;
                ret[maxNums] = totalWhite;
                totalWhite = 0;
                maxNums++;
                if(maxNums == 3) {
                    break;
                }

            }
        }

        return ret;
    }





}
