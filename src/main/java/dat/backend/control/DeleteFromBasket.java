package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Basket;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteFromBasket", value = "/deleteFromBasket")
public class DeleteFromBasket extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        int cupcakeId = Integer.parseInt(request.getParameter("cupcakeId"));
        basket.getCupcakeArrayList().remove(cupcakeId);
        int counter = 0;
        for(Cupcake c : basket.getCupcakeArrayList()){
            c.setCupcakeId(counter);
                    counter++;
        }
        String msg = "Cupcake ordre slettet!";
        request.setAttribute("msg",msg);

        if(basket.getCupcakeArrayList().size() == 0){
            AddToBasket.setCupcakeId(0);
        }

        int totalPrice = basket.calcTotalprice();
        session.setAttribute("totalPrice",totalPrice);
        request.getRequestDispatcher("WEB-INF/basket.jsp").forward(request, response);



    }
}
