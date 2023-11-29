package doctolib.com.api.domain.consultation;

import doctolib.com.api.domain.doctor.Doctor;
import doctolib.com.api.domain.doctor.DoctorRepository;
import doctolib.com.api.domain.patient.PatientRepository;
import doctolib.com.api.infra.exception.ValidationDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consulRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public void createConsultation(DataNewConsultation data) {

        // preciso ter as regras de negocio e depois criar a consulta
        // validation data
        if (!patientRepository.existsById(data.idPatient())) {
            throw new ValidationDataException("None patient found with this id! ");
        }
        if (data.idDoctor() != null && ! doctorRepository.existsById(data.idDoctor())) {
            throw new ValidationDataException("None doctor found with this id! ");
        }

        var doctor = getRandomDoctor(data);
        var patient = patientRepository.findById(data.idPatient()).get();
        var consultation = new Consultation(null, doctor, patient, data.date(), null); //como recupera o doctor e patient com o id ? var consultation = new Consultation(null, Doctor, Patient, data.date());
        consulRepository.save(consultation);
    }

    private Doctor getRandomDoctor(DataNewConsultation data) {
        if (data.idDoctor() != null) {
            return doctorRepository.getReferenceById(data.idDoctor());
        }

        if (data.category() == null) {
            throw new ValidationDataException("Category is mandatory for this request");
        }

        return doctorRepository.randomDoctorByCategoryAndDate(data.category(), data.date());
    }

    public void cancel(DataCancelConsultation data) {
        if(! consulRepository.existsById(data.idConsultation())) {
            throw new ValidationDataException("The id consultation is mandatory");
        }

        var consultation = consulRepository.getReferenceById(data.idConsultation());
        consultation.cancel(data.reason());
    }
}
