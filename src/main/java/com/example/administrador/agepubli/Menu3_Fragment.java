package com.example.administrador.agepubli;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

import java.util.Date;


/**
 * Created by administrador on 31/01/15.
 */

public class Menu3_Fragment extends Fragment {
    View rootView;
    private ListView myListView;
    CalendarView calendarView;
    private String[] strListView = new String[] { "Purueba","test","Probe","QUE sale","Juan","Amaury","Prisci", "Nina"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.menu3_layout, container, false);
        calendarView = (CalendarView) rootView.findViewById(R.id.calendario);
        myListView = (ListView) rootView.findViewById(R.id.listViewd);





        //Click en el calendario

        calendarView.setOnDateChangeListener(new OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {


                ArrayAdapter<String> objAdapter =  new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strListView);
                myListView.setAdapter(objAdapter);
                
                Toast.makeText(getActivity(), ""+dayOfMonth,Toast.LENGTH_SHORT).show();// TODO Auto-generated method stub

            }
        });

        return rootView;
    }

}
