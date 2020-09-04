package rauan.ferreira.gasstation.activies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import rauan.ferreira.gasstation.R;
import rauan.ferreira.gasstation.adpaters.SupplyAdapter;

public class ListSuppliesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SupplyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_supplies);

        Button btnAdd = findViewById(R.id.add_supply);

        final Intent supply = new Intent(this, RegisterSupplyActivity.class);

        recyclerView = findViewById(R.id.supplies_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new SupplyAdapter();
        recyclerView.setAdapter(mAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(supply, RESULT_CANCELED);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mAdapter.notifyDataSetChanged();
    }
}