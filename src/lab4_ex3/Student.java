package lab4_ex3;
import java.io.*;
import java.util.*;


public class Student {
    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String prenume, String grupa, List<Integer> note) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nume, student.nume) &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(grupa, student.grupa) &&
                Objects.equals(note, student.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, grupa, note);
    }

    @Override
    public String toString() {
        return nume + " " + prenume + " " + grupa + " " + note;
    }
}
