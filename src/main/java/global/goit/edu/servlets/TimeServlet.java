package global.goit.edu.servlets;

import global.goit.edu.dateTimeService.DateTimeService;
import global.goit.edu.filereader.HTMLFileReader;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "time-servlet", value = "/time")
public class TimeServlet extends HttpServlet {
    public String htmlIndexFilePath;
    private String contentOfHtmlFile;

    @Override
    public void init() throws ServletException {
        try {
            // Get the real path of the index.jsp file
            ServletContext context = getServletContext();
            htmlIndexFilePath = context.getRealPath("/index.jsp");

            contentOfHtmlFile = HTMLFileReader.read(htmlIndexFilePath);
        } catch (IOException e) {
            contentOfHtmlFile = "HTML file not found";
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String timeParameter = req.getParameter("timezone");
        String dateTime = DateTimeService.get(timeParameter);
        String content = DateTimeService.setTimeToHTMLPage(contentOfHtmlFile, dateTime);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(content);
        resp.getWriter().close();
    }
}