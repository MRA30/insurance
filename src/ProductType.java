public enum ProductType {

    KH("Kesehatan"),
    JW("Jiwa"),
    KR("Kendaraan");

    private String label;

    ProductType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
