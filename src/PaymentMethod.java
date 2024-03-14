public enum PaymentMethod {

    CC("Credit Card"),
    AC("Auto Collectio"),
    VP(" Voucher Point");

    private String label;

    PaymentMethod(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
