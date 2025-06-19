import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        try {
            products.add(new Product("Estée Lauder Concealer", "Concealers&Neutralizers", 38.0, 970));
            products.add(new Product("Obagi Moisturizer", "Face Moisturizers", 80.0, 210));
            products.add(new Product("Glo Skin Foundation", "Foundation", 53.99, 7));
            products.add(new Product("e.l.f SKIN Bronzer", "Bronzers", 12.0, 2000));
            products.add(new Product("Revision Anti Aging Moisturizer", "Face Moisturizers", 86.0, 50));
            products.add(new Product("Yves Saint Laurent Eyeshadow Palette", "Eyeshadow", 56.99, 892));
            products.add(new Product("Yves Saint Laurent Liquid Blush", "Blush", 50.11, 120));
            products.add(new Product("Kiko Milano Liquid Lipstick", "Lipstick", 17.0, 4929));
            products.add(new Product("Lancôme Powder Foundation", "Foundation", 52.0, 8));
            products.add(new Product("Chanel Waterproof Eyeliner", "Eyeliner", 35.89, 2));
        } catch (InvalidProductException e) {
            System.out.println("Product information is incorrect: " + e.getMessage());
        }

        String fileName = "products.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Product name;Product category;Product price;Product amount");
            writer.newLine();

            for (Product product : products) {
                try {
                    if (product.isAvailable()) {
                        writer.write(product.toCsvLine());
                        writer.newLine();
                    }
                } catch (Exception e) {
                    System.out.println("Error while writing product: " + e.getMessage());
                }
            }

            System.out.println("File written successfully: " + fileName);

        } catch (IOException e) {
            System.err.println("Could not write to file: " + e.getMessage());
        }
    }
}