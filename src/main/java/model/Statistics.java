package model;

import enums.student.StudyProfile;

public class Statistics {
    StudyProfile studyProfile;
    float avgExamScore;
    int numberOfStudentsByStudyProfile, numberOfUniversitiesByStudyProfile;
    String universityNames;

    public Statistics() {
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getNumberOfStudentsByStudyProfile() {
        return numberOfStudentsByStudyProfile;
    }

    public void setNumberOfStudentsByStudyProfile(int numberOfStudentsByStudyProfile) {
        this.numberOfStudentsByStudyProfile = numberOfStudentsByStudyProfile;
    }

    public int getNumberOfUniversitiesByStudyProfile() {
        return numberOfUniversitiesByStudyProfile;
    }

    public void setNumberOfUniversitiesByStudyProfile(int numberOfUniversitiesByStudyProfile) {
        this.numberOfUniversitiesByStudyProfile = numberOfUniversitiesByStudyProfile;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
    }
}
