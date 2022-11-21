package com.company.ui;

import com.company.util.ScannerUtil;

public class MainUi {
    public static void main(String[] args) {
        while (true){
            System.out.println("1. Login // 2. Register // 0.Exit");
            int num = ScannerUtil.SCANNER_NUM.nextInt();

            if (num == 0) break;
            switch (num){
                case 1->{AuthUi.logIn();}
                case 2->{AuthUi.register();}
            }
        }
    }
}
