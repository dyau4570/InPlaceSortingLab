import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class InPlaceSorts
{
    public int challengeFour(int[][] challenge4)
    {
        double median;
        int[]rowMediums = new int[challenge4.length];
        for(int i=0;i<challenge4.length;i++)
        {
            quicksort(challenge4[i],0,challenge4.length-1);
            rowMediums[i] = (challenge4[i][(challenge4.length/2)-1] + challenge4[i][challenge4.length/2])/2;
        }
        quicksort2(rowMediums,challenge4,0,rowMediums.length-1);
        median = (rowMediums[(rowMediums.length/2)-1] + rowMediums[rowMediums.length/2])/2;
        System.out.println((int)median);
        return (int)median;
    }

    public static void quicksort(int[] arr,int l, int r)
    {
        if(l<r)
        {
            int pivot = partition(arr, l, r);
            quicksort(arr, l,pivot-1);
            quicksort(arr,pivot+1, r);
        }
    }

    public static int partition(int[] arr, int l, int r)
    {
        int pivot = arr[r];
        int i = l-1;
        for(int j=l;j<r;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }

    public static void quicksort2(int[] arr,int[][] arr2,int l, int r)
    {
        if(l<r)
        {
            int pivot = partition2(arr,arr2, l, r);
            quicksort2(arr, arr2,l,pivot-1);
            quicksort2(arr,arr2,pivot+1, r);
        }
    }

    public static int partition2(int[] arr,int[][] arr2,int l, int r)
    {
        int pivot = arr[r];
        int i = l-1;
        for(int j=l;j<r;j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                int[] temp2 = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp2;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        int[] temp2 = arr2[i+1];
        arr2[i+1] = arr2[r];
        arr2[r] = temp2;
        return i+1;
    }

    public static void insertionSort(int[] list1)
    {
        for(int i=0;i<list1.length;i++)
        {
            int cMin = list1[i];
            int x = i - 1;
            while(x>=0 && list1[x] > cMin)
            {
                list1[x+1] = list1[x];
                x--;
            }
            list1[x+1] = cMin;
        }
    }

    public static void selectionSort(double[] list1)
    {
        int pos = 0;
        double cMin = 0;
        for(int i=0;i<list1.length;i++)
        {
            pos = i;
            cMin = list1[i];
            for(int j =0;j<list1.length;j++)
            {
                if (list1[i] < cMin)
                {
                    pos = j;
                    cMin = list1[j];
                }
            }
            list1[pos] = list1[i];
            list1[i] = cMin;
        }
    }

    public static void bubbleSort(String[] list1)
    {
        boolean swapping = true;
        String temp;
        int numSwaps = 0;
        while(swapping)
        {
            for (int i = 0; i < list1.length - 1; i++)
            {
                if (list1[i].compareTo(list1[i + 1]) > 0)
                {
                    temp = list1[i];
                    list1[i] = list1[i + 1];
                    list1[i + 1] = temp;
                    numSwaps++;
                }
            }
            if(numSwaps > 0)
            {
                numSwaps = 0;
            }
            else
            {
                if(numSwaps == 0)
                    swapping = false;
            }
        }
    }

    public int[] genInts(int n)
    {
        int[] list1 = new int[n];
        Random random = new Random();
        for(int i = 0; i < n; i++)
        {
            list1[i] = random.nextInt(10000);
        }
        return list1;
    }
    public int[][] genInts2(int n)
    {
        int[][] challengeFour = new int[n][n];
        Random random = new Random();
        for(int i = 0; i < n; i++)
        {
            for(int j=0;j<n;j++)
            {
                challengeFour[i][j] = random.nextInt(10000);
            }
        }
        return challengeFour;
    }

    public double[] genDoubles(int n)
    {
        double[] list1 = new double[n];
        Random random = new Random();
        DecimalFormat df = new DecimalFormat("#.###");
        for(int i = 0; i < n; i++)
        {
            list1[i] = Double.valueOf(df.format((random.nextDouble() * 10)));
        }
        return list1;
    }

    public String[] genStrings(int n)
    {
        String[] list1 = new String[n];
        Random random = new Random();
        String atoz = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < n; i++)
        {
            byte[] array = new byte[random.nextInt(8) + 3];
            new Random().nextBytes(array);
            String generatedString = genRandom(atoz);
            list1[i] = generatedString;
        }
        return list1;
    }

    public String genRandom(String atoz)
    {
        Random random = new Random();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 7; i ++)
        {
            int rand = random.nextInt(atoz.length());
            res.append(atoz.charAt(rand));
        }
        return res.toString();
    }
}