package model;

import enums.student.StudyProfile;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;

    @XmlElement(name = "avgScore")
    private float avgExamScore;

    @XmlTransient
    private int numberOfStudentsByStudyProfile;

    @XmlTransient
    private String universityNames;

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
        return numberOfStudentsByStudyProfile;
    }

    public void setNumberOfUniversitiesByStudyProfile(int numberOfUniversitiesByStudyProfile) {
        this.numberOfStudentsByStudyProfile = numberOfUniversitiesByStudyProfile;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
    }
}
