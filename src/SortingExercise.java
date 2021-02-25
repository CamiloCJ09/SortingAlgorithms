import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SortingExercise {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        int i = 0;
        String[] entries;
        //Register the entries
        int size = sc.nextInt();
        entries = new String[size];
        sc.nextLine();
        for(int j = 0; j < entries.length; j++){
            entries[j] = sc.nextLine();
        }
        //Apply the algorithm for each line in the entries
        while(i < size){
            String[] numsArray = entries[i].split(" ");
            bw.write(sortNums(numsToDouble(numsArray))+"\n");
            i++;
        }
        bw.close();
    }
    //Transform String array to double array
    public static double[] numsToDouble(String[] stringNums){
        double[] nums = new double[stringNums.length];
        for(int i = 0; i < stringNums.length; i++){
            nums[i] = Double.parseDouble(stringNums[i]);
        }
        return nums;
    }
    //Algorithm who sort the numbers, do the average and return a String with the format
    public static String sortNums(double[] nums){
        double[] numsArray = Arrays.copyOf(nums, nums.length);
        int n = numsArray.length;
        int count = 0;
        double temp;
        boolean changed = true;
        for(int i=0; i < n && changed; i++){
            changed = false;
            for(int j=1; j < (n-i); j++){
                if(numsArray[j-1] > numsArray[j]){
                    //swap elements
                    changed = true;
                    temp = numsArray[j-1];
                    numsArray[j-1] = numsArray[j];
                    numsArray[j] = temp;
                    count++;
                }

            }
        }
        float value = (float) count/(n-1);
        StringBuilder ret = new StringBuilder();
        //Add spaces between each number
        for (int i = 0; i < numsArray.length-1; i++) {
            ret.append(numsArray[i]).append(" ");
        }
        ret.append(numsArray[numsArray.length-1]);

        return value+"-"+ret;
    }

}
