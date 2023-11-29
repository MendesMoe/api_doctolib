package doctolib.com.api.domain.patient;

import doctolib.com.api.domain.doctor.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataNewPatient(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String mail,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{8,11}")
        String document,
        @Valid
        DataAddress address){
}
