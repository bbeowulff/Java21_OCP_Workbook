package Ch45_ex4;

import java.util.Arrays;

public class PassByValueDemo
{

    public static void modify(String name)
    {
        name = "ChangedName";
        System.out.println("  name = " + name);
    }

    public static void modifyArray(int[] arr)
    {
        arr[0] = 999;
        System.out.println("  arr[0] = " + arr[0]);
    }

    public static void main(String[] args)
    {
        String studentName = "Alice";
        System.out.println("Before modify(String): " + studentName);
        modify(studentName);
        System.out.println("After modify(String): " + studentName);

        System.out.println();

        int[] numbers = {1, 2, 3};
        System.out.println("Before modifyArray: " + Arrays.toString(numbers));
        modifyArray(numbers);
        System.out.println("After modifyArray: " + Arrays.toString(numbers));
    }
}
