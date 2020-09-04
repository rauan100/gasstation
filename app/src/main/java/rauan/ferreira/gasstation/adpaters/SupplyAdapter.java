package rauan.ferreira.gasstation.adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import rauan.ferreira.gasstation.R;
import rauan.ferreira.gasstation.daos.SupplyDao;
import rauan.ferreira.gasstation.viewHolders.SupplyViewHolder;

public class SupplyAdapter extends RecyclerView.Adapter<SupplyViewHolder> {
    @NonNull
    @Override
    public SupplyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SupplyViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_supply_view, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SupplyViewHolder holder, final int position) {
        holder.vehicleName.setText(SupplyDao.getByPosition(position).getVehicleName());
        holder.gasPrice.setText(Float.toString(SupplyDao.getByPosition(position).getGasPrice()));
        holder.litters.setText(Float.toString(SupplyDao.getByPosition(position).getLitters()));
        holder.total.setText(Float.toString(SupplyDao.getByPosition(position).getTotal()));
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItem(position);
            }
        });
    }

    private void deleteItem(int position) {
        SupplyDao.delete(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return SupplyDao.total();
    }
}
