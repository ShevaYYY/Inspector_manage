package myClusses;

public class person {
    private String name;
    private String surname;
    private String middle_name;
    private String email;
    private String user_role;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public person(String name, String surname, String middle_name,String email, String phone,String role){
        this.name = name;
        this.surname = surname;
        this.middle_name = middle_name;
        this.email = email;
        user_role = role;
        this.phone=phone;
    }
    public person(){}
}
