package javaconfiguration.setter.beans;

import java.util.List;

public class Subject {
    private List<String> subjects;
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
    public List<String> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return subjects.toString();
    }
}
