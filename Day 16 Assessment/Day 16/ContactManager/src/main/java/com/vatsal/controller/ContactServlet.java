package com.vatsal.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import com.vatsal.dao.ContactDAO;
import com.vatsal.model.Contact;
import java.util.List;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    private ContactDAO dao = new ContactDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equals("list")) {
            List<Contact> list = dao.getAllContacts();
            req.setAttribute("contacts", list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
        else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("contact", dao.getContactById(id));
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        } 
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.delete(id);
            resp.sendRedirect("contact?action=list");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        if ("add".equals(action)) {
            dao.addContact(new Contact(name, phone, email));
        } 
        else if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.update(new Contact(id, name, phone, email));
        }

        resp.sendRedirect("contact?action=list");
    }
}
