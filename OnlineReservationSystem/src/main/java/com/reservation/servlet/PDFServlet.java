package com.reservation.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int pnr = Integer.parseInt(req.getParameter("pnr"));

        res.setContentType("application/pdf");

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, res.getOutputStream());

            doc.open();

            doc.add(new Paragraph("===== Train Ticket ====="));
            doc.add(new Paragraph("PNR: " + pnr));
            doc.add(new Paragraph("Status: Confirmed"));
            doc.add(new Paragraph("Thank you for booking!"));

            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}