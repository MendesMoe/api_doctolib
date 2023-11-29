package doctolib.com.api.domain.consultation;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataDetailsConsultation(Long id, Long idMedico, Long idPatient, LocalDateTime date){
}
