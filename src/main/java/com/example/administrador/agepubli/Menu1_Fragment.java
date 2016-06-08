package com.example.administrador.agepubli;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrador.agepubli.R;

/**
 * Created by administrador on 31/01/15.
 */

public class Menu1_Fragment extends Fragment {
    View rootView;
    private ListView myListView;
    private String[] strListView;
    Fragment objFragment = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.menu1_layout, container, false);
        myListView = (ListView) rootView.findViewById(R.id.listViewd);
        strListView = getResources().getStringArray(R.array.Planets);
        ArrayAdapter<String> objAdapter =  new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, strListView);
        myListView.setAdapter(objAdapter);


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(),"Click ListItem Number " + position, Toast.LENGTH_LONG).show();

            //Manda a LLamar al fragment que contiene el calendario, la lista debe de actualziarse con lo que viene de al base de datos

                switch (position){
                    case 0:
                        objFragment = new Menu1_Fragment();
                        break;
                    case 1:
                        objFragment = new Menu2_Fragment();
                        break;
                    case 2:
                        objFragment = new Menu3_Fragment();
                        break;
                    case 3:
                        objFragment = new Menu4_Fragment();
                        break;
                }
                // update the main content by replacing fragments
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, objFragment)
                        .commit();

            }

        });



        return rootView;
    }
}
