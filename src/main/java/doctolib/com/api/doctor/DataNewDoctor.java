package doctolib.com.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataNewDoctor(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String mail,
        @NotBlank
        String phone,
        @NotBlank
                @Pattern(regexp = "\\d{4,6}")
        String code,
        String status,
        Category category,
        @Valid DataAddress address) {
}
