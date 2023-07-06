package doctolib.com.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataNewDoctor(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String mail,
        @NotBlank
        String code,
        Category category,
        @Valid DataAddress address) {
}
