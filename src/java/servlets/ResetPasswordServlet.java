package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author Raymond
 */
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uuid = request.getParameter("uuid");

        if (uuid != null) {
            request.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        AccountService as = new AccountService();
        switch (action) {
            case "reset":
                String email = request.getParameter("email");
                String path = getServletContext().getRealPath("/WEB-INF");
                String url = request.getRequestURL().toString();
                as.resetPassword(email, path, url);
                String message = "Check your email for the link for setting a new password.";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
                break;
            case "newpassword":
                String newPassword = request.getParameter("newpassword");
                String uuid = request.getParameter("uuid");
                getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
                break; 
        }
    }

}
