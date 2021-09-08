package vadim_nedrega.HW3_ExceptionsExlamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ExceptionsExamples extends Exception{

    // Checked with throw without processing
    FileInputStream fileInputStream = null;
    public void method() throws FileNotFoundException {
        fileInputStream = new FileInputStream("");
    }
    //_________________________________________________________

    // try, catch, finally for checked
    public void method1() {
        try {
            fileInputStream = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //_______________________________________________

    // try, catch, finally for unchecked
    public void method2(){
        int [] arr = new int[3];
        try {
            arr[5] = 15;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    //_____________________________________________

    //return in finally
    public static ArrayList<Integer> method3(){
        int [] array = new int [] {1,5,9,4,7};
        int a=15;
        try {
            array[6] = a;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Don't worry. Int 'a' will be added to the dynamic massive by finally block");
            ;
        } finally {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j : array) {
                list.add(j);
            }
            list.add(a);
            System.out.println(list);
            return list;
        }
    }
}
