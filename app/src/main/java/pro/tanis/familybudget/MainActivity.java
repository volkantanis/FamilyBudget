package pro.tanis.familybudget;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    FireStore fireStore = new FireStore();

    Integer priceM = 0;
    Integer priceY = 0;
    String category,subCategory,description;

    AutoCompleteTextView act_category,act_sub_category,act_description,act_price_m,act_price_y;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         act_category  = findViewById(R.id.actCategory);
         act_sub_category  = findViewById(R.id.actSubCategory);
         act_description  = findViewById(R.id.actDescription);
         act_price_m  = findViewById(R.id.actPriceM);
         act_price_y  = findViewById(R.id.actPriceY);

        Button save_button = findViewById(R.id.buttonSave);


        clearText();



        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save();






















            }
        });


















    }


    public void save(){




        category = act_category.getText().toString();
        subCategory = act_sub_category.getText().toString();
        description = act_description.getText().toString();





        priceM = makeInteger(act_price_m.getText().toString());
        priceY = makeInteger(act_price_y.getText().toString());





        fireStore.AddFire(this,category,subCategory,description,priceM,priceY);



        act_category.setText("");
        act_sub_category.setText("");
        act_description.setText("");
        act_price_m.setText("");
        act_price_y.setText("");

    }

    private Integer makeInteger(String s) {
        Integer myInt = 0;

        if (TextUtils.isEmpty(s)){

        }
        else{
            myInt = Integer.parseInt(s);
        }

        return myInt;


    }

    public void clearText(){

        act_category.setText("");
        act_sub_category.setText("");
        act_description.setText("");
        act_price_m.setText("");
        act_price_y.setText("");
    }


}
