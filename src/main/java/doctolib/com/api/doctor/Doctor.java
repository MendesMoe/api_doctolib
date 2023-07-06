package doctolib.com.api.doctor;

import doctolib.com.api.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Table(name = "doctors")
@Entity(name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mail;
    private String code;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Embedded
    private Address address;

    public Doctor(DataNewDoctor data) {
        this.name = data.name();
        this.code = data.code();
        this.mail = data.mail();
        this.category = data.category();
        this.address = new Address(data.address());
    }
}
