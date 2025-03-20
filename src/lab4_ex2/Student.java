package lab4_ex2;
import java.util.*;
public class Student {
    private String nume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String grupa) {
        this.nume = nume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
    }

    public String getNume() {
        return nume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void adaugaNota(int nota) {
        note.add(nota);
    }

    public boolean esteIntegralist() {
        return note.stream().allMatch(n -> n >= 5);
    }

    public float getMedie() {
        return (float) note.stream().mapToInt(Integer::intValue).sum() / note.size();
    }

    public long getNumarRestante() {
        return note.stream().filter(n -> n < 5).count();
    }

    @Override
    public String toString() {
        return nume + " (" + grupa + "): " + note + " - Medie: " + getMedie();
    }
}

class ByGroupComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGrupa().compareTo(o2.getGrupa());
    }
}

class ByGradesComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getMedie(), o1.getMedie());
    }
}

class ByRestanteComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Long.compare(o1.getNumarRestante(), o2.getNumarRestante()); // Crescător
    }

}
