package com.dias_family.maketlist.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.ListCourse;
import com.dias_family.maketlist.controle.adapter.ItemListAdapter;

public class ItemListFragment extends Fragment {

    private ListView listViewItem;
    private ItemListAdapter itemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        listViewItem = view.findViewById(R.id.list_item_list_item);

        itemAdapter = new ItemListAdapter(this.getContext());
        listViewItem.setAdapter(itemAdapter);

        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListCourse.addItem(itemAdapter.getItem(position).getItemName());
            }
        });


        return view;
    }

    public void onResume() {
        super.onResume();
        itemAdapter.notifyDataSetChanged();
    }
}