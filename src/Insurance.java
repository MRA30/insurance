import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Insurance {

    private static Map<Integer, Prospect> prospectMap = new HashMap<>();

    private static Map<String, Customer> customerMap = new HashMap<>();

    private static Map<String, Product> productMap = new HashMap<>();

    public static void initializeDataProduct() {
        Product productSH = new Product("Sehat Bersama", ProductType.KH, FrequencyPayment.B, "Claim perawatan kelas 1.", "Bisa menanggung keluarga atau diri sendiri dari data nasabah.");
        List<PremiumRate> premiumRatesSH = new ArrayList<>(Arrays.asList(
                new PremiumRate(productSH, 0, 20, 200_000D),
                new PremiumRate(productSH, 21, 999, 400_000D)
        ));
        productSH.setPremiumRates(premiumRatesSH);
        productMap.put("Sehat Bersama", productSH);
        Product productSE = new Product("Sehat Extra", ProductType.KH, FrequencyPayment.B, "Claim perawatan kelas VIP.", "Hanya bisa menanggung diri sendiri.");
        List<PremiumRate> premiumRatesSE = new ArrayList<>(Arrays.asList(
                new PremiumRate(productSE, 0, 20, 300_000D),
                new PremiumRate(productSE, 21, 999, 500_000D)
        ));
        productSE.setPremiumRates(premiumRatesSE);
        productMap.put("Sehat Extra", productSE);
        Product productLK = new Product("Life Keluarga", ProductType.JW, FrequencyPayment.B, "Mendapatkan 500.000.000 apabila terjadi sesuatu pada tertanggung.", "Bisa menanggung keluarga atau dirisendiri dari datanasabah.");
        List<PremiumRate> premiumRatesLK = new ArrayList<>(Arrays.asList(
                new PremiumRate(productSE, 0, 20, 250_000D),
                new PremiumRate(productSE, 21, 999, 450_000D)
        ));
        productLK.setPremiumRates(premiumRatesLK);
        productMap.put("Life Keluarga", productLK);
        Product productLS = new Product("Life Special", ProductType.JW, FrequencyPayment.T, "Mendapatkan 800.000.000 apabila terjadi sesuatu pada tertanggung.", "Hanya bisa menanggung diri sendiri.");
        List<PremiumRate> premiumRatesLS = new ArrayList<>(Arrays.asList(
                new PremiumRate(productLS, 0, 20, 3_600_000D),
                new PremiumRate(productLS, 21, 999, 4_800_000D)
        ));
        productLS.setPremiumRates(premiumRatesLS);
        productMap.put("Life Special", productLS);
        Product productPT = new Product("Protection", ProductType.JW, FrequencyPayment.T, "Mendapat ganti rugi sampai 100.000.000 bila terjadi sesuatu.", "Hanya bisa menanggung kendaraan.");
        List<PremiumRate> premiumRatesPT = new ArrayList<>(List.of(
                new PremiumRate(productPT, null, null, 2_000_000D)
        ));
        productPT.setPremiumRates(premiumRatesPT);
        productMap.put("Protection", productPT);
        Product productPTP = new Product("Protection Plus", ProductType.JW, FrequencyPayment.T, "Mendapat ganti rugi total lost apa bila terjadi sesuatu.", "Hanya bisa menanggung kendaraan.");
        List<PremiumRate> premiumRatesPTP = new ArrayList<>(List.of(
                new PremiumRate(productPTP, null, null, 2_500_000D)
        ));
        productPTP.setPremiumRates(premiumRatesPTP);
        productMap.put("Protection Plus", productPTP);
    }

    public static Product findProductByName(String name) {
        return productMap.get(name);
    }

    public static void printAllProspectSummary(){
        for(var prospect : prospectMap.values()){
            prospect.printSummary();
        }
    }

    public static Boolean findProsPectByNomorAndPrint(Integer nomor) {
        var selectedProcpect = prospectMap.get(nomor);
        if(selectedProcpect == null){
            return false;
        }
        selectedProcpect.printSummary();
        return true;
    }

    public static void addProspect(Prospect prospect) {
        prospectMap.put(prospect.getNomorProspect(), prospect);
    }

    public static void printAllCustomerSummary(){
        for(var customer : customerMap.values()){
            customer.printSummary();
        }
    }

    public static Boolean findCustomerByNomorAndPrint(String nomor) {
        var selectedCustomer = customerMap.get(nomor);
        if(selectedCustomer == null){
            return false;
        }
        selectedCustomer.printSummary();
        return true;
    }

    public static void addCustomer(Customer customer) {
        customerMap.put(customer.getNomorNasabah(), customer);
    }

    public static Boolean addPolicyCustomer(Customer customer, Policy policy) {
        Boolean returnValue = false;
        if (policy.getProduct().getProductType().equals(ProductType.KR)) {
            if (!policy.getProduct().getPremiumRates().isEmpty()) {
                policy.setPremiumRate(policy.getProduct().getPremiumRates().get(0));
                returnValue = true;
            }else {
                returnValue =  false;
            }
        }else {
            Integer umur = Period.between(policy.getNasabah().getTanggalLahir(), LocalDate.now()).getYears();
            for (PremiumRate premiumRate: policy.getProduct().getPremiumRates()) {
                if (umur > premiumRate.getMinimumUmur() && umur < premiumRate.getMaksimumUmur()) {
                    policy.setPremiumRate(premiumRate);
                    returnValue = true;
                } else {
                    returnValue = false;
                }
            }
        }
        if (Boolean.TRUE.equals(returnValue)) {
            customer.getPolicies().add(policy);
        }
        return returnValue;
    }

}
