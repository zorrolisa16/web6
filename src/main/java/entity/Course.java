package entity;

import java.io.Serializable;

/**
 * class course
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 1;

    /**
     * id of course
     */
    private int id;

    /**
     * title of course
     */
    private String title;

    /**
     * date of course's begin
     */
    private String datebegin;

    /**
     * id of course's teacher
     */
    private int idteacher;

    /**
     * constructor of course
     *
     * @param id id of course
     * @param title title of course
     * @param datebegin date of course's begin
     * @param idteacher id of course's teacher
     */
    public Course(int id, String title, String datebegin, int idteacher) {
        setId(id);
        setTitle(title);
        setDatebegin(datebegin);
        setIdteacher(idteacher);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatebegin() {
        return datebegin;
    }

    public void setDatebegin(String datebegin) {
        this.datebegin = datebegin;
    }

    public int getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(int idteacher) {
        this.idteacher = idteacher;
    }

    @Override
    public String toString() {
        return String.format("Course: id - %d, title - %s, begin date - %s, id of teacher - %d", id, title, datebegin,
                idteacher);
    }

}
