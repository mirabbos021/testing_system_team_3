package com.company.database;

import com.company.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;


import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public interface Database {
    String MAIN_FILE="src/main/resources";
    String MAIN_USER=MAIN_FILE+"/users.json";

    static List<User> getUsers(){
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        List<User>users=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MAIN_USER))) {
            Type type=new TypeToken<List<User>>(){}.getType();
            users=gson.fromJson(reader,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    static void addUser(List<User>users){

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(MAIN_USER))) {

            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            writer.write(gson.toJson(users));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static void userToPdf(){
        try (PdfWriter pdfWriter = new PdfWriter(new File(MAIN_FILE, "users.pdf"));
             PdfDocument pdf = new PdfDocument(pdfWriter);
             Document document = new Document(pdf)) {
            Paragraph paragraph = new Paragraph("Users");
            document.add(paragraph);

            List<User> users = getUsers();

            float[] columns={15,20,20,20};
            Table table=new Table(columns);
            table.addCell("id");
            table.addCell("Full Name");
            table.addCell("Phone Number");
            table.addCell("Password");
            for (User user : users) {
                table.addCell(String.valueOf(user.getId()));
                table.addCell(user.getFullName());
                table.addCell(user.getPhoneNumber());
                table.addCell(user.getPassword());
            }
            document.add(table);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
