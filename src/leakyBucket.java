//Leaky Bucket Algorithm for Congestion Control

/*In the network layer, before the network can make Quality of service guarantees, it must know what traffic is being guaranteed.
 One of the main causes of congestion is that traffic is often bursty.
To understand this concept first we have to know little about traffic shaping.
Traffic Shaping is a mechanism to control the amount and the rate of the traffic sent to the network.
Approach of congestion management is called Traffic shaping.
Traffic shaping helps to regulate rate of data transmission and reduces congestion.
There are 2 types of traffic shaping algorithms:


 1. Leaky Bucket
 2.Token Bucket

Suppose we have a bucket in which we are pouring water in a random order but we have to get water in a fixed rate,
for this we will make a hole at the bottom of the bucket. It will ensure that water coming out is in a some fixed rate,
and also if bucket will full we will stop pouring in it.
The input rate can vary, but the output rate remains constant.
Similarly, in networking, a technique called leaky bucket can smooth out bursty traffic.
Bursty chunks are stored in the bucket and sent out at an average rate.

 */


import java.util.Random;
import java.util.Scanner;


public class leakyBucket {

    public static void main (String args[])
    {
        int drop = 0,mini,nsec,p_remaining = 0;
        int o_rate,b_size,i,packet[];

        packet = new int[100];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the bucket size : \n");
        b_size = sc.nextInt();
        System.out.println("Enter the o/p rate : \n");
        o_rate = sc.nextInt();

        System.out.println("Enter the number of seconds you want to simulate : \n");
        nsec = sc.nextInt();
        Random rand = new Random();

        for( i = 0;i<nsec ; i++)
        {
            packet[i] = ((rand.nextInt(9)+1)*10);

        }

        System.out.println("Seconds | Packets Received | Packets Sent | Packets Left | Packet Left");
        System.out.println("______________________________________________________________________");

        for(i = 0;i<nsec;i++)  
        {
            p_remaining += packet[i];

            if(p_remaining>b_size)
            {
                drop = p_remaining - b_size;
                p_remaining = b_size;

                System.out.print(i+1+"              ");
                System.out.println(packet[i]+"                       ");

                mini = Math.min(p_remaining,o_rate);
                System.out.print(+mini+"                    ");
                p_remaining = p_remaining - mini;
                System.out.print(p_remaining+"                  ");
                System.out.print(drop+"               ");
                drop = 0;
                

            }

        }
        
        while(p_remaining!=0)
        {
            if(p_remaining>b_size)
            {
                drop = p_remaining-b_size;
                p_remaining = b_size;
                
            }
            mini = Math.min(p_remaining,o_rate);
            System.out.print("      "+p_remaining+"      "+mini);
            p_remaining = p_remaining - mini;
            
            System.out.print(p_remaining+"      "+drop);
            drop = 0;
        }
    }
}
