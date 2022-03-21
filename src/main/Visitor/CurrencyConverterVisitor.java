package visitor;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

import Reservation.Reservation;

/** CONVERTING FROM EURO ALWAYS */
public class CurrencyConverterVisitor implements Visitor {

    public static void main(String[] args) {
        HashMap<Integer, String> currencyCode = new HashMap<Integer, String>();
        String fromCode = "EUR";
        String toCode;
        double amount = 50.0;

        int to;
        currencyCode.put(1, "USD");
        currencyCode.put(2, "GBP");
        fromCode = "EUR";

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the currency code \n1.USD\n2:GBP");
        to = sc.nextInt();

        while (to < 1 || to > 2) {
            System.out.println("Enter a valid currency code \n1.USB\n2:GBP");
            to = sc.nextInt();
        }

        toCode = currencyCode.get(to);

        try {
            sendHttpRequest(toCode, fromCode, amount);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }

    public void visit(Reservation reservation) {
        // currencyCode.put(1, "USD");
        // currencyCode.put(2, "GBP");
        // fromCode = "EUR";

        // Scanner sc = new Scanner(System.in);

        // System.out.println("Enter the currency code \n1.USD\n2:GBP");
        // to = sc.nextInt();

        // while (to < 1 || to > 2) {
        // System.out.println("Enter a valid currency code \n1.USB\n2:GBP");
        // to = sc.nextInt();
        // }

        // toCode = currencyCode.get(to);

        // try {
        // sendHttpRequest(toCode, fromCode);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // sc.close();
    }

    private static void sendHttpRequest(String toCode, String fromCode, Double amount) throws IOException {

        DecimalFormat f = new DecimalFormat("##.##");

        String GET_URL = "http://api.exchangeratesapi.io/v1/latest?access_key=8a5f8ba3848b3465acc60e4716b329ec&base="
                + toCode + "&symbols=" + fromCode;
        URL url = new URL(GET_URL);

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObj = new JSONObject(response.toString());
            Double exchangeRate = jsonObj.getJSONObject("rates").getDouble(fromCode);
            System.out.println(f.format(amount) + fromCode + " = " + f.format(amount / exchangeRate) + toCode);
        } else {
            System.out.println("GET request failed");
        }
    }
}
