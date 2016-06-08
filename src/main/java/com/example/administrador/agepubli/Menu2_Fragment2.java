package com.example.administrador.agepubli;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrador on 31/01/15.
 */

public class Menu2_Fragment2 extends Fragment {
    View rootView;
    private ListView myListView;
    private ListArrayAdapter listArrayAdapter;


    private static int colorIndex;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.menu2_layout, container, false);
        myListView = (ListView) rootView.findViewById(R.id.miLista);

        listArrayAdapter = new ListArrayAdapter(this.getActivity(), R.layout.listview_row_layout);
        myListView.setAdapter(listArrayAdapter);

        List<String[]> fruitList = readData();
        for(String[] fruitData:fruitList ) {
            String idopcion = fruitData[0];
            String opcion = fruitData[1];
            String value = fruitData[2];


            ListOpciones option = new ListOpciones(idopcion,opcion,value);
            listArrayAdapter.add(option);
        }


        return rootView;
    }

    public List<String[]> readData(){
        List<String[]> resultList = new ArrayList<String[]>();

        String[] fruit7 = new String[3];
        fruit7[0] = "1";
        fruit7[1] = "Orange";
        fruit7[2] = "47 Calories";
        resultList.add(fruit7);

        String[] fruit1 = new String[3];
        fruit1[0] = "2";
        fruit1[1] = "Cherry";
        fruit1[2] = "50 Calories";
        resultList.add(fruit1);


        String[] fruit3 = new String[3];
        fruit3[0] = "3";
        fruit3[1] = "Banana";
        fruit3[2] = "89 Calories";
        resultList.add(fruit3);

        String[] fruit4 = new String[3];
        fruit4[0] = "4";
        fruit4[1] = "Apple";
        fruit4[2] = "52 Calories";
        resultList.add(fruit4);



        return  resultList;
    }
}