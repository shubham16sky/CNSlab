import java.util.Scanner;

public class crc {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int data[],div[],divisor[],rem[],crc[];
        int data_bits,divisor_bits,tot_length;

        System.out.println("Enter the number of data bits:\n");

        data_bits = sc.nextInt();
        data = new int [data_bits];

        System.out.println("Enter the data bits : ");
        for(int i = 0;i<data_bits;i++)
        {
            data[i] = sc.nextInt();
        }

        divisor_bits = 17;
        divisor = new int[]{1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
        tot_length = data_bits + divisor_bits-1;

        div = new int [tot_length];
        rem = new int [tot_length];
        crc = new int [tot_length];

        for(int i = 0;i<data.length;i++)
        {
            div[i] = data[i];
        }

        System.out.println("Dividemd after appending 0's are : ");
        for(int i = 0;i<div.length;i++)
        {
            System.out.print(div[i]);
        }
        System.out.println();

        for(int j = 0;j<div.length;j++)
        {
            rem[j] = div[j];
        }

        rem = divide(divisor,rem);

        for(int i = 0;i<div.length;i++)
        {
            crc[i] = (div[i] ^ rem[i]);
        }

        System.out.println();

        System.out.println("CRC code is : \n");
        for(int i = 0;i<crc.length;i++)
        {
            System.out.println(crc[i]);
        }

        System.out.println();

        System.out.println("Enter the CRC code of "+tot_length+"bits");

        for(int i = 0;i<crc.length;i++)
        {
            crc[i] = sc.nextInt();
        }

        for(int j = 0;j<crc.length;j++)
        {
            rem[j] = crc[j];
        }


        rem = divide(divisor,rem);

        for(int i = 0;i<rem.length;i++)
        {
            if(rem[i] !=0)
            {
                System.out.println("ERROR");
                break;
            }

            if(i==rem.length-1)
            {
                System.out.println("No Error");
            }


        }
        System.out.println("THANK YOU ");


    }

    static int[] divide(int [] divisor,int [] rem)
    {
        int curr = 0;
        while(true)
        {
            for(int i = 0;i<divisor.length;i++)
            {
                rem[curr+1] = (rem[curr+i]^divisor[i]);
            }

            while(rem[curr]==0 && curr!=rem.length-1)
            {
                curr++;
            }

            if((rem.length-curr)<divisor.length)
            {
                break;
            }
        }
        return rem;
    }
}
