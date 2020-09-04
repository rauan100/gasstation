package rauan.ferreira.gasstation.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import rauan.ferreira.gasstation.R;
import rauan.ferreira.gasstation.daos.VehicleDao;
import rauan.ferreira.gasstation.entities.Vehicle;

public class RegisterVehicleActivity extends AppCompatActivity {

    private EditText name;
    private EditText vehicleId;
    private EditText vehicleColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_register);

        Intent intent = getIntent();

        Button btn = findViewById(R.id.insert);

        name = findViewById(R.id.vehicle_name);
        vehicleId = findViewById(R.id.vehicle_id);
        vehicleColor = findViewById(R.id.vehicle_color);

        final int vehicleEditId = intent.getIntExtra("vehiclePosition", -1);

        if (vehicleEditId > -1) {
            System.out.println("Teste");
            btn.setText("Editar");
            loadVehicle(vehicleEditId);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vehicle vehicle = new Vehicle();
                vehicle.setName(name.getText().toString());
                vehicle.setColor(vehicleColor.getText().toString());
                vehicle.setPlaca(vehicleId.getText().toString());

                if (vehicleEditId > -1) {
                    VehicleDao.update(vehicleEditId, vehicle);
                } else {
                    VehicleDao.create(vehicle);
                }

                finish();
            }
        });
    }

    private void loadVehicle(int position) {
        Vehicle vehicle = VehicleDao.getByPosition(position);

        name.setText(vehicle.getName());
        vehicleId.setText(vehicle.getPlaca());
        vehicleColor.setText(vehicle.getColor());
    }
}