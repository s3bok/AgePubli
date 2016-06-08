package com.example.administrador.agepubli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pali on 30/09/15.
 */
public class ListArrayAdapter extends ArrayAdapter<ListOpciones> {

    private static final String TAG = "ListArrayAdapter";
    private List<ListOpciones> opcionesList = new ArrayList<ListOpciones>();


    static class FruitViewHolder {
        TextView idOption;
        TextView option;
        TextView value;
    }


    public ListArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(ListOpciones object) {
        opcionesList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.opcionesList.size();
    }

    @Override
    public ListOpciones getItem(int index) {
        return this.opcionesList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        FruitViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listview_row_layout, parent, false);
            viewHolder = new FruitViewHolder();
            viewHolder.idOption = (TextView) row.findViewById(R.id.idOpcion);
            viewHolder.option = (TextView) row.findViewById(R.id.option);
            viewHolder.value = (TextView) row.findViewById(R.id.value);
            row.setTag(viewHolder);
        } else {
            viewHolder = (FruitViewHolder)row.getTag();
        }
        ListOpciones opcion = getItem(position);
        viewHolder.idOption.setText(opcion.getId());
        viewHolder.option.setText(opcion.getOption());
        viewHolder.value.setText(opcion.getValue());
        return row;
    }





}
