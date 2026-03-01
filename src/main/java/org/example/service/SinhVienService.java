package org.example.service;

import org.example.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    List<SinhVien> listSinhVien = new ArrayList<>();
    public SinhVien updateSinhVien(SinhVien sinhVien) {
        if (sinhVien==null) {
            throw new IllegalArgumentException("Sinh vien k duoc null");
        }
        if (sinhVien.getTenSV()==null || sinhVien.getTenSV().trim().isEmpty()) {
            throw new IllegalArgumentException("Ten sinh vien k dc de trong");
        }
        if (sinhVien.getChuyenNganh()==null || sinhVien.getChuyenNganh().trim().isEmpty()) {
            throw new IllegalArgumentException("Chuyen nganh sinh vien k dc de trong");
        }
        if (sinhVien.getDiemTrungBinh()<0){
            throw new IllegalArgumentException("Diem trung binh trong khoang 0-10");
        }
        if (sinhVien.getTuoi()<0){
            throw new IllegalArgumentException("Tuoi >0");
        }
        if (sinhVien.getKyHoc()<0){
            throw new IllegalArgumentException("Ky hoc >0");
        }
        for (SinhVien sv : listSinhVien) {
            if (sv.getMaSV().equals(sinhVien.getMaSV())) {
                sv.setTenSV(sinhVien.getTenSV());
                sv.setTuoi(sinhVien.getTuoi());
                sv.setKyHoc(sinhVien.getKyHoc());
                sv.setChuyenNganh(sinhVien.getChuyenNganh());
                sv.setDiemTrungBinh(sinhVien.getDiemTrungBinh());
                return sv;
            }
        }
        throw new IllegalArgumentException("Khong tim thay sv can update");
    }
    public SinhVien getSinhVien(String maSV){
        for (SinhVien sv : listSinhVien){
            if (sv.getMaSV().equals(maSV)) {
                return sv;
            }
        }
        return null;
    }
    public void addSinhVien(SinhVien sv){
        listSinhVien.add(sv);
    }
}
