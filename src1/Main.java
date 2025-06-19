import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<ShippingInfo> shippingInfos = new ArrayList<>();
        Scanner myObj = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to add a new shipment? (yes/no): ");
            String answer = myObj.nextLine();

            if (answer.equals("no")) {
                break;
            }

            if (answer.equals("yes")) {
                try {
                    System.out.print("Customer name: ");
                    String name = myObj.nextLine();

                    System.out.print("Customer Address: ");
                    String address = myObj.nextLine();

                    System.out.print("Product name: ");
                    String product = myObj.nextLine();

                    System.out.print("Product price: ");
                    double price = Double.parseDouble(myObj.nextLine());

                    System.out.print("Delivery company: ");
                    String company = myObj.nextLine();

                    ShippingInfo info = new ShippingInfo(name, address, product, price, company);
                    shippingInfos.add(info);

                    File file = new File("shipping_infos.csv");
                    boolean fileExists = file.exists();

                    try (FileWriter writer = new FileWriter(file, true)) {
                        if (!fileExists) {
                            writer.write("Customer name;Customer address;Product name;Product price;Delivery company name\n");
                        }
                        ShippingInfo lastInfo = shippingInfos.getLast();
                        writer.write(lastInfo.allInfoString() + "\n");
                        System.out.println("The data was successfully written to the file 'shipping_infos.csv'.");
                    } catch (IOException e) {
                        System.out.println("Could not write to file: " + e.getMessage());
                    }


                    System.out.println("The shipment was successfully added.");
                } catch (InvalidShippingDataException | NumberFormatException e) {
                    System.out.println("Error " + e.getMessage() + " This shipment information was not added.");
                }
            }
        }
    }
}