package global.goit.edu.servlets;

import global.goit.edu.filereader.HTMLFileReader;
import global.goit.edu.dateTimeService.DateTimeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "")
public class GetIndexPageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String htmlIndexFilePath = context.getRealPath("/index.jsp");

        String content = DateTimeService
                .setTimeToHTMLPage(
                        HTMLFileReader.read(htmlIndexFilePath), DateTimeService.get()
                );

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(content);
        resp.getWriter().close();
    }
}
