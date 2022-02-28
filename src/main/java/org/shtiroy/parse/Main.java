package org.shtiroy.parse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shtiroy.parse.utils.FileParse;
import org.shtiroy.parse.utils.UrlParse;
import org.shtiroy.parse.utils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    @Autowired
    private Menu menu;
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("start project");
        menu.startMenu();
        //System.out.println(UserAgent.randomUserAgent().getDescription());
        LOGGER.info("end project");
        //UrlParse urlParse = new UrlParse();
        //Object object = urlParse.methodGet("https://www.data2b.md/api/companies/1014600043319/");
        //System.out.println(object.toString());
        //FileParse fileParse = new FileParse();
        //fileParse.parseExcel("Company.xlsx");
    }
}
