/**
 * Created by bensmith on 7/18/16.
 *
 * The below is effectively just a class devoted to a switch case.
 */
public class SwitchCase {

    public static void main(String[] args) {

        RectangleTest rec = new RectangleTest();


        int[] ta = rec.getNums();

        char[] ret = switcherator(ta);

        for(int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println(getNumOnly(ret));
    }

    // Returns a double of the distance traveled
    public static double getNumOnly(char arr[]) {
        double ret = 0;
        String fakeNum = "";

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'm') {
                break;
            } else {
                fakeNum += arr[i];
            }
        }
        ret = Double.parseDouble(fakeNum);

        return ret;
    }

    // The number of "white" values of each number are passed in.
    // An interpetation of what character corresponds to each value is returned.
    public static char[] switcherator(int arr[]) {
        char[] ret = new char[arr.length];

        for(int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 167:
                case 172:
                    ret[i] = '0';
                    break;
                case 92:
                case 108:
                case 112:
                    ret[i] = '1';
                    break;
                case 131:
                case 132:
                    ret[i] = '2';
                    break;
                case 129:
                case 133:
                    ret[i] = '3';
                    break;
                case 147:
                case 148:
                    ret[i] = '4';
                    break;
                case 140:
                    ret[i] = '5';
                    break;
                case 153:
                case 154:
                    ret[i] = '6';
                    break;
                case 103:
                case 106:
                    ret[i] = '7';
                    break;
                case 176:
                case 178:
                    ret[i] = '8';
                    break;
                case 158:
                case 159:
                    ret[i] = '9';
                    break;
                case 24:
                    ret[i] = '-';
                    break;
                case 15:
                case 18:
                    ret[i] = '.';
                    break;
                case 191:
                case 202:
                    ret[i] = 'm';
                    break;
                default:
                    ret[i] = '#';
                    break;
            }
        }

        return ret;
    }


}
