package com.example.svilupposw.camera2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.svilupposw.camera2.R;
import com.example.svilupposw.camera2.models.Rifornimento;

import java.util.ArrayList;

/**
 * Created by svilupposw on 27/03/18.
 */

public class showDataAdapter extends BaseAdapter{

    private Context ctx;
    private ArrayList<Rifornimento> values;

    public showDataAdapter(Context ctx, ArrayList<Rifornimento> values) {
        this.ctx = ctx;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater li =
                    (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.show_data_list_item, null);

        }

        TextView nameText = view.findViewById(R.id.nameBenzinaio);
        TextView priceText = view.findViewById(R.id.price);

        nameText.setText(values.get(i).getNomeBenzinaio());
        priceText.setText(String.valueOf(values.get(i).getImporto()));

        return view;
    }
}
