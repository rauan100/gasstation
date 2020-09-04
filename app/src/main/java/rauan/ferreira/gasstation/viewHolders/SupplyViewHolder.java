package rauan.ferreira.gasstation.viewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import rauan.ferreira.gasstation.R;

public class SupplyViewHolder extends RecyclerView.ViewHolder {

    public TextView vehicleName;
    public TextView gasPrice;
    public TextView litters;
    public TextView total;
    public ImageButton btnDelete;

    public SupplyViewHolder(View itemView) {
        super(itemView);
        vehicleName = itemView.findViewById(R.id.supply_vehicle_name_view);
        gasPrice = itemView.findViewById(R.id.supply_gas_price_view);
        litters = itemView.findViewById(R.id.supply_litters_view);
        total = itemView.findViewById(R.id.supply_total_amount_view);
        btnDelete = itemView.findViewById(R.id.deleteSupply);
    }
}
