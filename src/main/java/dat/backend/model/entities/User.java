package dat.backend.model.entities;

import java.util.Objects;

public class User
{
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;
    private int balance;

    public User(String name, String email, String password, boolean isAdmin, int balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getEmail(), getPassword());
    }

    @Override
    public String toString()
    {
        return "User{" +
                "brugerNavn='" + email + '\'' +
                ", kodeord='" + password + '\'' +
                ", rolle=";
    }
}
