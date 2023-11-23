package doctolib.com.api.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    //findAllByStatusTrue pattern para criar metodos com jpa para que ele crie a query. cuidado com retorno e com Object
    Page<Doctor> findAllByStatusTrue(Pageable pageable);
}
