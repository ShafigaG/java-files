public class ShippingInfo {
    private String customerName;
    private String customerAddress;
    private String productName;
    private double productPrice;
    private String deliveryCompany;

    public ShippingInfo(
            String customerName,
            String customerAddress,
            String productName,
            double productPrice,
            String deliveryCompany
    ) throws InvalidShippingDataException {
        if (customerName == null || customerName.isEmpty() ||
                customerAddress == null || customerAddress.isEmpty() ||
                productName == null || productName.isEmpty() ||
                deliveryCompany == null || deliveryCompany.isEmpty() ||
                productPrice < 0) {
            throw new InvalidShippingDataException("The shipping information is incorrect or incomplete.");
        }
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.productName = productName;
        this.productPrice = productPrice;
        this.deliveryCompany = deliveryCompany;
    }

    public String allInfoString(){
        return customerName + ";" +
                customerAddress + ";" +
                productName + ";" +
                productPrice + ";" +
                deliveryCompany + ";";
    }


}
