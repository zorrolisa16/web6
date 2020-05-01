package entity;

import java.io.Serializable;

/**
 * class registration
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class Registration  implements Serializable {

    private static final long serialVersionUID = 1;

    /**
     * id of registration
     */
    private int id;

    /**
     * id of student
     */
    private int idstudent;

    /**
     * id of course
     */
    private int idcourse;

    /**
     * constructor of registration
     *
     * @param id id of registration
     * @param idstudent id of student
     * @param idcourse id of course
     */
    public Registration(int id, int idstudent, int idcourse) {
        setId(id);
        setIdstudent(idstudent);
        setIdcourse(idcourse);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return String.format("Registration: id - %d, id of student - %d, id of course - %d", id, idstudent, idcourse);
    }

}
