package fr.eservices.drive.model;

public class Customer {
    int id;
    String firstName;
    String lastName;
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getActiveCart() {
        return activeCart;
    }

    public void setActiveCart(Cart activeCart) {
        this.activeCart = activeCart;
    }

    String password;
    Cart activeCart;
}
