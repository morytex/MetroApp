package br.com.moryta.metroapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.moryta.metroapp.adapter.LineAdapter;
import br.com.moryta.metroapp.adapter.OnItemClickListener;
import br.com.moryta.metroapp.api.APIUtils;
import br.com.moryta.metroapp.api.LineAPI;
import br.com.moryta.metroapp.model.Line;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvLines;

    private LineAdapter lineAdapter;

    private LineAPI lineAPI;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 100: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    loadData();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvLines = (RecyclerView) findViewById(R.id.rvLines);

        lineAdapter = new LineAdapter(new ArrayList<Line>(), new OnItemClickListener() {
            @Override
            public void onItemClick(Line item) {
                Toast.makeText(getApplicationContext(), item.getColor(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLines.setLayoutManager(layoutManager);
        rvLines.setHasFixedSize(true);
        rvLines.setAdapter(lineAdapter);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET}, 100);
        } else {
            loadData();
        }
    }

    private void loadData() {
        lineAPI = APIUtils.getLinhaAPIVersion();
        lineAPI.getAll().enqueue(new Callback<List<Line>>() {
            @Override
            public void onResponse(Call<List<Line>> call, Response<List<Line>> response) {
                if (response.isSuccessful()) {
                    lineAdapter.update(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Line>> call, Throwable t) {

            }
        });
    }
}
