package com.google.leonmerten;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class QuickSort {
    public static void main(String... args) {
        Scanner s = new Scanner(in);

        while(true) {
            out.println("Welche List an Integers moechten Sie sortieren? (Format: N,N,N,N)");

            String[] parserArray = s.nextLine().split(",");
            try {
                Integer[] workArray = Arrays.stream(parserArray).map(Integer::parseInt).toArray(Integer[]::new);
                Sorter<Integer> sorter = new Sorter<>();
                long l = currentTimeMillis();

                IntStream.range(0, 199999999).forEach(i -> sorter.sort(workArray));
                l=currentTimeMillis()-l;

                out.println(l);
                out.println(String.format(
                        "Laufzeit: %sm:%ss:%sms",
                        TimeUnit.MILLISECONDS.toMinutes(l)%6,
                        TimeUnit.MILLISECONDS.toSeconds(l)%60,
                        TimeUnit.MILLISECONDS.toMillis(l)%1000));
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