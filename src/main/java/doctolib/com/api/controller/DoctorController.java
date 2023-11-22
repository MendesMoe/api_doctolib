package doctolib.com.api.controller;

import doctolib.com.api.doctor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;
    @PostMapping
    @Transactional
    public void newDoctor(@RequestBody @Valid DataNewDoctor data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DataListDoctor> allDoctors(@PageableDefault( size=10, sort = {"name"}) Pageable pageable) { // para usar a paginacao nao retorna List, mas Page, e usa Pageble du spring domain e nao precisa mais de toList()
        return repository.findAllByStatusTrue(pageable).map(DataListDoctor::new); // na hora de chamar a api o cliente pode decidir a paginacao 'http://localhost:8080/doctors?size=1&page=1&sort=code,desc'
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInformations(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void dalete(@PathVariable Long id) { // para receber um parametro dinamico tem que usar pathvariable para dizer que vai ser uma variavel do path
        var doctor = repository.getReferenceById(id);
        doctor.setDisabled();
    }
}
