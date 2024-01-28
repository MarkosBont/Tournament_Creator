
package football.tournament.of.antiparos;

import java.time.LocalDate;


public class Student extends User {
    private String yearGroup;
    private String yearClass;
    
    public Student(int id, String userName, String password, String email,
                 LocalDate dateOfBirth,Address address, String yearGroup
            , String yearClass){
        super(id, userName, password, email, dateOfBirth, address);
        
        this.yearGroup = yearGroup;
        this.yearClass = yearClass;
        
        
        
    }

    public String getYearGroup() {
        return yearGroup;
    }

    public void setYearGroup(String yearGroup) {
        this.yearGroup = yearGroup;
    }

    public String getYearClass() {
        return yearClass;
    }

    public void setYearClass(String yearClass) {
        this.yearClass = yearClass;
    }
}
