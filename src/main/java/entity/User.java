package entity;

import java.io.Serializable;

/**
 * class user
 *
 * @author Polina Astashko
 * @version 1.0.0
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1;

    /**
     * name of user
     */
    private String username;

    /**
     * password of user
     */
    private String password;

    /**
     * Role of user
     */
    Role role;

    private int refid;

    public User() {

    }

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        setRole(role);
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public enum Role {
        TEACHER,
        STUDENT;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getRefid() {
        return refid;
    }

    public void setRefid(int refid) {
        this.refid = refid;
    }

    public void setRole(int role) {
        if (role == 1) {
            this.role = Role.STUDENT;
        } else {
            this.role = Role.TEACHER;
        }
    }

}
