package doctolib.com.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctor(@NotNull Long id,
                               String name,
                               String phone,
                               @Valid DataAddress address) {
}
