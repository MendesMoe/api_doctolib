package doctolib.com.api.controller;

import doctolib.com.api.doctor.*;
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
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity newDoctor(@RequestBody @Valid DataNewDoctor data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        repository.save(doctor);
        var uri = uriBuilder.path("doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DataListDoctor>> allDoctors(@PageableDefault( size=10, sort = {"name"}) Pageable pageable) { // para usar a paginacao nao retorna List, mas Page, e usa Pageble du spring domain e nao precisa mais de toList()
        var page = repository.findAllByStatusTrue(pageable).map(DataListDoctor::new); // na hora de chamar a api o cliente pode decidir a paginacao 'http://localhost:8080/doctors?size=1&page=1&sort=code,desc'

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInformations(data);

        return ResponseEntity.ok(new DataDetailsDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity dalete(@PathVariable Long id) { // para receber um parametro dinamico tem que usar pathvariable para dizer que vai ser uma variavel do path
        var doctor = repository.getReferenceById(id);
        doctor.setDisabled();
        return ResponseEntity.noContent().build();
    }//codigo 204 quer dizer que a req foi processada e nao tem conteudo
}
