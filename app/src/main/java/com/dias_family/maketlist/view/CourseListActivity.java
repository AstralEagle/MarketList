package com.dias_family.maketlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.ListCourse;
import com.dias_family.maketlist.controle.adapter.CourseAdapter;

public class CourseListActivity extends AppCompatActivity {

    private ListView listViewItem;
    private CourseAdapter listAdapter;

    private EditText editTextProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        listViewItem = (ListView) findViewById(R.id.list_course_list_item);
        editTextProduct = (EditText) findViewById(R.id.list_course_name_product);

        editTextProduct.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    if (editTextProduct.getText().toString().length() > 0) {
                        if (ListCourse.addItem(editTextProduct.getText().toString())) {
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

        //Onatribue l'adpter  à la ListView
        listAdapter = new CourseAdapter(this, ListCourse.getList());
        listViewItem.setAdapter(listAdapter);

        listViewItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                ListCourse.removeItem(ListCourse.getList().get(position));
                toastMsg(R.string.remove_item);
                listAdapter.notifyDataSetChanged();

                return false;
            }
        });
    }

    //Function pour afficher un Toast
    private void toastMsg(int msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}