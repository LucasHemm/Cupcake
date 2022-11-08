package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

@WebServlet(name = "basketServlet", value = "/basketServlet")
public class BasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
//        request.setCharacterEncoding("UTF-8");
//
//        HttpSession session = request.getSession();
//
//        Set<String> orderList = (Set<String>) session.getAttribute("orderList");
//
//        if (orderList == null) {
//            System.out.println("Listen på session scope fandtes ikke");
//            orderList = new TreeSet<>();
//        }
//
//        Set<String> orderListeReq = (Set<String>) request.getAttribute("orderListeReq");
//
//        if (orderListeReq == null) {
//            System.out.println("Listen på request scope fandtes ikke");
//            orderListeReq = new TreeSet<>();
//        }
//
//        ServletContext servletContext = getServletContext();
//        // Object stringSetContext = (Set<String>) servletContext.getAttribute("stringSetContext");
//        Set<String> stringSetContext = (Set<String>) servletContext.getAttribute("stringSetContext");
//
//        if (stringSetContext == null) {
//
//            stringSetContext = new TreeSet<>();
//
//        }
//
//       // String order = request.getParameter("order");
//
//       // orderList.add(order); //Session
//
//       // orderListeReq.add(order); //Request
//
//       // stringSetContext.add(order);
//
//        session.setAttribute("orderList", orderList);
//        session.setAttribute("antal", orderList.size());
//
//        request.setAttribute("orderListeReq", orderListeReq);
//
//        servletContext.setAttribute("stringSetContext", stringSetContext);

        request.getRequestDispatcher("WEB-INF/basket.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("WEB-INF/basket.jsp").forward(request, response);



    }
}
