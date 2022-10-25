package persons;

public class Person {
    private String name;
    private String lastName;
    private Integer birthday;
    private Double cpf;
    private String address;
    private Integer personId;

    public Person(String name, String lastName, Integer birthday, Double cpf, String address, Integer personId){
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.cpf = cpf;
        this.address = address;
        this.personId = personId;
    }
    public Person (){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getBirthday() {
        return birthday;
    }
    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }
    public Double getCpf() {
        return cpf;
    }
    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getPersonId() {
        return personId;
    }
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    @Override
    public String toString(){
        return "Pessoa{"+"Nome='"+ name + '\'' +", Sobrenome=" + lastName +", Data de Nascimento=" + birthday +", CPF=" + cpf +",  Endereço=" + address +", Identificador Pessoal=" + personId +'}';
    }
}
