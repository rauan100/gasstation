package rauan.ferreira.gasstation.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import rauan.ferreira.gasstation.R;
import rauan.ferreira.gasstation.daos.SupplyDao;
import rauan.ferreira.gasstation.daos.VehicleDao;
import rauan.ferreira.gasstation.entities.Supply;
import rauan.ferreira.gasstation.entities.Vehicle;

public class RegisterSupplyActivity extends AppCompatActivity {

    Spinner vehicleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_suppy);

        vehicleName = findViewById(R.id.vehicles_list);

        setVehicles();

        Button btn = (Button) findViewById(R.id.addSupply);

        final EditText gasPrice = findViewById(R.id.gas_price_value);
        final EditText litters = findViewById(R.id.supply_litters_value);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Supply supply = new Supply();
                try {
                    supply.setVehicleName(vehicleName.getSelectedItem().toString());
                    supply.setGasPrice(Float.parseFloat(gasPrice.getText().toString()));
                    supply.setLitters(Float.parseFloat(litters.getText().toString()));

                    SupplyDao.create(supply);
                    finish();
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    private void setVehicles() {
        final ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Não selecionado");

        for (Vehicle vehicle : VehicleDao.getVehicles()) {
            arrayList.add(vehicle.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);

        vehicleName.setAdapter(arrayAdapter);
    }
}