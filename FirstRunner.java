import java.util.concurrent.TimeUnit;

/**
 * Created by bensmith on 7/21/16.
 */
public class FirstRunner {

    public static void main(String[] args) {
        RectangleTest rt = new RectangleTest();
        SwitchCase sw = new SwitchCase();

        try {

            for(int i = 0; i < 30; i++) {

                int[] nums = rt.getNums();
                char[] rep = sw.switcherator(nums);

                for(int jj = 0; jj < rep.length; jj++) {
                    System.out.print(rep[jj] + " ");
                }
                System.out.println();
                TimeUnit.SECONDS.sleep(1);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }






}
