import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Policy {

    private Customer nasabah;

    private Product product;

    private LocalDate tanggalMulai;

    private PremiumRate premiumRate;

    private Customer tertanggung;

    private String jenisKendaraan;

    private String nomorPolisi;

    private String nomorSTNK;

    private String merekKendaraan;

    private String modelKendaraan;

    private String warnaKendaraan;

    public Policy(Customer nasabah, Product product, LocalDate tanggalMulai, PremiumRate premiumRate, Customer tertanggung, String jenisKendaraan, String nomorPolisi, String nomorSTNK, String merekKendaraan, String modelKendaraan, String warnaKendaraan) {
        this.nasabah = nasabah;
        this.product = product;
        this.tanggalMulai = tanggalMulai;
        this.premiumRate = premiumRate;
        this.tertanggung = tertanggung;
        this.jenisKendaraan = jenisKendaraan;
        this.nomorPolisi = nomorPolisi;
        this.nomorSTNK = nomorSTNK;
        this.merekKendaraan = merekKendaraan;
        this.modelKendaraan = modelKendaraan;
        this.warnaKendaraan = warnaKendaraan;
    }

    public Policy() {
    }

    public Customer getNasabah() {
        return nasabah;
    }

    public void setNasabah(Customer nasabah) {
        this.nasabah = nasabah;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PremiumRate getPremiumRate() {
        return premiumRate;
    }

    public void setPremiumRate(PremiumRate premiumRate) {
        this.premiumRate = premiumRate;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Customer getTertanggung() {
        return tertanggung;
    }

    public void setTertanggung(Customer tertanggung) {
        this.tertanggung = tertanggung;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public void setNomorPolisi(String nomorPolisi) {
        this.nomorPolisi = nomorPolisi;
    }

    public String getNomorSTNK() {
        return nomorSTNK;
    }

    public void setNomorSTNK(String nomorSTNK) {
        this.nomorSTNK = nomorSTNK;
    }

    public String getMerekKendaraan() {
        return merekKendaraan;
    }

    public void setMerekKendaraan(String merekKendaraan) {
        this.merekKendaraan = merekKendaraan;
    }

    public String getModelKendaraan() {
        return modelKendaraan;
    }

    public void setModelKendaraan(String modelKendaraan) {
        this.modelKendaraan = modelKendaraan;
    }

    public String getWarnaKendaraan() {
        return warnaKendaraan;
    }

    public void setWarnaKendaraan(String warnaKendaraan) {
        this.warnaKendaraan = warnaKendaraan;
    }

    public void printPolicy() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("id-ID"));
        System.out.println("======================== POLICY INFO ==================================");
        if (product.getProductType().equals(ProductType.KR)) {
            System.out.printf("Product: %s\nTanggal Mulai Dijalankan: %s\nJenis kendaraan: %s\nNomor Polisi: %s\nNomor STNK: %s\nMerek kendaraan: %s\nModel kendaraan: %s\nWarna kendaraan: %s",
                    product.getNama(), formatter.format(tanggalMulai), jenisKendaraan, nomorPolisi, nomorSTNK, merekKendaraan, modelKendaraan, warnaKendaraan);
        }else {
            System.out.printf("Tertanggung: %s\nProduct: %s\nTanggal Mulai Dijalankan: %s\nManfaat: %s",
                    tertanggung.getNamaLengkap(), product.getNama(), formatter.format(tanggalMulai), product.getManfaat());
        }
        System.out.println("=======================================================================");
        System.out.println("========================== PAYMENT ====================================");
        if (product.getFrequencyPayment().equals(FrequencyPayment.T)) {
            for (int i = 0; i < 3; i++) {
                System.out.printf("%s, %s", formatter.format(tanggalMulai.plusYears(i)), premiumRate.getIuran());
            }
        } else if (product.getFrequencyPayment().equals(FrequencyPayment.B)) {
            for (int i = 0; i < 3; i++) {
                System.out.printf("%s, %s", formatter.format(tanggalMulai.plusMonths(i)), premiumRate.getIuran());
            }
        }
        System.out.println("=====================================================================");
    }
}
