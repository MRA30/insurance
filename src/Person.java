import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Person {

    private Integer nomorProspect;
    private String namaDepan;
    private String namaBelakang;
    private LocalDate tanggalLahir;
    private String kotaLahir;
    private Gender jenisKelamin;
    private String pekerjaan;

    public Person(Integer nomorProspect, String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String pekerjaan) {
        this.nomorProspect = nomorProspect;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tanggalLahir = tanggalLahir;
        this.kotaLahir = kotaLahir;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
    }

    public Person() {
    }

    public Integer getNomorProspect() {
        return nomorProspect;
    }

    public void setNomorProspect(Integer nomorProspect) {
        this.nomorProspect = nomorProspect;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getKotaLahir() {
        return kotaLahir;
    }

    public void setKotaLahir(String kotaLahir) {
        this.kotaLahir = kotaLahir;
    }

    public Gender getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Gender jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getNamaLengkap(){
        return String.format("%s %s", namaDepan, namaBelakang);
    }

    public String getStringTanggalLahir(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("id-ID"));
        return formatter.format(tanggalLahir);
    }

    public abstract void printSummary();
}
