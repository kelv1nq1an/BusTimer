package me.fattycat.kun.bustimer.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.fattycat.kun.bustimer.R;
import me.fattycat.kun.bustimer.model.StationListEntity;

/**
 * Author: Kelvinkun
 * Date: 16/7/11
 */

public class DetailStationListAdapter extends RecyclerView.Adapter<DetailStationListAdapter.DetailStationViewHolder> {

    private Context context;
    private List<StationListEntity.ResultEntity.StationEntity> stationEntityList;

    public DetailStationListAdapter(Context context) {
        this.context = context;
        this.stationEntityList = new ArrayList<>();
    }

    public void setData(List<StationListEntity.ResultEntity.StationEntity> data) {
        if (data != null) {
            this.stationEntityList = data;
        }
        notifyDataSetChanged();
    }

    public void clearData() {
        this.stationEntityList.clear();
        notifyDataSetChanged();
    }

    @Override
    public DetailStationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_station, parent, false);
        return new DetailStationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailStationViewHolder holder, int position) {
        if (position == 0) {
            holder.itemStationTop.setVisibility(View.INVISIBLE);
        } else {
            holder.itemStationTop.setVisibility(View.VISIBLE);
        }
        if (position + 1 == stationEntityList.size()) {
            holder.itemStationBottom.setVisibility(View.INVISIBLE);
        } else {
            holder.itemStationBottom.setVisibility(View.VISIBLE);
        }

        holder.itemStationName.setText(stationEntityList.get(position).getBusStationName());
    }

    @Override
    public int getItemCount() {
        return stationEntityList.size();
    }

    public class DetailStationViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_station_top)
        View itemStationTop;
        @BindView(R.id.item_station_bottom)
        View itemStationBottom;
        @BindView(R.id.item_station_name)
        TextView itemStationName;

        public DetailStationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}