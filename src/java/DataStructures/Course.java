/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Ncaps12
 */
public class Course {
    public int id;
    public String title;
    public String location;
    public String date;
    public int enrolled;
    public int maximum;
    public String teacher;
    public String description;
    
    public Course(int id, String course_title, String course_location, String course_date, int enrolled, int maximum, String teacher, String course_description) {
        this.id = id;
        this.title = course_title;
        this.location = course_location;
        this.date = course_date;
        this.enrolled = enrolled;
        this.maximum = maximum;
        this.teacher = teacher;
        this.description = course_description;
    }
}
