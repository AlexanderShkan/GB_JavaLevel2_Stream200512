public class Main {

    public static void main(String[] args) {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        private static String[][] StringToArr(String str) throws ArrayIndexOutOfBoundsException {
            String[][] arr = new String[4][4];

            if (str.split("\n").length != 4) {
                throw new ArrayIndexOutOfBoundsException("Sting format is out of bounds. Mast be String [i=4][j=4]. You have i != 4. Your current length is "+str.split("\n").length);
            }

            String[] src = str.split("\n");
            for (int i = 0; i < 4 ; i++) {
                if (src[i].split(" ").length != 4) {
                    throw new ArrayIndexOutOfBoundsException("Sting format is out of bounds. Mast be String [i=4][j=4]. You have j != 4.Your current length is "+src[i].split(" ").length);
                }
                arr[i] = src[i].split(" ");
            }
            return arr;
        }

        public static float CalcStr(String[][] arr) throws NumberFormatException {
            float val=0f;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    val += Integer.parseInt(arr[i][j]);
                }
            }
            return (val)/2;
        }

        public static void main(String[] args) {
            try {
                System.out.println(CalcStr(StringToArr(str)));
            } catch (ArrayIndexOutOfBoundsException e1) {
                e1.printStackTrace();
            } catch (NumberFormatException e2){
                e2.printStackTrace();
            }

        }

    }

