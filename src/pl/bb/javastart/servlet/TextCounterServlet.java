package pl.bb.javastart.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/counter")
public class TextCounterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String tekst = request.getParameter("tekst");
        int character = tekst.length();



        String[] words = tekst.split(" ");
        byte[] byteText = tekst.getBytes();
        byte[] rewerstext = new byte[byteText.length];


        int lengthWithoutSpace = tekst.replace(" ", "").length();

        
        for (int i = 0; i < byteText.length; i++) {
            rewerstext[i] = byteText[byteText.length - i - 1];
        }

        boolean palindrom = Arrays.equals(byteText, rewerstext);

        writer.println("Ilość słów: " + words.length);
        writer.println("Ilość znaków: " + character);
        writer.println("Ilość znaków bez spacji: " + lengthWithoutSpace);
        writer.println("Palindrom: " + palindrom);

    }
}
