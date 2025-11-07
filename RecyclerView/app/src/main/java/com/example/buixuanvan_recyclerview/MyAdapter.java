package com.example.buixuanvan_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ItemModel item);
        void onSubActionClick(ItemModel item); // ví dụ click nút "Chi tiết"
    }

    private final Context context;
    private final List<ItemModel> duLieu;
    private final OnItemClickListener listener;

    public MyAdapter(Context context, List<ItemModel> duLieu, OnItemClickListener listener) {
        this.context = context;
        this.duLieu = duLieu;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_danh_sach, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int position) {
        ItemModel item = duLieu.get(position);
        h.tvTieuDe.setText(item.getTieuDe());
        h.tvMoTa.setText(item.getMoTa());
        h.img.setImageResource(item.getImageResId());

        // click cả item
        h.itemView.setOnClickListener(v -> listener.onItemClick(item));
        // click riêng nút "Chi tiết"
        h.btnChiTiet.setOnClickListener(v -> listener.onSubActionClick(item));
    }

    @Override
    public int getItemCount() { return duLieu.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTieuDe, tvMoTa, btnChiTiet;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_item);
            tvTieuDe = itemView.findViewById(R.id.tv_tieu_de_item);
            tvMoTa = itemView.findViewById(R.id.tv_mo_ta_item);
            btnChiTiet = itemView.findViewById(R.id.btn_chi_tiet);
        }
    }
}
