package rauan.ferreira.gasstation.adpaters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import rauan.ferreira.gasstation.R;
import rauan.ferreira.gasstation.activies.RegisterVehicleActivity;
import rauan.ferreira.gasstation.daos.VehicleDao;
import rauan.ferreira.gasstation.viewHolders.CardViewHolder;

public class VehicleAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private FragmentActivity context;

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_car_view, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, final int position) {
        holder.name.setText(VehicleDao.getByPosition(position).getName());
        holder.placa.setText(VehicleDao.getByPosition(position).getPlaca());
        holder.color.setText(VehicleDao.getByPosition(position).getColor());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItem(position);
            }
        });
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editItem(position);
            }
        });
    }

    public void setContext(FragmentActivity context) {
        this.context = context;
    }

    private void deleteItem(int position) {
        VehicleDao.delete(position);
        notifyDataSetChanged();
    }

    private void editItem(int position) {
        final Intent vehicle = new Intent(context, RegisterVehicleActivity.class);
        vehicle.putExtra("vehiclePosition", position);
        context.startActivityForResult(vehicle, Activity.RESULT_CANCELED);
    }

    @Override
    public int getItemCount() {
        return VehicleDao.total();
    }
}
