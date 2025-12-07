package com.contact;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
    private static final String ATTR = "contacts";

    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute(ATTR) == null) {
            getServletContext().setAttribute(ATTR,
                    Collections.synchronizedList(new ArrayList<Contact>()));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            req.getRequestDispatcher("/addContact.jsp").forward(req, resp);
        } else if ("list".equals(action)) {
            req.getRequestDispatcher("/list.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if ("add".equals(req.getParameter("action"))) {
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");

            if (name != null && !name.trim().isEmpty()) {
                Contact c = new Contact(name, phone, email);
                @SuppressWarnings("unchecked")
                List<Contact> list = (List<Contact>) getServletContext().getAttribute(ATTR);
                list.add(c);
            }
            resp.sendRedirect("contacts?action=list");
        }
    }
}
