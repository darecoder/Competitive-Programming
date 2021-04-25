package com.company.IntroToCollections;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        list.add(10);
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(30);
        list.add(45);

        System.out.print("Enter the element : ");
        int element = s.nextInt();

        //In-built function for binary-search
        int first = list.indexOf(element);
        int last = list.lastIndexOf(element);

        System.out.println("The element " + element + " has it's first appeareance on position "
                + first + " and it's last on position " + last);

        System.out.println("Total occurence of " + element + " is " + (last - first + 1));

    }
}
