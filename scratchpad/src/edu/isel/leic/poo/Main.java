package edu.isel.leic.poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Grade> approved(ArrayList<Grade> grades) {
        return above(grades, new Grade(9));
    }

    private static ArrayList<Grade> below(ArrayList<Grade> grades, Grade reference) {
        ArrayList<Grade> above = new ArrayList<>();
        for (Grade grade : grades) {
            if(grade.value < reference.value)
                above.add(grade);
        }
        return above;
    }

    private static ArrayList<Grade> above(ArrayList<Grade> grades, Grade reference) {
        final ArrayList<Grade> above = new ArrayList<>();
        for (Grade grade : grades) {
            if(grade.value > reference.value)
                above.add(grade);
        }
        return above;
    }

    private static Grade average(ArrayList<Grade> grades) {
        int total = 0;
        for (Grade grade : grades) {
            total += grade.value;
        }
        return new Grade(total / grades.size());
    }

    public static void main(String[] args) {
        final Scanner kbd = new Scanner(System.in);
        final ArrayList<Grade> grades = new ArrayList<>();
        int gradeValue;
        while ((gradeValue = kbd.nextInt()) >= 0) {
            final Grade grade = new Grade(gradeValue);
            grades.add(grade);
        }

        final ArrayList<Grade> approved = approved(grades);
        printGrades(approved);
        final Grade average = average(grades);
        System.out.println("Average = " + average.value);
        final ArrayList<Grade> aboveAverage = above(grades, average);
        printGrades(aboveAverage);
    }

    private static void printGrades(ArrayList<Grade> grades) {
        for (Grade grade : grades) {
            System.out.println(grade.value);
        }
    }
}
