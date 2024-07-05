package com.example.miniprojekprg7.constant;

public class TrPenjualanConstant {
    public static final String mNotFound = "Penjualan not found!";
    public static final String mEmptyData = "No Data Available!";
    public static final String mCreateSuccess = "Penjualan created successfully!";
    public static final String mCreateFailed = "Failed to create Penjualan!";
    public static final String mUpdateSuccess = "Penjualan updated successfully!";
    public static final String mUpdateFailed = "Failed to updated Penjualan!";
    public static final String mDeleteSuccess = "Penjualan deleted successfully!";
    public static final String mDeleteFailed = "Failed to delete Penjualan!";
    public static final String getTotalPenjualanToday = "SELECT COALESCE(SUM(trp_total), 0) FROM sparepart_trpenjualan  WHERE CONVERT(date, trp_tanggal) = CONVERT(date, GETDATE())";
    public static final String getTotalPenjualanYesterday = "SELECT COALESCE(SUM(trp_total), 0) FROM sparepart_trpenjualan WHERE CONVERT(date, trp_tanggal) = CONVERT(date, DATEADD(day, -1, GETDATE()))";
}
