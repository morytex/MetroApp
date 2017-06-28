package br.com.moryta.metroapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.moryta.metroapp.R;
import br.com.moryta.metroapp.api.APIUtils;
import br.com.moryta.metroapp.model.Line;

/**
 * Created by moryta on 26/06/2017.
 */

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.LineViewHolder> {
    private List<Line> lineList;
    private OnItemClickListener listener;

    public LineAdapter(List<Line> lineList, OnItemClickListener onItemClickListener) {
        this.lineList = lineList;
        this.listener = onItemClickListener;
    }

    @Override
    public LineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View lineLayout = inflater.inflate(R.layout.line_row
                , parent, false);
        return new LineViewHolder(lineLayout);
    }

    @Override
    public void onBindViewHolder(LineViewHolder holder, final int position) {
        Line line = lineList.get(position);

        holder.tvColor.setText(line.getColor());
        holder.tvNumber.setText(String.valueOf(line.getNumber()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(lineList.get(position));
            }
        });

        Picasso.with(holder.ivImage.getContext())
                .load(APIUtils.BASE_URL + line.getImageUrl())
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class LineViewHolder extends RecyclerView.ViewHolder {
        TextView tvColor;

        TextView tvNumber;

        ImageView ivImage;

        public LineViewHolder(View itemView) {
            super(itemView);

            tvColor = (TextView) itemView.findViewById(R.id.tvColor);
            tvNumber = (TextView) itemView.findViewById(R.id.tvNumber);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }

    public void update(List<Line> lineList) {
        this.lineList = lineList;
        notifyDataSetChanged();
    }
}
