package com.example.administrador.agepubli;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by pali on 1/10/15.
 */
public class ProductAsyncTask extends AsyncTask<Object, Void, ArrayList<ListOpciones>> {

    public ListArrayAdapter getListArrayAdapter() {
        return listArrayAdapter;
    }


    private ListArrayAdapter listArrayAdapter;




    private ListView myListView;
    private Context mContext;

    public ProductAsyncTask(Context context, View rootView, ListView myListView) {
        this.mContext = context;
        this.rootView = rootView;
        this.myListView = myListView;
    }


    ArrayList<ListOpciones> productList;
    View rootView;
    private static final String TAG = "ProductAsyncTask";

    @Override
    protected ArrayList<ListOpciones> doInBackground(Object... params) {
        Log.i(TAG, "doing in background :) ");
        ArrayList<ListOpciones> productList = null;

        OpcionService productService = new OpcionService();
        Log.i(TAG, "ProductService instantiated .....................");
        productList = productService.getOpciones();
        Log.e(TAG, "COUNT: " + productList.size());
        return productList;
    }

    @Override
    protected void onPostExecute(ArrayList<ListOpciones> productList) {

        Log.e(TAG, "XXXXXXXXXXX: " + productList.size());


        listArrayAdapter = new ListArrayAdapter(mContext, R.layout.listview_row_layout);


        for (ListOpciones product : productList) {

            listArrayAdapter.add(product);
        }
        myListView.setAdapter(listArrayAdapter);






    }


}