import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Parser {
    public static void main(String[] args) {
        for (int i = 1; i <69; i++) {
            Document doc = null;
            try {
                doc = Jsoup.connect("https://evolvr.com/profile/" + i + "-test/").get();
            } catch (org.jsoup.HttpStatusException e) {
                continue;
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements newsHeadlines = doc.select("#elProfileHeader h1");
            for (Element headline : newsHeadlines) {
                System.out.print(headline.text());
                System.out.print(": ");
            }
            Elements count = doc.select("#elProfileStats li");
            System.out.println(count.text() + " ");
        }
    }
}
