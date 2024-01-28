package football.tournament.of.antiparos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    public static void main(String[] args) {
        Address add = new Address("C", "C", "C", "C");
        LocalDate dob = LocalDate.of(2000, 10, 20);
        Administrator a = new Administrator(0, "C", "C", "C@C.COM", dob, add, "C");
        writeAdministrator(a);
        
    }
    
 
    
    public static ArrayList<Administrator> readAdministrators() {
        ArrayList<Administrator> administrators = new ArrayList();
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Administrator");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String streetName = rs.getString("streetName");
                String streetNumber = rs.getString("streetNumber");
                String postCode = rs.getString("postCode");
                String city = rs.getString("city");
                String dateOfBirth = rs.getString("dateOfBirth");
                String teaches = rs.getString("teaches");

                String[] date = dateOfBirth.split(":");
                LocalDate dob = LocalDate.of(Integer.parseInt(date[0]), 
                        Integer.parseInt(date[1]), 
                        Integer.parseInt(date[2]));
                
                Address address = new Address(streetName, streetNumber, postCode, city);
                
                Administrator admin = new Administrator(id, username, password, email, 
                        dob, address, teaches);
                
                administrators.add(admin);
            }
            
            conn.close();
        } catch (Exception er) {
            System.out.println("Error " + er.getMessage());
            
            return null;
        }
        
        return administrators;
    }
    
    public static void writeAdministrator(Administrator admin) {
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Administrator (" +
                                "username, password, email, streetName, streetNumber, postCode, city, dateOfBirth, teaches" +
                    
                    
                                ") VALUES (" + 
                                "'" + admin.getUserName() + "'," +
                                "'" + admin.getPassword() + "'," +
                                "'" + admin.getEmail() + "'," +
                                "'" + admin.getAddress().getStreetName() + "'," +
                                "'" + admin.getAddress().getStreetNumber() + "'," +
                                "'" + admin.getAddress().getPostCode()+ "'," +
                                "'" + admin.getAddress().getCity() + "'," +
                                "'" + admin.getDateOfBirth().getYear() + ":" + admin.getDateOfBirth().getMonthValue() + ":" + admin.getDateOfBirth().getDayOfMonth() + "'," +
                                "'" + admin.getTeaches()+ "'"  + ")");
            
            
            
            conn.close();
        } catch (Exception er) {
            System.out.println("Error " + er.getMessage());
        }
        
    }
    
    public static ArrayList<Student> readStudents() {
        ArrayList<Student> students = new ArrayList();
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String yearGroup = rs.getString("yearGroup");
                String yearClass = rs.getString("yearClass");
                String streetName = rs.getString("streetName");
                String streetNumber = rs.getString("streetNumber");
                String postCode = rs.getString("postCode");
                String city = rs.getString("city");
                String dateOfBirth = rs.getString("dateOfBirth");
                

                String[] date = dateOfBirth.split(":");
                LocalDate dob = LocalDate.of(Integer.parseInt(date[0]), 
                        Integer.parseInt(date[1]), 
                        Integer.parseInt(date[2]));
                
                Address address = new Address(streetName, streetNumber, postCode, city);
                
                Student student = new Student(id, username, password, email, dob, address, yearGroup, yearClass);
                
                students.add(student);
            }

            conn.close();
        } catch (Exception er) {
            System.out.println("Error " + er.getMessage());
            return null;
        }
        
        return students;
    }
    
    public static void writeStudent(Student student) {
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Student (" +
                                "username, password, email, yearGroup, yearClass, dateOfBirth, streetName, streetNumber, postCode, city" +
                    
                    
                                ") VALUES (" + 
                                "'" + student.getUserName() + "'," +
                                "'" + student.getPassword() + "'," +
                                "'" + student.getEmail() + "'," +
                                "'" + student.getYearGroup()+ "'," +  
                                "'" + student.getYearClass() + "'," +
                                "'" + student.getDateOfBirth().getYear() + ":" + student.getDateOfBirth().getMonthValue() + ":" + student.getDateOfBirth().getDayOfMonth() + "'," +        
                                "'" + student.getAddress().getStreetName() + "'," +
                                "'" + student.getAddress().getStreetNumber() + "'," +
                                "'" + student.getAddress().getPostCode()+ "'," +
                                "'" + student.getAddress().getCity() + "'," +
                                "'" + ")");
            
            
            
            conn.close();
        } catch (Exception er) {
            System.out.println("Error " + er.getMessage());
        }
        
    }
    
    public static ArrayList<String> readTeacherKeys() {
        ArrayList<String> keys = new ArrayList();
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TeacherKeys");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String key = rs.getString("key");

                keys.add(key);
            }
            conn.close();
        } catch (Exception er) {
            return null;
        }
        
        return keys;
    }
    
    public static void writePlayer(Player player) {
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
            
            //MAYBE NOT PASS THE ID, AUTOINCREMENT
            stmt.executeUpdate("INSERT INTO Players (" +
                                "name, surname, goals, assists" +
                                ") VALUES (" + 
                                "'" + player.getName() + "'," +
                                "'" + player.getSurname() + "'," +
                                player.getGoals() + "," +
                                player.getAssists()+
                                ")");
            
            
            
            conn.close();
        } catch (Exception er) {
            System.out.println("Error " + er.getMessage());
        }
        
    }
    
    public static void updatePlayer(Player player) {
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
                        
            stmt.executeUpdate("UPDATE Players SET " +
                                "goals = " + player.getGoals() + ", assists = " + player.getAssists() +
                                " WHERE id = " + player.getId()
                                );
            
            conn.close();
        } catch (Exception er) {
            System.out.println("Error " + er.getMessage());
        }
        
    }
    
    public static void deletePlayer(int id) {
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
                        
            stmt.executeUpdate("DELETE FROM Players" +
                               " WHERE id = " + id
                                );
            
            conn.close();
        } catch (Exception er) {
            System.out.println("Error " + er.getMessage());
        }
        
    }
    
    public static ArrayList<Player> readPlayers() {
        ArrayList<Player> players = new ArrayList();
        
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/markos/NetBeansProjects/Football Tournament Of Antiparos/Football_DB.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Players");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int goals = rs.getInt("goals");
                int assists = rs.getInt("assists");
                
                Player p = new Player(name, surname, goals, assists, id);
                players.add(p);
            }

            conn.close();
        } catch (Exception er) {
            System.out.println("Error " + er.getMessage());
            return null;
        }
        
        return players;
    }
}
