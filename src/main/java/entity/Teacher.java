package entity;

import java.io.Serializable;

/**
 * class teacher
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1;

    /**
     * id of teacher
     */
    private int id;

    /**
     * fio of teacher
     */
    private String fio;

    /**
     * constructor of teacher
     *
     * @param id id of teacher
     * @param fio fio of teacher
     */
    public Teacher(int id, String fio) {
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
        return String.format("Teacher: id - %d, fio - %s", id, fio);
    }

}
