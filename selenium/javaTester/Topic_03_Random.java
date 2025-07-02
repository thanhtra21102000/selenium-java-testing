package javaTester;

import java.util.Random;

public class Topic_03_Random {
    public static void main(String[] args){
        Random rand = new Random();
        System.out.println("thanhtra" + rand.nextBoolean() + "@gmail.com");
        System.out.println("thanhtra" + rand.nextDouble() + "@gmail.com");
        System.out.println("thanhtra" + rand.nextFloat() + "@gmail.com");
        System.out.println("thanhtra" + rand.nextInt() + "@gmail.com");
        System.out.println("thanhtra" + rand.nextLong() + "@gmail.com");
        System.out.println("thanhtra" + rand.nextInt(99999) + "@gmail.com");
        System.out.println(rand.nextBoolean());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextLong());
        System.out.println(rand.nextInt(99999));
    }
}
