package cn.practice.BZhan._10_XML_JSON._01;

public class Person {
    private String name;
    private String address;
    private String tel;
    private String fax;
    private String email;
    private String personid;

    public Person(String name, String address, String tel, String fax, String email,String personid) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.fax = fax;
        this.email = email;
        this.personid = personid;
    }
    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", personid='" + personid + '\'' +
                '}';
    }
}
