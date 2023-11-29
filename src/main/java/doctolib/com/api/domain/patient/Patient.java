package doctolib.com.api.domain.patient;

import doctolib.com.api.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name ="patients")
@Entity(name = "Patient")
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mail;
    private String document;
    private String phone;
    private Boolean status;

    @Embedded
    private Address address;

    public Patient(DataNewPatient data) {
        this.name = data.name();
        this.mail = data.mail();
        this.document = data.document();
        this.address = new Address(data.address());
        this.phone = data.phone();
        this.status = true;
    }
}
