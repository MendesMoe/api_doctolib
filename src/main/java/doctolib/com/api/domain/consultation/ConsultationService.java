package doctolib.com.api.domain.consultation;

import doctolib.com.api.domain.doctor.Doctor;
import doctolib.com.api.domain.doctor.DoctorRepository;
import doctolib.com.api.domain.patient.Patient;
import doctolib.com.api.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consulRepository;

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public void createConsultation(DataNewConsultation data) {

        // preciso ter as regras de negocio e depois criar a consulta

        var doctor = doctorRepository.findById(data.idDoctor()).get();
        var patient = patientRepository.findById(data.idPatient()).get();
        var consultation = new Consultation(null, doctor, patient, data.date()); //como recupera o doctor e patient com o id ? var consultation = new Consultation(null, Doctor, Patient, data.date());
        consulRepository.save(consultation);
    }
}
