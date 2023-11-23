package doctolib.com.api.domain.doctor;

import doctolib.com.api.domain.address.Address;

public record DataDetailsDoctor(Long id,
                                String name,
                                String mail,
                                String phone,
                                String code,
                                Boolean status,
                                Category category,
                                Address address) {
    public DataDetailsDoctor(Doctor doctor) {
        this(doctor.getId(),doctor.getName(),doctor.getMail(),doctor.getPhone(),doctor.getCode(),doctor.getStatus(),doctor.getCategory(),doctor.getAddress());
    }
}
