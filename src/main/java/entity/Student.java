package entity;

import java.io.Serializable;

/**
 * class student
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1;

    /**
     * id of student
     */
    private int id;

    /**
     * fio of student
     */
    private String fio;

    /**
     * constructor of student
     *
     * @param id id of student
     * @param fio fio of student
     */
    public Student(int id, String fio) {
        setId(id);
        setFio(fio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return String.format("Student: id - %d, fio - %s", id, fio);
    }

}
