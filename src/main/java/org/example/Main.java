package org.example;

public class Main {
    public static void main(String[] args) {
        University university;
        university = new University("0", "Филиал федерального государственного бюджетного образовательного учреждения высшего образования " +
                "Кузбасский государственный технический университет имени Т. Ф. Горбачева в г. Прокопьевске", "КузГТУ", 1997, StudyProfile.PROGRAMMING);
        System.out.println(university.toString());

        Student student;
        student = new Student("Попов Дмитрий Алексадрович", "0", 4, 4.83f);
        System.out.println(student.toString());
    }
}