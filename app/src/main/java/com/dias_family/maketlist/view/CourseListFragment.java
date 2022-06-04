package com.dias_family.maketlist.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.ListCourse;
import com.dias_family.maketlist.controle.adapter.CourseAdapter;


public class CourseListFragment extends Fragment {

    private ListView listViewItem;
    private EditText editTextProduct;

    private CourseAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);

        listViewItem = (ListView) view.findViewById(R.id.list_course_list_item);
        editTextProduct = (EditText) view.findViewById(R.id.list_course_name_product);

        editTextProduct.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    if (editTextProduct.getText().toString().length() > 0) {
                        if (ListCourse.addItem(editTextProduct.getText().toString(),getContext())) {
                            listAdapter.notifyDataSetChanged();
                            toastMsg(R.string.adding_item);
                            editTextProduct.setText(null);
                            //affichage list

                        } else {
                            toastMsg(R.string.adding_error);
                            return true;
                        }
                    }else{
                        toastMsg(R.string.error_item_name);
                        return true;
                    }
                }
                return false;

            }
        });

        //On atribue l'adpter  à la ListView
        listAdapter = new CourseAdapter(this.getContext(), ListCourse.getList());
        listViewItem.setAdapter(listAdapter);

        listViewItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                ListCourse.removeItem(ListCourse.getList().get(position),getContext());
                toastMsg(R.string.remove_item);
                listAdapter.notifyDataSetChanged();

                return false;
            }
        });

        return view;

    }
    private void toastMsg(int msg) {
        Toast toast = Toast.makeText(this.getContext(), msg, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void onResume(){
        super.onResume();
        listAdapter.notifyDataSetChanged();
    }
}