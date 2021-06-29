/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author mutia
 */
public class Pegawai {
    private String nama;
    private String alamat;
    private String jenisKelamin;
    private int idPegawai;
    private String Pekerjaan;
    private boolean active;

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the jenisKelamin
     */
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    /**
     * @param jenisKelamin the jenisKelamin to set
     */
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    /**
     * @return the idPegawai
     */
    public int getIdPegawai() {
        return idPegawai;
    }

    /**
     * @param idPegawai the idPegawai to set
     */
    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
    }

    /**
     * @return the Pekerjaan
     */
    public String getPekerjaan() {
        return Pekerjaan;
    }

    /**
     * @param Pekerjaan the Pekerjaan to set
     */
    public void setPekerjaan(String Pekerjaan) {
        this.Pekerjaan = Pekerjaan;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param status the status to set
     */
    public void setActive(boolean status) {
        this.active = status;
    }
    
    
}
