package doctolib.com.api.doctor;

public record DataListDoctor(Long id, String name, String mail, String code, Category category) {

    public DataListDoctor(Doctor doctor) {
        this(
                doctor.getId(), doctor.getName(), doctor.getMail(), doctor.getCode(), doctor.getCategory()
        );
    }
}
