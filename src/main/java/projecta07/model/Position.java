package projecta07.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position")
    private Long idPosition;

    @Column(name = "name_position")
    private String namePosition;

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<Employee> employeeList;

    public Position() {
    }

    public List<Employee> getEmployeeLis() {
        return employeeList;
    }

    public void setEmployeeLis(List<Employee> employeeLis) {
        this.employeeList = employeeLis;
    }

    public Long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Long idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }
}
