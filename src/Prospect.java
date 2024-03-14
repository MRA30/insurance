import java.time.LocalDate;

public class Prospect extends Person {

    private Boolean isNasabah;

    public Prospect() {
    }

    @Override
    public void printSummary() {
        System.out.printf("No: %s, %s, %s, %s (%s), %s, %s",
                getNomorProspect(), getNamaLengkap(), getJenisKelamin().getLabel(), getStringTanggalLahir(), getKotaLahir(), getPekerjaan(), isNasabah.equals(Boolean.TRUE) ? "Nasabah" : "Prospect");
    }

    public Prospect(Integer nomorProspect, String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String pekerjaan, Boolean isNasabah) {
        super(nomorProspect, namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, pekerjaan);
        this.isNasabah = isNasabah;
    }

    public Boolean getNasabah() {
        return isNasabah;
    }

    public void setNasabah(Boolean nasabah) {
        isNasabah = nasabah;
    }
}
