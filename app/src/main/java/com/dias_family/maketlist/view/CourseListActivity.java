package com.dias_family.maketlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.dias_family.maketlist.R;
import com.dias_family.maketlist.controle.ListCourse;
import com.dias_family.maketlist.model.Item;

public class CourseListActivity extends AppCompatActivity {

    private ListView listViewItem;
    private ArrayAdapter listAdapter;

    private EditText editTextProduct;
    private Button buttonAddproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        listViewItem = (ListView) findViewById(R.id.list_course_list_item);
        editTextProduct = (EditText) findViewById(R.id.list_course_name_product);
        buttonAddproduct = (Button) findViewById(R.id.list_couse_button_product);

        buttonAddproduct.setEnabled(false);
        editTextProduct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                buttonAddproduct.setEnabled(!editable.toString().isEmpty());
            }
        });
        buttonAddproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ListCourse.addItem(editTextProduct.getText().toString())){
                    listAdapter.notifyDataSetChanged();
                    toastMsg(R.string.adding_item);
                    //affichage list
                }else{
                    toastMsg(R.string.adding_error);
                }
            }
        });

        //Onatribue l'adpter  à la ListView
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListCourse.getList());
        listViewItem.setAdapter(listAdapter);

    }

    //Function pour afficher un Toast
    private void toastMsg(int msg){
        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        toast.show();
    }
}