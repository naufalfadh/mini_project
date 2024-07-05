package com.example.miniprojekprg7.constant;

public class KaryawanConstant {
    public static final String mNotFound = "Karyawan not found!";
    public static final String mEmptyData = "No Data Available!";
    public static final String mCreateSuccess = "Karyawan created successfully!";
    public static final String mCreateFailed = "Failed to create Karyawan!";
    public static final String mUpdateSuccess = "Karyawan updated successfully!";
    public static final String mUpdateFailed = "Failed to updated Karyawan!";
    public static final String mDeleteSuccess = "Karyawan deleted successfully!";
    public static final String mDeleteFailed = "Failed to delete Karyawan!";
    public static final String qAllDataActive ="SELECT * FROM sparepart_mskaryawan WHERE kry_status = 1";
    public static final String qDataLogin ="SELECT TOP 1 * FROM sparepart_mskaryawan WHERE kry_status = 1 AND kry_nama = :nama AND kry_email = :email";
}
