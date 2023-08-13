package utils;

import models.Sneaker;
import services.SneakerService;

import java.io.*;
import java.util.List;

import static services.SneakerService.inventory;

public class CSVUtils {
    private static final int HEADER_LINE = 1;

    private static final char DEFAULT_SEPARATOR = ',';
    public static final String csvFile = "/Users/dima/Projects/Product-Inventory-Lab/Sneaker.csv";

    public static void writeLine(Writer w, List<String> values) throws IOException {
        boolean first = true;
        StringBuilder sb = new StringBuilder();

        for (String value : values) {
            if (!first) {
                sb.append(DEFAULT_SEPARATOR);
            }
            sb.append(value);
            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }

    public static void writeSneakersToCSV(String csvFilePath, List<Sneaker> sneakers) {
        try (FileWriter writer = new FileWriter(csvFilePath)) {
            writeLine(writer, List.of("ID", "Name", "Brand", "Sport", "Size", "Quantity", "Price"));

            for (Sneaker s : sneakers) {
                List<String> list = List.of(
                        String.valueOf(s.getId()),
                        s.getName(),
                        s.getBrand(),
                        s.getSport(),
                        String.valueOf(s.getSize()),
                        String.valueOf(s.getQty()),
                        String.valueOf(s.getPrice())
                );

                CSVUtils.writeLine(writer, list);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadData() {
        // (1)
        // String csvFile = csvFile;
        String line = "";
        String csvSplitBy = ",";

        // (2)

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header line
            br.readLine();

            SneakerService sneakerService = new SneakerService();
            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                String name = beer[1];
                String brand = beer[2];
                String sport = beer[3];
                double size = Double.parseDouble(beer[4]);
                int qty = Integer.parseInt(beer[5]);
                float price = Float.parseFloat(beer[6]);

                // (5)
                sneakerService.create(name, brand, sport, size, qty, price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
