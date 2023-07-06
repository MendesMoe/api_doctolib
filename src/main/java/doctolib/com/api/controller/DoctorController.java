package doctolib.com.api.controller;

import doctolib.com.api.doctor.DataNewDoctor;
import doctolib.com.api.doctor.Doctor;
import doctolib.com.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;
    @PostMapping
    @Transactional
    public void newDoctor(@RequestBody DataNewDoctor data) {
        repository.save(new Doctor(data));
    }
}
