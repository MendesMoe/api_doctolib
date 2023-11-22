package doctolib.com.api.address;

import doctolib.com.api.doctor.DataAddress;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String zip_code;
    private String city;
    private String region;
    private String number;
    private String more;

    public Address(DataAddress data) {
        this.street = data.street();
        this.city = data.city();
        this.zip_code = data.zip_code();
        this.number = data.number();
        this.region = data.region();
        this.more = data.more();
    }
}
