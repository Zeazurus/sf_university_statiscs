package util;

import comparators.student.*;
import comparators.university.*;
import enums.student.*;
import enums.university.*;

public class ComparatorUtil {

    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {

        return switch (studentComparatorType) {
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
            case FULL_NAME -> new StudentFullNameComparator();
            case COURSE -> new StudentCourseComparator();
            case AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
        };
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {

        return switch (universityComparatorType) {
            case ID -> new UniversityIdComparator();
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case PROFILE -> new UniversityProfileComparator();
            case YEAR -> new UniversityYearComparator();
        };
    }
}
