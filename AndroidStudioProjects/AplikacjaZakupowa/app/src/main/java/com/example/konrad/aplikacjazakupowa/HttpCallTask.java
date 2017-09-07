package com.example.konrad.aplikacjazakupowa;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 27.07.2017.
 */

class HttpCallTask extends AsyncTask<Void, Void, List<Currencies>> {
    private static final String CODE = "code";
    private static final String CURRENCY = "currency";
    private static final String MID = "mid";
    private static final String GET = "GET";

    @Override
    protected List<Currencies> doInBackground(Void... params) {
        try {
            //tabele, ktore rozpatrujemy
            String[] tables = {"a", "b"};
            //iterujemy przez tablice tabel
            List<String> result = new ArrayList<>();
            for (String table : tables) {
                //tworzymy żądanie
                URL url = null;

                url = new URL("http://api.nbp.pl/api/exchangerates/tables/" + table + "/?format=json");
                //rzutujemy url connection na HTTP
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                //wybiramy metodę żądania HTTP
                http.setRequestMethod(GET);
                //wysyłamy żądanie
                http.connect();
                //sprawdzamy odpowiedź
                int responseCode = http.getResponseCode();
                if (responseCode == 200) { //jeżeli ok TO:
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(http.getInputStream()));
                    String line = null;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
//                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    JSONArray jsonArray = new JSONArray(stringBuilder.toString());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = (JSONObject) jsonArray.get(i);
                        JSONArray ratesArray = (JSONArray) obj.get("rates");
                        List<Currencies> preParse = new ArrayList<>();
                        for (int x = 0; x < ratesArray.length(); x++) {
                            JSONObject o = (JSONObject) ratesArray.get(x);
//                            preParse.add(x, o.get(CODE).toString());


                            preParse.add(x, new Currencies(o.get(CURRENCY).toString(), o.get(CODE).toString(), (double) o.get(MID)));

//                            List<String> postParse;
//                            Type type = new TypeToken<List<String>>(){}.getType();
//                            Gson gson = new GsonBuilder()
//                                    .setLenient()
//                                    .create();
//                            postParse = gson.fromJson(stringBuilder.toString(), type);

                        }
//                        CurrenciesAdapter currenciesAdapter = new CurrenciesAdapter(preParse);

                        return preParse;
                    }

                } else {
                    System.out.println("tabla " + table + " nie obsluzona");
                }
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}












































//    /**
//     * @param stringBuilder
//     */
//    private List<String> parse(StringBuilder stringBuilder) throws JSONException {
//        //PARSUJEMY jsona ze stringa do mapy
//        List<String> codesFromSingleTable = new ArrayList<>();
//        JSONArray jsonArray = new JSONArray(stringBuilder.toString());
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject obj = (JSONObject) jsonArray.get(i);
//            JSONArray ratesArray = (JSONArray) obj.get("rates");
//            for (int x = 0; x < ratesArray.length(); x++) {
//                JSONObject o = (JSONObject) ratesArray.get(x);
//                codesFromSingleTable.add(o.get(CODE).toString());
//            }
//        }
//        return codesFromSingleTable;
//    }
// align parent right i left
// przyciski u gory do prawej