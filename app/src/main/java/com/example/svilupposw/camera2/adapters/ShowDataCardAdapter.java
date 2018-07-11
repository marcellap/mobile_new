package com.example.svilupposw.camera2.adapters;

import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.svilupposw.camera2.R;
import com.example.svilupposw.camera2.models.Rifornimento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by svilupposw on 05/04/18.
 */

public class ShowDataCardAdapter extends RecyclerView.Adapter<ShowDataCardAdapter.ShowDataViewHolder> {
    private Context ctx;
    private ArrayList<Rifornimento> values;


    public ShowDataCardAdapter(Context ctx, ArrayList<Rifornimento> data) {
        this.ctx = ctx;
        this.values = data;
    }

    @Override
    public ShowDataCardAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(this.ctx);
        View view = inflater.inflate(R.layout.show_data_list_item, parent, false);
        ShowDataViewHolder holder = new ShowDataViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ShowDataViewHolder holder, int position) {

        holder.setData(this.values.get(position), position);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class ShowDataViewHolder extends RecyclerView.ViewHolder {

        TextView nameText;
        TextView priceText;
        int pos;


        public ShowDataViewHolder(View itemView) {
            super(itemView);
            nameText = (TextView) itemView.findViewById(R.id.txtBenz);
            priceText = (TextView) itemView.findViewById(R.id.txtImp);
        }

        public void setData(Rifornimento r, int pos){
            this.nameText.setText(r.getNomeBenzinaio());
            this.priceText.setText(String.valueOf(r.getImporto()));
        }
    }

}
