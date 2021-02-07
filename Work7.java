public class Work7 {
    public static void main(String[] args) {
        /*7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
         при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.*/
        int[] in1 = {5, 3, 7, 2, 9, 13, 42};
        int[] out1 = moves(in1, -2);
        printOut(out1);

        int[] in2 =  {5, 3, 7, 2, 9, 13, 42, 43, 45, 46};
        int[] out2 = moves(in2, 2);
        printOut(out2);

        int[] in3 = {78, 54, 5, 12, 13, 42, 143};
        int[] out3 = moves(in3, 5);
        printOut(out3);

        int[] in4 =  {5, 3, 7, 2, 9, 42, 43, 45, 46};
        int[] out4 = moves(in4, 0);
        printOut(out4);

        int[] in5 =  {5, 3, 7, 2, 9, 42, 43, 45, 46};
        int[] out5 = moves(in4, 3);
        printOut(out5);
    }

    /**
     * Main method, shifts array
     * @param incoming - user array
     * @param delta - shift value
     * @return int[] result array
     */
    static int[] moves(int[] incoming, int delta){
        int currentIndex, movedIndex, buffer;
        for (int i = 0; i < greatestCommonDivisor(delta, incoming.length); i++) {
            buffer = incoming[i];

            currentIndex = i;

            if(delta > 0){
                while (true) {
                    movedIndex = currentIndex + delta;
                    if (movedIndex >= incoming.length)
                        movedIndex = movedIndex - incoming.length;
                    if (movedIndex == i)
                        break;
                    incoming[currentIndex] = incoming[movedIndex];
                    currentIndex = movedIndex;
                }
            }
            else if(delta < 0){
                while (true) {
                    movedIndex = currentIndex + delta;
                    if (movedIndex < 0)
                        movedIndex = incoming.length + movedIndex;
                    if (movedIndex == i)
                        break;

                    incoming[currentIndex] = incoming[movedIndex];
                    currentIndex = movedIndex;
                }
            }

            incoming[currentIndex] = buffer;
        }

        return incoming;
    }

    /**
     * Simple printout
     * @param incomingArray user array
     */
    public static void printOut(int[] incomingArray){
        for(int item: incomingArray){
            System.out.print(item + " ");
        }

        System.out.println();
    }

    /**
     * Finding the GCD in recoursive function
     * @param a - first element
     * @param b - second element
     * @return int GCD
     */
    static int greatestCommonDivisor(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return greatestCommonDivisor(b, a % b);
    }
}