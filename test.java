public class test 
{
    public static void main(String[] args)
    {
        int[] arr = new int []{4, 6, 8, 2, 3, 1};
        int count = 0;
        int tempX = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }  
        
        for (int i = 0; i < arr.length; i++)
        {
            while (arr[i] != max)
            {
                count++;
            }

            tempX = arr[i - count];
            arr[i - count] = arr[i];
            arr[i] = tempX;
        }

        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }

    }   

}
