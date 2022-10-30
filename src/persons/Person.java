package persons;

import java.time.LocalDate;

public class Person {
    private String firstname;
    private String lastName;
    private LocalDate birthday;
    private String cpf;
    private String address;
    private Integer age;
    private Integer id;

    public Person(String firstname, String lastName, LocalDate birthday, String cpf, String address, Integer id){
        this.firstname = firstname;
        this.lastName = lastName;
        this.birthday = birthday;
        this.cpf = cpf;
        this.address = address;
        this.age = counterAge();
        this.id = id;
    }
    public Person (){}
    public Integer counterAge(){
        this.age = LocalDate.now().getYear() - birthday.getYear();
        return this.age;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", cpf=" + cpf +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
