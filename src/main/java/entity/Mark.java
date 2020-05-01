package entity;

import java.io.Serializable;

/**
 * class mark
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class Mark implements Serializable {

    private static final long serialVersionUID = 1;

    /**
     * id of mark
     */
    private int id;

    /**
     * value of mark
     */
    private int value;

    /**
     * id of student
     */
    private int idstudent;

    /**
     * id of course
     */
    private int idcourse;

    /**
     * constructor of mark
     *
     * @param id id of mark
     * @param value value of mark
     * @param idstudent id of student
     * @param idcourse id of course
     */
    public Mark(int id, int value, int idstudent, int idcourse) {
        setId(id);
        setValue(value);
        setIdstudent(idstudent);
        setIdcourse(idcourse);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public int getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(int idcourse) {
        this.idcourse = idcourse;
    }

    @Override
    public String toString() {
        return String.format("Mark: id - %d, value - %d, id of student - %d, id of course - %d", id, value, idstudent,
                idcourse);
    }

}
