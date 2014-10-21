/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtil;

import DataStructures.Course;
import Servlets.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Ncaps12
 */
public class DBAccess {
    pustatic String host = "jdbc:derby://localhost:1527/LU/";
    static String userName = "lu";
    static String password = "lu";
    
    static Connection dataBase;
    /**
     * @param args the command line arguments
     */
    static {
        try {
            dataBase = DriverManager.getConnection(host, userName, password);
            System.out.println("Connected!");
        } catch (SQLException ex) {
        }
    }
    
    static void addUser(String first_name, String last_name, String organization, String phone_number, String email_address, int course_enrolled) throws SQLException {
        String SQL = "insert into APP.USERS (FIRST_NAME, LAST_NAME, ORGANIZATION, PHONE_NUMBER, EMAIL_ADDRESS, COURSE_ENROLLED) values ('" + first_name + "', '" + last_name + "', '" + organization + "', '" + phone_number + "', '" + email_address + "', " + course_enrolled + ")";
        Statement stmt = dataBase.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        stmt.execute(SQL);
    }
    
    static ArrayList<Course> getCourses() throws SQLException {
        Statement stmt = dataBase.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String SQL = "select * from APP.COURSES";
        ResultSet rs = stmt.executeQuery(SQL);
        
        ArrayList<Course> courses = new ArrayList<Course>();
        System.out.println(rs.isLast());
        while(!rs.isLast()) {
            rs.next();
            courses.add(new Course(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("LOCATION"), rs.getString("DATE"), rs.getInt("ENROLLED"), rs.getInt("MAXIMUM"), rs.getString("TEACHER"), rs.getString("DESCRIPTION")));
        }
        
        return courses;
        
    }
    
    static void enrollInCourse(int c) throws SQLException {
        int i = getEnrollment(c) + 1; 
        String SQL = "UPDATE APP.COURSES set ENROLLED = " + i + " where ID = " + c;
        Statement stmt = dataBase.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        stmt.execute(SQL);
    }
    
    static int getEnrollment(int c) throws SQLException {
        Statement stmt = dataBase.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String SQL = "select * from APP.COURSES where ID = " + c;
        ResultSet rs = stmt.executeQuery(SQL);
        
        rs.next();
        int i = rs.getInt("ENROLLED");
        
        return i;
    }
    
    static Course getClass(int c) throws SQLException {
        Statement stmt = dataBase.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String SQL = "select * from APP.COURSES where ID = " + c;
        ResultSet rs = stmt.executeQuery(SQL);
        
        ArrayList<Course> courses = new ArrayList<Course>();
        
        rs.next();
        return new Course(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("LOCATION"), rs.getString("DATE"), rs.getInt("ENROLLED"), rs.getInt("MAXIMUM"), rs.getString("TEACHER"), rs.getString("DESCRIPTION"));
    }
    
    static User getUser(String email) throws SQLException {
        Statement stmt = dataBase.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String SQL = "select * from APP.USERS where EMAIL_ADDRESS = '" + email + "'";
        ResultSet rs = stmt.executeQuery(SQL);
        rs.next();
        return new User(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("ORGANIZATION"), rs.getString("PHONE_NUMBER"), rs.getString("EMAIL_ADDRESS"), rs.getInt("ENROLLED"));
    }
}
