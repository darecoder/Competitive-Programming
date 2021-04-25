package com.company.IntroToCollections;

public class BdayParadox {
    public static void main(String[] args) {
        float p = 1;

        float num = 365;
        float denom = 365;
        int people = 0;

        while(p>0.5){
            p *= (num/denom);
            num--;
            people++;
        }

        System.out.println(people);

    }
}
