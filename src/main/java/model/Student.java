package model;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @SerializedName("studentName")
    @XmlElement(name = "studentName")
    private String fullName;

    @SerializedName("universityId")
    @XmlElement(name = "universityId")
    private String universityId;

    @SerializedName("course")
    @XmlTransient
    private int currentCourseNumber;

    @SerializedName("avgScore")
    @XmlElement(name = "avgScore")
    private float avgExamScore;

    public Student() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "\nСтудент" +
                "\nФИО='" + fullName + '\'' +
                ", \nКод университета='" + universityId + '\'' +
                ", \nКурс=" + currentCourseNumber +
                ", \nСредний балл за экзамены=" + avgExamScore;
    }
}
