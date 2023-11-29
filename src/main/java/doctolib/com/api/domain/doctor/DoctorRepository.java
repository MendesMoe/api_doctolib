package doctolib.com.api.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    //findAllByStatusTrue pattern para criar metodos com jpa para que ele crie a query. cuidado com retorno e com Object
    Page<Doctor> findAllByStatusTrue(Pageable pageable);

    @Query("""
            select d from Doctor d
            where d.status = true
            and d.category = :category
            and d.id not in(
                select c.doctor.id from Consultation c
                where
                c.date = :date)
            order by rand()
            limit 1
            """)
    Doctor randomDoctorByCategoryAndDate(Category category, LocalDateTime date);
}
