package doctolib.com.api.controller;

import doctolib.com.api.domain.doctor.DataDetailsDoctor;
import doctolib.com.api.domain.doctor.DataListDoctor;
import doctolib.com.api.domain.doctor.DataNewDoctor;
import doctolib.com.api.domain.doctor.Doctor;
import doctolib.com.api.domain.patient.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity newPatient(@RequestBody @Valid DataNewPatient data, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(data);
        repository.save(patient);
        var uri = uriBuilder.path("patient/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsPatient(patient));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPatient>> allDoctors(@PageableDefault( size=10, sort = {"name"}) Pageable pageable) { // para usar a paginacao nao retorna List, mas Page, e usa Pageble du spring domain e nao precisa mais de toList()
        var page = repository.findAll(pageable).map(DataListPatient::new); // na hora de chamar a api o cliente pode decidir a paginacao 'http://localhost:8080/doctors?size=1&page=1&sort=code,desc'

        return ResponseEntity.ok(page);
    }

}
