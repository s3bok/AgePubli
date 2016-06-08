package com.example.administrador.agepubli;

import android.util.Log;

import com.example.administrador.util.AndroidNetworkUtility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.client.methods.HttpGet;

import java.util.ArrayList;

/**
 * Created by pali on 1/10/15.
 */
public class OpcionService {
    private static final String TAG = "ProductService";

    private static final String PRODUCT_WEB_SERVICE_URL = "http://192.168.1.90:8080/JSONRESTfulServices/rest/products";

    public ArrayList<ListOpciones> getOpciones() {
        Log.i(TAG, "getProducts ......");
        ArrayList<ListOpciones> productList = null;
        HttpGet httpGet = new HttpGet(PRODUCT_WEB_SERVICE_URL);

        //setting header to request for a JSON response
        httpGet.setHeader("Accept", "application/json");
        AndroidNetworkUtility httpUtil = new AndroidNetworkUtility();
        try {
            String productJSONStr = httpUtil.getHttpResponse(httpGet);
            Log.d(TAG, "Response: " + productJSONStr);
            productList = convertJson(productJSONStr);
        }catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }

        return productList;
    }

    private ArrayList<ListOpciones> convertJson(String productJSONStr) {
        ArrayList<ListOpciones> productList = null;
        if (productJSONStr != null && productJSONStr.length() > 0) {
            try {
                Gson gson = new Gson();
                productList =
                        gson.fromJson(productJSONStr, new TypeToken<ArrayList<ListOpciones>>() {
                        }.getType());
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}
