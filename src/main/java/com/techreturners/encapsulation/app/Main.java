package com.techreturners.encapsulation.app;

import com.techreturners.encapsulation.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) {
        System.out.println("Please select the app you want to launch:");
        System.out.println("1 - Student Math Grade");


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            if (input.equals("1")) {
                System.out.println("Please enter Student name :");
                String studentName = br.readLine();
                System.out.println("Please enter Student grade (A-F):");
                char studentGrade = br.readLine().trim().toUpperCase().charAt(0);
                System.out.println("Please enter Student group (1-5) :");
                int studentGroup = Integer.parseInt(br.readLine().trim());
                Student testClassDescription = new Student(studentName, studentGrade, studentGroup);
                testClassDescription.launchDescription(testClassDescription);
            }  else {
                System.out.println("Sorry, this app is not available yet");
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
