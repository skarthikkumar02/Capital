package com.country;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Country {
    private static final Logger logger = Logger.getLogger(Country.class.getName());
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while(true) {
            //accept the inputs from the user
            String fullNameOrCode = scan.nextLine().trim();
            //end the code run on receiving an empty string
            if(fullNameOrCode.isEmpty()) {
                break;
            }
            //log the results for user input
            GetCapitalUtils getCapitalUtils = new GetCapitalUtils();
            logger.log(Level.INFO, getCapitalUtils.getCapital(fullNameOrCode).toString());
        }
    }
}
