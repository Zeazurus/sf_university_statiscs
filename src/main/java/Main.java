import comparators.student.*;
import comparators.university.*;
import enums.student.*;
import enums.university.*;
import io.*;
import model.*;
import util.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //Универсистеты
        List<University> universities =
                XlsReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);

        //Проверка JSON
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);

        //Сверка по количеству элементов
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);

            //Проверка отдельного JSON
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);

            //Проверка обратного превращения
            System.out.println(universityFromJson);
        });

        //Студенты
        List<Student> students =
                XlsReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);

        //Проверка JSON
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);

        //Сверка по количеству элементов
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);

            //Проверка отдельного JSON
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);

            //Проверка обратного превращения
            System.out.println(studentFromJson);
        });

        //Запись в корень
        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");
    }
}