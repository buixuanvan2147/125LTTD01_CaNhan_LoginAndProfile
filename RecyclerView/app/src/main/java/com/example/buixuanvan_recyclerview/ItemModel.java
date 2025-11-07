package com.example.buixuanvan_recyclerview;

public class ItemModel {
    private final String tieuDe;
    private final String moTa;
    private final int imageResId;

    public ItemModel(String tieuDe, String moTa, int imageResId) {
        this.tieuDe = tieuDe;
        this.moTa = moTa;
        this.imageResId = imageResId;
    }

    public String getTieuDe() { return tieuDe; }
    public String getMoTa() { return moTa; }
    public int getImageResId() { return imageResId; }
}
