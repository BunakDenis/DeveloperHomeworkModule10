package global.goit.edu.servlets;

import global.goit.edu.dateTimeService.DateTimeService;
import global.goit.edu.HTMLFileReader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "time-servlet", value = "/time")
public class TimeServlet extends HttpServlet {
    public String htmlIndexFilePath = "index.jsp";
    //public String htmlIndexFilePath = "D:\\Java\\IDEProjects\\Developer\\DeveloperHomeworkModule10\\src\\main\\webapp\\index.jsp";
    private String contentOfHtmlFile;

    @Override
    public void init() throws ServletException {
        System.out.println("Init TimeServlet");
        try {
            contentOfHtmlFile = HTMLFileReader.read(htmlIndexFilePath);
        } catch (IOException e) {
            contentOfHtmlFile = "HTML file not found";
        }
        System.out.println("contentOfHtmlFile in init - " + contentOfHtmlFile);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String timeParameter = req.getParameter("timezone");
        String dateTime = DateTimeService.get(timeParameter);
        System.out.println("contentOfHtmlFile in service - " + contentOfHtmlFile);
        String content = DateTimeService.setTimeToHTMLPage(contentOfHtmlFile, dateTime);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(content);
        resp.getWriter().close();
    }
}
