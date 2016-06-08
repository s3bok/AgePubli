package com.example.administrador.agepubli;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrador.util.AndroidNetworkUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrador on 31/01/15.
 */

public class Menu2_Fragment extends Fragment {
    View rootView;
    private ListView myListView;
    private ListArrayAdapter listArrayAdapter;

    final static String TAG = "MainActivity";

    private static int colorIndex;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.menu2_layout, container, false);
        myListView = (ListView) rootView.findViewById(R.id.miLista);

        AndroidNetworkUtility androidNetworkUtility = new AndroidNetworkUtility();
        if (androidNetworkUtility.isConnected(this.getActivity())) {
            Log.i(TAG, "Connected.");
            ProductAsyncTask productAsyncTaske=  new ProductAsyncTask(this.getActivity(), rootView, myListView);
            productAsyncTaske.execute(this);


            myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    ListOpciones selection = (ListOpciones) parent.getItemAtPosition(position);
                     Toast toast1 =
                            Toast.makeText(getActivity(),
                                    selection.getOption(), Toast.LENGTH_SHORT);

                    toast1.show();
                }
            });



        } else {
            Log.v(TAG, "Network not Available!");
        }



        return rootView;
    }

}

