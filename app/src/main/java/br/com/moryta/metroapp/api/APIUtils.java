package br.com.moryta.metroapp.api;

/**
 * Created by moryta on 26/06/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "http://10.0.75.1:3000";

    public static LineAPI getLinhaAPIVersion() {
        return RetrofitClient.getClient(BASE_URL)
                .create(LineAPI.class);
    }
}
