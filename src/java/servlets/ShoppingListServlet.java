package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAll(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAll(request,response);
    }
    
    private void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action =  "" + request.getParameter("action");
        String jspTo;
        switch (action) {
            case "add":
                ((ArrayList<String>)session.getAttribute("list")).add(request.getParameter("item"));
                jspTo = "shoppingList";
                break;
            case "delete":
                String index = request.getParameter("radioList");
                request.setAttribute("message",
                    (index != null)?"You deleted " + ((ArrayList<String>)session.getAttribute("list")).remove(Integer.parseInt(index)) + " from the list":
                    "Please Select an Item to Remove First");
                jspTo = "shoppingList";
                break;
            case "register":
                String username = request.getParameter("username");
                if (username==null || username.isEmpty()) {
                    request.setAttribute("message", "Please Enter a Username");
                    jspTo = "register";
                }
                else {
                    session.setAttribute("username", username);
                    session.setAttribute("list", new ArrayList<>());
                    jspTo = "shoppingList";
                }
                break;
            case "logout":
                session.invalidate();
                request.setAttribute("message", "Logged Out");
                jspTo = "register";
                break;
            default:
                if(session.getAttribute("username")==null)
                    jspTo = "register";
                else
                    jspTo = "shoppingList";
        }
        getServletContext().getRequestDispatcher("/WEB-INF/"+jspTo+".jsp").forward(request, response);
    }
}
