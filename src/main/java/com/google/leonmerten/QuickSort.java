package com.google.leonmerten;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class QuickSort {
    public static void main(String... args) {
        Scanner s = new Scanner(in);
        int bound = 19999999;

        while(true) {
            out.println("Welche List an Integers moechten Sie sortieren? (Format: N,N,N,N)");

            String[] parserArray = s.nextLine().split(",");
            try {
                Sorter<Integer> sorter = new Sorter<>();

                Integer[] workArray = Arrays.stream(parserArray).map(Integer::parseInt).toArray(Integer[]::new);
                long l = currentTimeMillis();
                IntStream.range(0, bound).forEach(i -> sorter.sort(workArray));
                l=currentTimeMillis()-l;

                out.format(
                        "Laufzeit: %sm:%ss:%sms\n",
                        TimeUnit.MILLISECONDS.toMinutes(l)%6,
                        TimeUnit.MILLISECONDS.toSeconds(l)%60,
                        TimeUnit.MILLISECONDS.toMillis(l)%1000);
                out.println("Sortiertes Array: ");
                Arrays.stream(workArray).map(i -> "| " + i + " ").forEach(out::print);
                out.println("|");
            } catch (NumberFormatException e) {
                out.println("Es scheint, als hast du einen unerlaubten Charakter eingegeben," +
                        " Bitte versuche es nochmal! :(");
            } finally {
                out.print("\n");
            }
        }
    }
}