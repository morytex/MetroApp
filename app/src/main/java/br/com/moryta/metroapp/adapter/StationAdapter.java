package br.com.moryta.metroapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.moryta.metroapp.R;
import br.com.moryta.metroapp.model.Station;

/**
 * Created by moryta on 26/06/2017.
 */

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationViewHolder> {
    private List<Station> stationList;

    public StationAdapter(List<Station> stationList) {
        this.stationList = stationList;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class StationViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvAddress;

        public StationViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
        }
    }

    public void update(List<Station> stationList) {
        this.stationList = stationList;
        notifyDataSetChanged();
    }
}
