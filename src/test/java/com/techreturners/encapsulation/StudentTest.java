package com.techreturners.encapsulation;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class StudentTest {

    @Test
    public void testStudentInst() {

        Student student = new Student("Stud", 'A', Group.TWO.value);

        assertEquals("Stud", student.getName());
        assertEquals('A', student.getGrade());
        assertEquals(Group.TWO.value, student.getGroup());
    }

    @Test
    public void testUpgrade() {

        Student student = new Student("Student1", 'C', Group.FIVE.value);

        student.upgrade();
        assertEquals('B', student.getGrade());
        student.upgrade();
        assertEquals('A', student.getGrade());
        student.upgrade();
        assertEquals('A', student.getGrade());
    }

    @Test
    public void testDowngrade() {

        Student student = new Student("Student2", 'A', Group.TWO.value);

        student.downgrade();
        assertEquals('B', student.getGrade());

        student.downgrade();
        assertEquals('C', student.getGrade());

        student.downgrade();
        assertEquals('D', student.getGrade());

        student.downgrade();
        assertEquals('E', student.getGrade());

        student.downgrade();
        assertEquals('F', student.getGrade());

        student.downgrade();
        assertEquals('F', student.getGrade());


    }

    @Test(expected = IllegalArgumentException.class)
    public void testGradeException() {

        Student student = new Student("GradeErr", 'X', Group.TWO.value);


        assertEquals("GradeErr", student.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGroupException() {

        Student student = new Student("GroupErr", 'A', 9);


        assertEquals("GroupErr", student.getName());
    }

}




