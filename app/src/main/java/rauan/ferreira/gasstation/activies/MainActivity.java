package rauan.ferreira.gasstation.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import rauan.ferreira.gasstation.R;
import rauan.ferreira.gasstation.activies.ListSuppliesActivity;
import rauan.ferreira.gasstation.activies.ListVehiclesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVehicleView = findViewById(R.id.open_vehicle_view);
        Button btnSupplyView = findViewById(R.id.open_supply_view);

        final Intent supplyIntent = new Intent(this, ListSuppliesActivity.class);
        final Intent vehicleIntent = new Intent(this, ListVehiclesActivity.class);

        btnVehicleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(vehicleIntent);
            }
        });

        btnSupplyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(supplyIntent);
            }
        });
    }
}