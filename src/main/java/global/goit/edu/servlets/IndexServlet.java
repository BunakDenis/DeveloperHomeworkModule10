package global.goit.edu.servlets;

import global.goit.edu.HTMLFileReader;
import global.goit.edu.dateTimeService.DateTimeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "")
public class IndexServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = DateTimeService
                .setTimeToHTMLPage(
                        HTMLFileReader.read(new TimeServlet().htmlIndexFilePath), DateTimeService.get()
                );

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(content);
        resp.getWriter().close();

    }
}
