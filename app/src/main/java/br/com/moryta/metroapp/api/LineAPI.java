package br.com.moryta.metroapp.api;

import java.util.List;

import br.com.moryta.metroapp.model.Line;
import br.com.moryta.metroapp.model.Station;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by moryta on 26/06/2017.
 */

public interface LineAPI {
    @GET("/linhas")
    Call<List<Line>> getAll();

    @GET("/linhas/{line}")
    Call<List<Station>> getLineStations(@Path("line") String line);
}
