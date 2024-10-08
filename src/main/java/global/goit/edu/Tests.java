package global.goit.edu;


import java.io.IOException;

public class Tests {

    public static void main(String[] args) throws IOException {

        String read = HTMLFileReader.read("src/main/webapp/index.jsp");
        StringBuilder stringBuilder = new StringBuilder(read);
        stringBuilder.replace(stringBuilder.indexOf("h3") + 3, stringBuilder.indexOf("/h3") - 1, "Hello");
        System.out.println(stringBuilder);
        //System.out.println(DateTimeService.setTimeToHTMLPage(read, "Hello World!"));

/*        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        ZoneOffset offset = ZonedDateTime.now().getOffset();
        System.out.println(offset);
        String formatDate = dateTime.format(pattern) + " UTC" + offset.toString();

        System.out.println(formatDate);

        try {
            String read = HTMLFileReader
                    .read("D:\\Java\\IDEProjects\\Developer\\DevHomeworkModule10\\app\\src\\main\\webapp\\index.jsp");

            StringBuilder result = new StringBuilder(read);

            result.replace(result.indexOf("[T"), (result.indexOf("e]") + 2), formatDate);

            //System.out.println(result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}
