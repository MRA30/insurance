import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

    private String nomorNasabah;

    private String nomorKTP;

    private String statusKK;

    private PaymentMethod paymentMethod;

    private LocalDate tanggalPembelian;

    private List<Policy> policies = new ArrayList<>();

    public Customer(Integer nomorProspect, String namaDepan, String namaBelakang, LocalDate tanggalLahir, String kotaLahir, Gender jenisKelamin, String pekerjaan, String nomorNasabah, String nomorKTP, String statusKK, PaymentMethod paymentMethod, LocalDate tanggalPembelian) {
        super(nomorProspect, namaDepan, namaBelakang, tanggalLahir, kotaLahir, jenisKelamin, pekerjaan);
        this.nomorNasabah = nomorNasabah;
        this.nomorKTP = nomorKTP;
        this.statusKK = statusKK;
        this.paymentMethod = paymentMethod;
        this.tanggalPembelian = tanggalPembelian;
    }

    public Customer() {
    }

    public String getNomorNasabah() {
        return nomorNasabah;
    }

    public void setNomorNasabah(String nomorNasabah) {
        this.nomorNasabah = nomorNasabah;
    }

    public String getStatusKK() {
        return statusKK;
    }

    public void setStatusKK(String statusKK) {
        this.statusKK = statusKK;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public LocalDate getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setTanggalPembelian(LocalDate tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    @Override
    public void printSummary() {
        System.out.printf("No: %s, %s, %s, %s (%s), %s \n KTP: %s, Status di KK: %s, Payment Method: %s",
                getNomorNasabah(), getNamaLengkap(), getJenisKelamin().getLabel(), getStringTanggalLahir(), getKotaLahir(), getPekerjaan(),
                nomorKTP, statusKK, paymentMethod.getLabel());
    }

    public void printSummaryWithPolicy() {
        System.out.printf("=======================CUSTOMER INFO===============================");
        System.out.printf("No: %s, %s, %s, %s (%s), %s \n KTP: %s, Status di KK: %s, Payment Method: %s",
                getNomorNasabah(), getNamaLengkap(), getJenisKelamin().getLabel(), getStringTanggalLahir(), getKotaLahir(), getPekerjaan(),
                nomorKTP, statusKK, paymentMethod.getLabel());
        System.out.printf("=====================================================================");
        for (Policy policy : policies) {
            policy.printPolicy();
        }
    }
}
