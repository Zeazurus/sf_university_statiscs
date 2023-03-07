package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"), PROGRAMMING("Программирование"), ACCOUNTING("Бухгалтерия");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
