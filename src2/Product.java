public class Product {
    private String productName;
    private String productCategory;
    private double productPrice;
    private int productAmount;

    public Product(String productName, String productCategory, double productPrice, int productAmount) throws InvalidProductException {
        if (productName == null || productName.isEmpty()) {
            throw new InvalidProductException("Product name cannot be empty.");
        }
        if (productCategory == null || productCategory.isEmpty()) {
            throw new InvalidProductException("Product category cannot be empty.");
        }
        if (productPrice <= 0) {
            throw new InvalidProductException("Product price cannot be 0 or a negative number.");
        }
        if (productAmount < 0) {
            throw new InvalidProductException("Product amount cannot be a negative number.");
        }
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
    }

    public boolean isAvailable() {
        return productAmount > 0;
    }

    public String toCsvLine() {
        return productName + ";" + productCategory + ";" + productPrice + ";" + productAmount;
    }
}
/*
Project Manager Tələbləri:
"Hazırda anbarda olan məhsulların siyahısına ehtiyacım var.
Hər bir məhsulun adı, kateqoriyası, qiyməti və sayını göstərən bir .csv fayl istəyirəm.
Anbarda qalmayan məhsullar bu siyahıya daxil edilməməlidir.
Fayl ; ilə ayrılmalı və Google Sheets/Excel-də oxunaqlı olmalıdır.
Hər hansı məhsulda problem varsa, sistem dayanmamalıdır."

Sizdən Tələb Olunur:
Product adlı sinif yaradın.

Məhsulları kolleksiyasıyada saxlayın.

Ən azı 10 məhsul yaradın, müxtəlif kateqoriyalardan.

Sayı 0 və ya daha az olan məhsulları CSV-yə daxil etməyin.

Faylı products.csv adı ilə yazın (ProductID;Ad;Kateqoriya;Qiymət;Say).

Fayl yazılarkən və məlumatlar yoxlanarkən istisna halları düzgün idarə edin.
 */