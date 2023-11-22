package doctolib.com.api.doctor;

public record DataLisDoctor(Long id, String name, String mail, String code, Category category) {

    public DataLisDoctor(Doctor doctor) {
        this(
                doctor.getId(), doctor.getName(), doctor.getMail(), doctor.getCode(), doctor.getCategory()
        );
    }
}
