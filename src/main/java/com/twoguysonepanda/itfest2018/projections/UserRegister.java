package com.twoguysonepanda.itfest2018.projections;

public class UserRegister {
    String email;
    String username;
    String password;
    Boolean isMedic;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getMedic() {
        return isMedic;
    }

    public void setMedic(Boolean medic) {
        isMedic = medic;
    }
}
