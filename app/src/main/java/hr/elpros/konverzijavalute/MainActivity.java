package hr.elpros.konverzijavalute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner drop=findViewById(R.id.spinner);
        String[] tecaj = {"Srednji", "Kupovni", "Prodajni"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,tecaj);
        drop.setAdapter(ad);

        Button konvertiraj;
        konvertiraj = findViewById(R.id.convert);
        TextView swiss=findViewById(R.id.swissval);
        TextView euro=findViewById(R.id.euroval);
        TextView usd=findViewById(R.id.usaval);
        EditText hr=findViewById(R.id.hrvatski);
        konvertiraj.setOnClickListener(v -> {
            String valut=hr.getText().toString();
            Double val=Double.parseDouble(valut);
            Double val2=Double.parseDouble(valut);
            Double val3=Double.parseDouble(valut);
            String state = drop.getSelectedItem().toString();
            if(state=="Srednji")
            {
                val/=7.064035;
                usd.setText(val.toString());
                val2/=7.651569;
                swiss.setText(val2.toString());
                val3/=7.534500;
                euro.setText(val3.toString());
            }
            else if(state=="Kupovni")
            {
                val/=7.042843;
                usd.setText(val.toString());
                val2/=7.628614;
                swiss.setText(val2.toString());
                val3/=7.511897;
                euro.setText(val3.toString());
            }
            else
            {
                val/=7.085227;
                usd.setText(val.toString());
                val2/=7.674524;
                swiss.setText(val2.toString());
                val3/=7.557104;
                euro.setText(val3.toString());
            }

        });


    }

}
