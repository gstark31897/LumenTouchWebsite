/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructures;

/**
 *
 * @author gavinstark
 */
public class User {
    public String first_name;
    public String last_name;
    public String organization;
    public String phone_number;
    public String email_address;
    public int course_enrolled;
    
    public User(String first_name, String last_name, String organization, String phone_number, String email_address, int course_enrolled) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.organization = organization;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.course_enrolled = course_enrolled;
    }
}
