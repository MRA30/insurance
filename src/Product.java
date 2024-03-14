import java.util.List;

public class Product {

    private String nama;

    private ProductType productType;

    private FrequencyPayment frequencyPayment;

    private String manfaat;

    private String ketentuan;

    private List<PremiumRate> premiumRates;

    public Product(String nama, ProductType productType, FrequencyPayment frequencyPayment, String manfaat, String ketentuan) {
        this.nama = nama;
        this.productType = productType;
        this.frequencyPayment = frequencyPayment;
        this.manfaat = manfaat;
        this.ketentuan = ketentuan;
    }

    public Product() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public FrequencyPayment getFrequencyPayment() {
        return frequencyPayment;
    }

    public void setFrequencyPayment(FrequencyPayment frequencyPayment) {
        this.frequencyPayment = frequencyPayment;
    }

    public String getManfaat() {
        return manfaat;
    }

    public void setManfaat(String manfaat) {
        this.manfaat = manfaat;
    }

    public String getKetentuan() {
        return ketentuan;
    }

    public void setKetentuan(String ketentuan) {
        this.ketentuan = ketentuan;
    }

    public List<PremiumRate> getPremiumRates() {
        return premiumRates;
    }

    public void setPremiumRates(List<PremiumRate> premiumRates) {
        this.premiumRates = premiumRates;
    }
}
