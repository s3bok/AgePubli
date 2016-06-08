package com.example.administrador.agepubli;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by administrador on 31/01/15.
 */
public class Menu4_Fragment extends Fragment {
    View rootView;

    private ListView listView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.menu4_layout, container, false);


        listView = (ListView) rootView.findViewById(R.id.list);
        List<Map> list = new ArrayList<Map>();


        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < 10; i++){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("userIcon", "jjk");
            map.put("username", "Shen");
            map.put("usertext", "This is a simple sample for SimpleAdapter");
            fillMaps.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), fillMaps,
                R.layout.item, new String[] { "userIcon", "username", "usertext" },
                new int[] { R.id.userIcon, R.id.username, R.id.usertext });

        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Toast toast1 =
                        Toast.makeText(getActivity(),
                                parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT);

                toast1.show();
            }
        };
        listView.setOnItemClickListener(listener);


        return rootView;
    }


}
