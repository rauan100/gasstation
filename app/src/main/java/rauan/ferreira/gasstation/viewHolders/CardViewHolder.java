package rauan.ferreira.gasstation.viewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import rauan.ferreira.gasstation.R;

public class CardViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView color;
    public TextView placa;
    public ImageButton btnEdit;
    public ImageButton btnDelete;

    public CardViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.vehicle_name_view);
        color = itemView.findViewById(R.id.vehicle_color_view);
        placa = itemView.findViewById(R.id.vehicle_placa_view);
        btnEdit = itemView.findViewById(R.id.vehicle_btn_edit_view);
        btnDelete = itemView.findViewById(R.id.vehicle_btn_delete_view);
    }
}
