package doctolib.com.api.domain.address;

import doctolib.com.api.domain.doctor.DataAddress;
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

    public void updateAddressInformations(DataAddress address) {
        if (address.street() != null) {
            this.street = address.street();
        }
        if (address.city() != null) {
            this.city = address.city();

        }
        if (address.zip_code() != null) {
            this.zip_code = address.zip_code();

        }

        if (address.number() != null) {
            this.number = address.number();

        }
        if (address.region() != null) {
            this.region = address.region();

        }
        if (address.more() != null) {
            this.more = address.more();
        }
    }
}
