package ai.my.phase4examination.domain;

/**
 * @ClassName Student
 * @Description TODO
 * @Auther: 张伟
 * @Date 2019/8/24 12:43
 * @Version 1.0
 */
public class Student {
    private String id;
    private String name;
    private String gender;
    private String address;
    private String phone;

    public Student() {
    }

    public Student(String id, String name, String gender, String address, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
