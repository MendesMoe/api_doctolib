package doctolib.com.api.doctor;

import jakarta.validation.constraints.NotBlank;

public record DataAddress(
        @NotBlank
        String street,
        @NotBlank
        int zip_code,
        @NotBlank
        String city,
        @NotBlank
        String region,
        String number,
        String more) {
}
