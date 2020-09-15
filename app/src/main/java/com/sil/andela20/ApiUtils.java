package com.sil.andela20;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiUtils {
    private  ApiUtils () {}

    public static final String BASE_API_URL = "";
    public static final String QUERY_KEY = "q+";

    public static String buildUrl (String title){
        String complete = BASE_API_URL + QUERY_KEY + title;
        return complete;
    }

    public static String getJson (URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            InputStream stream = connection.getInputStream();

            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\\A");

            boolean hasData = scanner.hasNext();
            if (hasData){
                return scanner.next();
            }else{
                return null;
            }
        }catch (Exception e){
            Log.d("Error", e.toString());
            return null;
        }
        finally {
            connection.disconnect();
        }
    }

}
