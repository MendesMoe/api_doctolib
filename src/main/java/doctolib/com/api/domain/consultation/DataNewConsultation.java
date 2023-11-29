package doctolib.com.api.domain.consultation;

import doctolib.com.api.domain.doctor.Category;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataNewConsultation(
        Long idDoctor,

        @NotNull
        Long idPatient,

        @NotNull
        @Future
        LocalDateTime date,
        Category category) {
}
