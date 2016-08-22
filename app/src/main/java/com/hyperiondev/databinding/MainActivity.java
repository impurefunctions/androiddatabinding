package com.hyperiondev.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import com.hyperiondev.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
Course course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

           final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
           final Course course = new Course(binding.edtcName.getText().toString(), binding.edtcType.getText().toString());



      /*  binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cNameTV.setText(course.getCourseName());
                binding.cTypeTV.setText(course.getCourseType());
            }
        });*/
        //Set up a TextWatcher to track changes on the editText
        TextWatcher nameTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
               // binditng.setCourse(,);
                course.setCourseName(binding.edtcName.getText().toString());
                course.setCourseType(binding.edtcType.getText().toString());
                binding.setCourse(course);

            }
        };
        binding.setCourse(course);
        //Assigns A textWatcher to the EditText instantiated above
        binding.edtcType.addTextChangedListener(nameTextWatcher);

        }


}

