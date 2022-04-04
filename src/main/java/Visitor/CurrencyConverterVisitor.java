package Visitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

import Reservation.Reservation;
import Reservation.ReservationFactory;

import org.json.JSONException;
import org.json.JSONObject;

/** CONVERTING FROM EURO ALWAYS */
public class CurrencyConverterVisitor implements Visitor {

    public CurrencyConverterVisitor() {

    }

    public void visit(ReservationFactory reservationFactory) {
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
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sc.close();
    }

    private static void sendHttpRequest(String toCode, String fromCode, Double amount)
            throws IOException, JSONException {

        DecimalFormat f = new DecimalFormat("##.##");

        String GET_URL = "https://free.currconv.com/api/v7/convert?q=" + fromCode + "_" + toCode
                + "&compact=ultra&apiKey=0b3396e0a286dc202ca5";
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

            String fullCode = fromCode + "_" + toCode;

            Double exchangeRate = jsonObj.getDouble(fullCode);
            System.out.println(f.format(exchangeRate * amount));
        } else {
            System.out.println("GET request failed");
        }
    }
}
