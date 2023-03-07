package org.example;

public class University {
    String id, fullname, shortname;
    int yearOfFoundation;
    StudyProfile mainProfile;

    public University(String id, String fullname, String shortname, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullname = fullname;
        this.shortname = shortname;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "\nУниверситет" +
                "\nКод='" + id + '\'' +
                ", \nПолное название='" + fullname + '\'' +
                ", \nСокращенное название='" + shortname + '\'' +
                ", \nГод основания=" + yearOfFoundation +
                ", \nПрофиль=" + mainProfile.getProfileName();
    }
}
