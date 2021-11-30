package se.iths.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 2)
    @NotBlank(message = "first name cant be blank")
    private String firstName;
    @NotBlank(message = "last name cant be blank")
    private String lastName;
    @NotBlank(message = "email cant be blank")
    @Email(message = "Wrong format")
    private String email;

    private String phoneNumber;

    @ManyToMany
    private List<Subject> subjects = new ArrayList<>();

    public Student(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student(){ }

    public String getFirstName() {
        return firstName;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
        subject.getStudents().add(this);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
