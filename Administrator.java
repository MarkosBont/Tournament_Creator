package football.tournament.of.antiparos;

import java.time.LocalDate;

public class Administrator extends User {

    private String teaches;

    public Administrator(int id, String userName, String password, String email,
            LocalDate dateOfBirth, Address address, String teaches) {
        super(id, userName, password, email, dateOfBirth, address);

        this.teaches = teaches;
    }

    public String getTeaches() {
        return teaches;
    }

    public void setTeaches(String teaches) {
        this.teaches = teaches;
    }
}
