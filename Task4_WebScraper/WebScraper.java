import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.FileWriter;
import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://example.com/products").get();
            Elements products = doc.select(".product"); // change according to site structure

            FileWriter csvWriter = new FileWriter("products.csv");
            csvWriter.append("Name,Price,Rating\n");

            for (Element product : products) {
                String name = product.select(".product-name").text();
                String price = product.select(".product-price").text();
                String rating = product.select(".rating").text();

                csvWriter.append(name + "," + price + "," + rating + "\n");
            }

            csvWriter.flush();
            csvWriter.close();
            System.out.println("Data saved to products.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
