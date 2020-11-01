import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setRequestProperty("X-Random-Header", "Random-Value");
            connection.setRequestProperty("Authorization", "Random-Value");
            connection.setDoInput(true);
            connection.connect();

            int responseCode = connection.getResponseCode();

            System.out.println("=============================");
            System.out.println("HEADERS");
            System.out.println("=============================");
            for (Map.Entry<String, List<String>> e : connection.getHeaderFields().entrySet()) {
                System.out.println(e);
            }
            System.out.println();
            System.out.println("=============================");
            System.out.println("RESPONSE BODY");
            System.out.println("=============================");
            if (responseCode == 200) {
                System.out.println(readStream(connection.getInputStream()));
            } else {
                System.out.println(readStream(connection.getErrorStream()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readStream(InputStream in) throws Exception {
        if (in == null) {
            return "";
        }

        try (BufferedReader r = new BufferedReader(new InputStreamReader(in))) {
            String line;
            StringBuilder b = new StringBuilder();
            while ((line = r.readLine()) != null) {
                b.append(line);
                b.append("\n");
            }

            return b.toString();
        }
    }
}
