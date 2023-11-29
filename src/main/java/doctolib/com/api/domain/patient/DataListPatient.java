package doctolib.com.api.domain.patient;

import doctolib.com.api.domain.doctor.Doctor;

public record DataListPatient(Long id, String name, String mail, String document) {

    public DataListPatient(Patient patient) {
        this(
                patient.getId(), patient.getName(), patient.getMail(), patient.getDocument()
        );
    }
}
