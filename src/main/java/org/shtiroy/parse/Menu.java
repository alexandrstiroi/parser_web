package org.shtiroy.parse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shtiroy.parse.infobase.entity.Company;
import org.shtiroy.parse.infobase.repository.CompanyRepository;
import org.shtiroy.parse.infobase.service.InfoBaseService;
import org.shtiroy.parse.utils.FileParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {
    private static final Logger LOGGER = LogManager.getLogger(Menu.class.getName());
    @Autowired
    private InfoBaseService infoBaseService;

    public void startMenu(){
        LOGGER.info("start main menu");
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                System.out.println("Menu");
                System.out.println("1. start parse InfoBase");
                System.out.println("2. start parse InfoBase json");
                System.out.println("0. exit");
                System.out.print("Insert menu number ");
                String insertStr = scanner.next();
                int number = -1;
                try {
                    number = Integer.parseInt(insertStr);
                } catch (NumberFormatException e) {
                    LOGGER.error(e.getMessage());
                }
                switch (number) {
                    case 0:
                        System.out.println("insert 0");

                        return;
                    case 1:
                        if (infoBaseService.startParseFile("Company.xlsx")) {
                            LOGGER.info("saved companies from file");
                        } else {
                            LOGGER.info("error saved companies from file");
                        }
                        break;
                    case 2:
                        infoBaseService.getJson(3);
                        break;
                    default:
                        System.out.println("Error number insert");
                        break;
                }
            } catch (InputMismatchException ex){
                LOGGER.error(ex.getMessage());
            }
        }
    }
}
