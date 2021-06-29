/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import com.entity.Pegawai;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mutia
 */
public class PegawaiHelper extends DBConnection {

    public boolean save(Pegawai p) {
        //Buat SQL untuk menyimpan data 
        String sql = "INSERT INTO MPegawai(nama,jenis_kelamin,is_active,pekerjaan,alamat)"
                + " values(?,?,?,?,?)";
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getJenisKelamin());
            ps.setBoolean(3, p.isActive());
            ps.setString(4, p.getPekerjaan());
            ps.setString(5, p.getAlamat());
            //Eksekusi sql yang sudah dibuat
            count = ps.executeUpdate();
            //Mengambil nilai auto_Increment jika ada
            ResultSet autoNumbers = ps.getGeneratedKeys();
            if (autoNumbers.next()) {
                this.newId = autoNumbers.getInt(1);
                p.setIdPegawai(this.newId);
            } 
            //Tutup Koneksi
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(Pegawai p) {
        //Buat SQL untuk menyimpan data 
        String sql = "UPDATE MPegawai SET nama=?,jenis_kelamin=?,is_active=?,"
                + "pekerjaan=?,alamat=? WHERE id_pegawai=?";
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getJenisKelamin());
            ps.setBoolean(3, p.isActive());
            ps.setString(4, p.getPekerjaan());
            ps.setString(5, p.getAlamat());
            ps.setInt(6, p.getIdPegawai());
            //Eksekusi sql yang sudah dibuat
            count = ps.executeUpdate();
            //Tutup Koneksi
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id_Pegawai) {
        //Buat SQL untuk menghapus data        
        String sql = "DELETE FROM MPegawai WHERE id_Pegawai=?";
        int count = 0;
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_Pegawai);
            //Eksekusi sql yang sudah dibuat
            count = ps.executeUpdate();
            this.disconnect();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Pegawai get(int id_Pegawai) {
        Pegawai m = null;
        //Buat SQL untuk membaca data Pegawai
        String sql = "SELECT * FROM MPegawai WHERE id_Pegawai=?";
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_Pegawai);
            ResultSet rs = ps.executeQuery();
            //Baca data yang dihasilkan
            if (rs.next()) {
                m = new Pegawai();
                m.setIdPegawai(rs.getInt("id_pegawai"));
                m.setNama(rs.getString("nama"));
                m.setAlamat(rs.getString("alamat"));
                m.setPekerjaan(rs.getString("pekerjaan"));
                m.setActive(rs.getBoolean("is_active"));
                m.setJenisKelamin(rs.getString("jenis_kelamin"));
            }
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return m;
    }

    //Jangan lupa di bagian paling atas tambahkan import java.util.ArrayList;
    public ArrayList<Pegawai> getList() {
        ArrayList<Pegawai> list = new ArrayList<Pegawai>();
        String sql = "SELECT * FROM MPegawai";
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Baca data yang dihasilkan
            while (rs.next()) {
                Pegawai m = new Pegawai();
                m.setIdPegawai(rs.getInt("id_pegawai"));
                m.setNama(rs.getString("nama"));
                m.setAlamat(rs.getString("alamat"));
                m.setPekerjaan(rs.getString("pekerjaan"));
                m.setActive(rs.getBoolean("is_active"));
                m.setJenisKelamin(rs.getString("jenis_kelamin"));
                //masukan ke dalam list
                list.add(m);

            }
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
}
