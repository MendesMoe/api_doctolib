package doctolib.com.api.domain.consultation;

import jakarta.validation.constraints.NotNull;

public record DataCancelConsultation(@NotNull
                                     Long idConsultation,
                                     @NotNull
                                     CancelReason reason) {
}
