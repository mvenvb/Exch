/**
 * Created by vik on 07.09.2017.
 */

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите значение купюры: ");
        int banknote = sc.nextInt();
        System.out.println();

        System.out.println("Введите количество номиналов: ");
        int size = sc.nextInt();
        int Values[] = new int[size];

        System.out.println("Введите значения номиналов: ");
        for (int i = 0; i < size; i++) {
            Values[i] = sc.nextInt();
        }
        System.out.println();

        Arrays.sort(Values);

        for ( int i = 0, m = 0; i != size; i++, size = m )
        {
            for ( int j = m = i + 1; j != size; j++ )
            {
                if ( Values[j] != Values[i] )
                {
                    if ( m != j ) Values[m] = Values[j];
                    m++;
                }
            }
        }

        if ( size != Values.length )
        {
            int[] NewValues = new int[size];
            for ( int i = 0; i < size; i++ ) NewValues[i] = Values[i];

            Values = NewValues;
        }
        System.out.println("Отсортированные номиналы:");
        for ( int v : Values ) System.out.print( v + " " );
        System.out.println();
        System.out.println();

        size=Values.length+1;
        int NValues[] = new int[size];
        for(int i=0;i<Values.length;i++)
            NValues[i]=Values[i];
        NValues[Values.length]=banknote*100;

        System.out.println("Варианты размена: ");
        Exchange(banknote,0," ", NValues);


    }


    public static void Exchange(int sum, int index, String s, int[] Val) {
        if (sum == 0) System.out.println(s);
        else {
                while (Val[index] <= sum) {
                    Exchange(sum - Val[index], index, s + Val[index] + " ", Val);
                    index++;
                }


        }
    }


}