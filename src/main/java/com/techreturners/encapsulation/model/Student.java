package com.techreturners.encapsulation.model;

public class Student {
    private String name;
    private char grade;
    private int group;
    private String mySecretNickName = "MySecretNickName";
    private final String GRADES = "ABCDEF";


    public Student(String name, char grade, int group) {
        if (name.length()==0)
            throw new IllegalArgumentException("Please enter the student's name");
        if (GRADES.indexOf(grade) < 0)
            throw new IllegalArgumentException("Invalid grade");
        if (group < Group.ONE.value || group > Group.FIVE.value)
            throw new IllegalArgumentException("Invalid group");

        this.name = name;
        this.grade = grade;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public char getGrade() {
        return grade;
    }

    public int getGroup() {
        return group;
    }

    public void upgrade() {
       if(GRADES.indexOf(grade)==0)
           System.out.println("Upgrade failed :"+this.name+" Grade is already "+ grade +", the highest possible");
        else if (GRADES.indexOf(grade) >= 1) {
            updateGrade(-1);
        }
    }

    public void downgrade() {
        if(GRADES.indexOf(grade)==GRADES.length()-1)
            System.out.println("Downgrade failed :"+this.name+" Grade is already "+ grade +", the lowest possible");
        if (GRADES.indexOf(grade) < GRADES.length() - 1) {
            updateGrade(1);
        }
    }

    private void updateGrade(int gradeUp) {
       // System.out.println("old grade was:" + this.grade);
        grade = GRADES.charAt(GRADES.indexOf(grade) + gradeUp);
       // System.out.println("new grade is:" + this.grade);
    }

    private boolean checkGrade(char grade) {
        return GRADES.indexOf(grade) == -1;
    }

    private boolean checkGroup(int group) {
        return (group >= Group.ONE.value && group <= Group.FIVE.value);

    }
    public void launchDescription(Student testStudent){
        System.out.println("********** Student Mary example *****************");
        System.out.println("Name:" + testStudent.getName() + " grade: " + testStudent.getGrade()  + " group: " + testStudent.getGroup() );
        System.out.println("********** Mary performed a bad test, her grade "+testStudent.getGrade() +" will be downgraded *******");
        testStudent.downgrade();
        System.out.println("********** Marys grade is now: "+testStudent.getGrade()+ " *******");
        System.out.println("Let's pretend she has been caught selling 8 of her homeworks on ebay, her grade will be lowered of one point for each sale");
        for(int i=8;i>0;i--){
            System.out.println("Marys grade was: "+testStudent.getGrade()+ " *******");
            testStudent.downgrade();
            System.out.println("Marys grade is now: "+testStudent.getGrade()+ " *******");

        }
        System.out.println("But she agreed for 10 community work hours volunteering, she will get an upgrade point for each hour worked");
        for(int i=10;i>0;i--){
            System.out.println("Marys grade was: "+testStudent.getGrade()+ " *******");
            testStudent.upgrade();
            System.out.println("Marys grade is now: "+testStudent.getGrade()+ " *******");

        }
        System.out.println("Mary is now happy and learnt the lesson. No more homework selling on ebay");


        System.out.println("Let's throw some error so we can learn as Mary did :) ");
        System.out.println("trying to create a student profile with an invalid grade and will throw an IllegalArgumentException: X  ");
        try{
            Student jMistake = new Student("Jason Mistake",'X',Group.ONE.value);
        }catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }

        System.out.println("trying to create a student profile with an invalid group and will throw an IllegalArgumentException: 99  ");
        try{
            Student dError = new Student("Daniel Error",'B',99);
        }catch(IllegalArgumentException iaex){
            iaex.printStackTrace();
        }
    }


}