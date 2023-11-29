package doctolib.com.api.domain.consultation;

import doctolib.com.api.domain.doctor.Doctor;
import doctolib.com.api.domain.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="consultation")
@Entity(name="Consultation")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="patient_id")
    private Patient patient;

    private LocalDateTime date;

    @Column(name = "reason_cancel")
    @Enumerated(EnumType.STRING)
    private CancelReason cancelReason;

    public void cancel(CancelReason reason) {
        this.cancelReason = reason;
    }
}
