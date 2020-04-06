package com.exemple.android.schoolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.exemple.android.schoolbox.ColegInfoActivity;
import com.exemple.android.schoolbox.ColegListAdapter;
import com.exemple.android.schoolbox.R;
import com.exemple.android.schoolbox.nume_list;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nume;
        String prenume;
        String email;
        String eticheta;
        int number;

        TextView addColegButton = findViewById(R.id.textView3);
        ListView nume_ListView = findViewById(R.id.ListView);
        ArrayList<nume_list> colegi_list = DataHolder.getInstance().people;
        ;

        String nou = getString(R.string.nou);
        String addClassmate = getString(R.string.AddClassmate);

        TextView buna = findViewById(R.id.bunaTextView);
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);


        if (hour >= 12 && hour <= 18) {
            buna.setText(R.string.bună);
            buna.setTextSize(43);
        }
        if (hour >= 18 && hour <= 24) {
            buna.setText(R.string.bunăSeara);
            buna.setTextSize(39);
        }
        if (hour >= 0 && hour <= 12) {
            buna.setText(R.string.bunăDimi);
            buna.setTextSize(36);
        }

        ColegListAdapter adapter1 = new ColegListAdapter(this, R.layout.list_item_layout, colegi_list);
        nume_ListView.setAdapter(adapter1);

        nume_list event_nou = new nume_list(nou, addClassmate, "", 0);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                nume = null;
                prenume = null;
                eticheta=null;
                email=null;
                number= 0;
                if (colegi_list.isEmpty()) {
                    colegi_list.add(event_nou);

                }
            } else {
                colegi_list.remove(0);
                nume = extras.getString("NumeFam");
                prenume = extras.getString("Prenume");
                email = extras.getString("Email");
                number = extras.getInt("Number");
                eticheta = extras.getString("Eticheta");
                String nume_complet = prenume + " " + nume;

                nume_list colegNou = new nume_list(nume_complet, eticheta, email, number);
                nume_list colegNouv2 = new nume_list(prenume, eticheta, email, number);

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_custom,
                        (ViewGroup) findViewById(R.id.custom_toast_container));

                TextView text = (TextView) layout.findViewById(R.id.textToast);

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,0,50);
                toast.setView(layout);

                if (prenume != null && nume != null && eticheta != null) {
                    colegi_list.add(colegNou);
                    text.setText(R.string.toast1);
                    toast.show();
                }

                else if (nume == null && eticheta != null && prenume != null) {
                    colegi_list.add(colegNouv2);
                    text.setText(R.string.toast1);
                    toast.show();
                }

                else{
                    text.setText(R.string.toast2);
                    toast.show();
                }

            }
        } else {

            nume = (String) savedInstanceState.getSerializable("NumeFam");
            prenume = (String) savedInstanceState.getSerializable("Prenume");
            eticheta = (String) savedInstanceState.getSerializable("Eticheta");
            email = (String) savedInstanceState.getSerializable("Email");
            number = (int) savedInstanceState.getSerializable("Number");
        }


        addColegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColegInfoActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });


        //TODO: Create the new classmate activity and set OnClickListener for the button to it.
    }

}