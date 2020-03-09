package ru.job4j;


import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParserSQL {
    private static final Logger log = Logger.getLogger(ParserSQL.class);

    public static void main(String[] args) throws Throwable {
        VacancyStore store = new VacancyStore();
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job")
                .get();

        Elements listNews = doc.select("a[href]");


        for (Element element : listNews) {
            String name = element.text();
            String text = String.valueOf(element.text("msgBody"));
            String link = element.attr("href");

            store.add(new Vacancy(name, text, link));
        }

        store.findAll().forEach(System.out::println);

    }
}


