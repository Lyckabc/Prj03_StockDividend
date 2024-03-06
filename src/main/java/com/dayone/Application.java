package com.dayone;

import com.dayone.model.Company;
import com.dayone.model.ScrapedResult;
import com.dayone.scraper.YahooFinanceScraper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
/*
        String s = "Hello my name %s";
        String[] names = {"Green","RED", "YELLOW"};

        for (String name : names) {
            System.out.println(String.format(s, name));
        }
*/  // string format ex
/*
        try {
            Connection connection = Jsoup.connect("https://finance.yahoo.com/quote/COKE/history?period1=1677907673&period2=1709530073&interval=1mo&filter=history&frequency=1mo&includeAdjustedClose=true");
            Document document = connection.get();

            Elements eles = document.getElementsByAttributeValue("data-test", "historical-prices");
            Element ele = eles.get(0);
           // System.out.println(ele);

            Element tbody = ele.children().get(1);
            for (Element e : tbody.children()) {
                String txt = e.text();
                if (!txt.endsWith("Dividend")) {
                    continue;
                }
//                System.out.println(txt);

                String[] splits = txt.split(" ");
                String month = splits[0];
                int day = Integer.valueOf(splits[1].replace(",",""));
                int year = Integer.valueOf(splits[2]);
                String dividend = splits[3];

//                System.out.println(year + "/" + month + "/" + day + " -> " + dividend);

            }
        } catch (IOException e) {
            e.printStackTrace();;
        }
*/  // url to json data test ex
/*
        YahooFinanceScraper scraper = new YahooFinanceScraper();
        ScrapedResult scrap = scraper.scrap(Company.builder().ticker("COKE").build());
        System.out.println(scrap);
*/ // scraper static url ex
/*
        YahooFinanceScraper scraper = new YahooFinanceScraper();
        var scrap = scraper.scrapCompanyByTicker("COKE");
        System.out.println(scrap);
*/ // scraper CompanyByTicker url ex
    }
}
