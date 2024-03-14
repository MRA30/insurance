public enum FrequencyPayment {

    B("Bulanan"),
    T("Tahunan");

    private String label;

    FrequencyPayment(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
