package doctolib.com.api.domain.doctor;

import doctolib.com.api.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Doctor")
@Table(name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mail;
    private String phone;
    private String code;
    private Boolean status;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Embedded
    private Address address;

    public Doctor(DataNewDoctor data) {
        this.name = data.name();
        this.code = data.code();
        this.status = true;
        this.mail = data.mail();
        this.phone = data.phone();
        this.category = data.category();
        this.address = new Address(data.address());
    }

    public void updateInformations(DataUpdateDoctor data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.address() != null) {
            this.address.updateAddressInformations(data.address());
        }
    }

    public void setDisabled() {
        this.status = false;
    }
}
