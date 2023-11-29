package doctolib.com.api.domain.patient;

import doctolib.com.api.domain.address.Address;

public record DataDetailsPatient(Long id,
                                 String name,
                                 String mail,
                                 String document,
                                 Address address,
                                 String phone) {

    public DataDetailsPatient(Patient patient) {
        this(patient.getId(),patient.getName(),patient.getMail(),patient.getDocument(),patient.getAddress(),patient.getPhone());
    }
}