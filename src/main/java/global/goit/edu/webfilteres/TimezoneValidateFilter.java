package global.goit.edu.webfilteres;

import global.goit.edu.filereader.HTMLFileReader;
import global.goit.edu.dateTimeService.DateTimeService;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.ZoneId;
import java.util.Objects;

@WebFilter(value = "/time")
public class TimezoneValidateFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        ServletContext context = getServletContext();
        String htmlIndexFilePath = context.getRealPath("/index.jsp");

        String contentOfHtmlFile = HTMLFileReader.read(htmlIndexFilePath);
        String timezone = req.getParameter("timezone");

        if (Objects.isNull(timezone)) {
            String content = DateTimeService
                    .setTimeToHTMLPage(
                            contentOfHtmlFile, DateTimeService.get()
                    );

            res.setContentType("text/html; charset=utf-8");
            res.getWriter().write(content);
            res.getWriter().close();
        } else {
            timezone = DateTimeService.formatTimeZone(timezone);

            try {
                ZoneId zoneId = ZoneId.of(timezone);
            } catch (DateTimeException e) {
                res.setStatus(404);
                res.setContentType("text/html; charset=utf-8");
                String content = DateTimeService
                        .setTimeToHTMLPage(
                                contentOfHtmlFile, "Invalid timezone"
                        );

                res.getWriter().write(content);
                res.getWriter().close();
            }

            chain.doFilter(req, res);
        }
    }
}
