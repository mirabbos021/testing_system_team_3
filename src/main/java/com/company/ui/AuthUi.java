package com.company.ui;

import com.company.database.Database;
import com.company.payload.Result;
import com.company.payload.UserDTO;
import com.company.service.UserService;
import com.company.util.ScannerUtil;

public class AuthUi {
    public static void logIn() {
        System.out.println("Enter phone number: ");
        String phone = ScannerUtil.SCANNER_STR.nextLine();
        System.out.println("Enter password : ");
        String password = ScannerUtil.SCANNER_STR.nextLine();



    }

    public static void register() {
        System.out.println("Enter Full Name: ");
        String name = ScannerUtil.SCANNER_STR.nextLine();
        while (true) {
            System.out.println("Enter phone number: ");
            String phone = ScannerUtil.SCANNER_STR.nextLine();
            if (phone.matches("[+]998\\d{9}")) {
                break;
            } else {
                System.out.println("Wrong phone format");
            }
        }
        System.out.println("Enter password: ");
        String password = ScannerUtil.SCANNER_STR.nextLine();
        while (true) {
            System.out.println("Confirm password");
            String configPassword = ScannerUtil.SCANNER_STR.nextLine();
            if (password.matches(configPassword)) break;
            else System.out.println("Enter confirm password corectly");
        }

    }
}
