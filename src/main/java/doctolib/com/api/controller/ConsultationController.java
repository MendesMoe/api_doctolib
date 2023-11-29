package doctolib.com.api.controller;

import doctolib.com.api.domain.consultation.ConsultationService;
import doctolib.com.api.domain.consultation.DataCancelConsultation;
import doctolib.com.api.domain.consultation.DataNewConsultation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService service;

    @PostMapping
    @Transactional
    public ResponseEntity newConsultation(@RequestBody @Valid DataNewConsultation data) {
        service.createConsultation(data);

        System.out.println("newConsultation - data");
        System.out.println(data);
        return ResponseEntity.ok().build(); //new DataDetailsConsultation()
        //var consultation = new Consultation(data);
        //        repository.save(consultation);
        //
        //        System.out.println("newConsultation - data");
        //        System.out.println(data);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelConsultation(@RequestBody @Valid DataCancelConsultation data) {
        service.cancel(data);
        return ResponseEntity.noContent().build();
    }

}
