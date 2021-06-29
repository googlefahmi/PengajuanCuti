/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Pegawai;
import com.helper.PegawaiHelper;
import com.view.VListPegawai;
import com.view.VPegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mutia
 */
public class PegawaiController implements ActionListener {
    //Mendeklarasikan view yang akan dipakai oleh controller

    VPegawai viewAddPegawai;
    VPegawai viewUpdatePegawai;
    VListPegawai viewListPegawai;

    public PegawaiController() {
        //Menginisialisasi tampilan tambah data karyawan
        viewAddPegawai = new VPegawai();
        viewAddPegawai.btnSimpan.addActionListener(this);
        viewAddPegawai.btnBatal.addActionListener(this);
        //Menginisialisasi tampilan list pegawai
        viewListPegawai = new VListPegawai();
        viewListPegawai.btnAdd.addActionListener(this);
        viewListPegawai.btnDelete.addActionListener(this);
        viewListPegawai.btnEdit.addActionListener(this);
        //Menginisialisasi tampilan edit pegawai
        viewUpdatePegawai = new VPegawai();
        viewUpdatePegawai.btnSimpan.addActionListener(this);
        viewUpdatePegawai.btnBatal.addActionListener(this);
    }

    //Controll untuk penambahan data
    public void showViewAddPegawai() {
        //MEnampilkan form/frame data pegawai        
        viewAddPegawai.setVisible(true);
    }

    public void cancelAddPegawai() {
        viewAddPegawai.setVisible(false);
    }

    public void saveAddPegawai() {
        //Lakukan validasi tidak boleh kosong
        if (viewAddPegawai.txtNama.getText().isEmpty()) {
            //jika nama kosong
            JOptionPane.showMessageDialog(viewAddPegawai, "Kolom nama tidak boleh kosong!");
        } else if (viewAddPegawai.taAlamat.getText().isEmpty()) {
            //jika alamat kosong
            JOptionPane.showMessageDialog(viewAddPegawai, "Kolom alamat tidak boleh kosong!");
        } else {
            //jika semua kolom isian sudah benar
            //Buat pegawai baru
            Pegawai p = new Pegawai();
            //isi objek pegawai
            p.setNama(viewAddPegawai.txtNama.getText());
            p.setAlamat(viewAddPegawai.taAlamat.getText());
            if (viewAddPegawai.rbL.isSelected()) {
                p.setJenisKelamin("L");
            } else {
                p.setJenisKelamin("P");
            }
            p.setPekerjaan(viewAddPegawai.cbPekerjaan.getSelectedItem().toString());
            p.setActive(viewAddPegawai.chkAktif.isSelected());
            //Buat helper untuk menyimpan data ke tabel mpegawai
            PegawaiHelper ph = new PegawaiHelper();
            ph.save(p);
            //JOptionPane.showMessageDialog(viewAddPegawai,p.getIdPegawai());
            //refresh atau tampilkan ulang data ke dalam tabel
            this.fillTableListPegawai();
            //hide view add pegawai
            viewAddPegawai.setVisible(false);
        }

    }

    //Controll untuk perubahan data
    public void showViewUpdatePegawai() {
        //mengambil id_pegawai terpilih yang akan diupdate
        String idpeg = (String) this.viewListPegawai.tblEmployee.getModel().getValueAt(
                this.viewListPegawai.tblEmployee.getSelectedRow(), 0);
        //Mengambil data pegawai yang akan diedit dari db
        PegawaiHelper ph = new PegawaiHelper();
        Pegawai p = ph.get(idpeg);
        if (p != null) {
            //Jika Data p tidak kosong maka tampilakan di frame update data
            viewUpdatePegawai.idPegawai = p.getIdPegawai();
            viewUpdatePegawai.txtNama.setText(p.getNama());
            viewUpdatePegawai.taAlamat.setText(p.getAlamat());
            if(p.getJenisKelamin().equalsIgnoreCase("L")){
                viewUpdatePegawai.rbL.setSelected(true);
            }else{
                viewUpdatePegawai.rbP.setSelected(true);
            }
            viewUpdatePegawai.cbPekerjaan.setSelectedItem(p.getPekerjaan());
            if(p.isActive()){
                viewUpdatePegawai.chkAktif.setSelected(true);
            }else{
                viewUpdatePegawai.chkAktif.setSelected(false);
            }            
            //MEnampilkan form/frame update data pegawai        
            viewUpdatePegawai.setVisible(true);
        }
    }

    public void cancelUpdatePegawai() {
        viewUpdatePegawai.setVisible(false);
    }

    public void saveUpdatePegawai() {
        //Lakukan validasi tidak boleh kosong
        if (viewUpdatePegawai.txtNama.getText().isEmpty()) {
            //jika nama kosong
            JOptionPane.showMessageDialog(viewUpdatePegawai, "Kolom nama tidak boleh kosong!");
        } else if (viewUpdatePegawai.taAlamat.getText().isEmpty()) {
            //jika alamat kosong
            JOptionPane.showMessageDialog(viewUpdatePegawai, "Kolom alamat tidak boleh kosong!");
        } else {
            //jika semua kolom isian sudah benar
            //Buat helper mpegawai
            PegawaiHelper ph = new PegawaiHelper();
            //ambil objek yang mau diupdate dari db
            Pegawai p = ph.get(viewUpdatePegawai.idPegawai) ;
            //perbaharui isi objek pegawai
            p.setNama(viewUpdatePegawai.txtNama.getText());
            p.setAlamat(viewUpdatePegawai.taAlamat.getText());
            if (viewUpdatePegawai.rbL.isSelected()) {
                p.setJenisKelamin("L");
            } else {
                p.setJenisKelamin("P");
            }
            
            p.setPekerjaan(viewUpdatePegawai.cbPekerjaan.getSelectedItem().toString());
            p.setActive(viewUpdatePegawai.chkAktif.isSelected());
            //Simpan perubahan ke dalam db            
            ph.update(p);
            
            //refresh atau tampilkan ulang data ke dalam tabel
            this.fillTableListPegawai();
            //hide view add pegawai
            viewUpdatePegawai.setVisible(false);
        }
    }

    //Controll untuk menampilkan list data
    public void showViewListPegawai() {
        //memanggil method untuk mengisi tabel dengan data dari db
        this.fillTableListPegawai();
        //MEnampilkan form/frame data pegawai        
        viewListPegawai.setVisible(true);
    }

    private void fillTableListPegawai() {
        //membuat kelas yang menangani koneksi ke tabel mpegawai
        PegawaiHelper ph = new PegawaiHelper();
        //Mengambil seluruh data dari tabel mpegawai
        ArrayList listPegawai = ph.getList();
        //Membuat header untuk jtabel
        String[] header = {"IDPegawai", "No", "Nama", "Alamat", "JK", "Pekerjaan", "Active"};
        //Membuat model untuk jtabel
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int no = 1;
        //MEngisi model dengan data yang dianbil dari tabel mpegawai
        for (Object o : listPegawai) {
            Pegawai p = (Pegawai) o;
            //menambahkan/memasukan data ke model
            model.addRow(new Object[]{p.getIdPegawai(), no++, p.getNama(), p.getAlamat(),
                        p.getJenisKelamin(), p.getPekerjaan(), p.isActive()});
        }
        //memasukan/menampilkan model di jtable
        this.viewListPegawai.tblEmployee.setModel(model);
        //membuat kolom 0 (idPEgawai) di hidden
        this.viewListPegawai.tblEmployee.getColumnModel().getColumn(0).setMinWidth(0);
        this.viewListPegawai.tblEmployee.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void deletePegawai() {
        //Mengkonfirmasi apakah benar akan didelete
        int status = JOptionPane.showConfirmDialog(viewListPegawai,
                "Konfirmasi", "Apakah Anda yakin akan menghapus data ini?",
                JOptionPane.YES_NO_OPTION);
        //Jika jawaban = yes, maka diproses
        if (status == JOptionPane.YES_OPTION) {
            //Membuat kelas yg menangani koneksi ke tabel mpegawai
            PegawaiHelper ph = new PegawaiHelper();
            //mengambil id_pegawai terpilih yang akan dihapus
            String idpeg = (String) this.viewListPegawai.tblEmployee.getModel().getValueAt(
                    this.viewListPegawai.tblEmployee.getSelectedRow(), 0);
            //hapus dengan memanfaatkan Helper
            ph.delete(idpeg);
            //tampilkan ulang data ke tabel
            this.fillTableListPegawai();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //event mapping untuk komponen viewAddPegawai
        if (e.getSource() == viewAddPegawai.btnSimpan) {
            saveAddPegawai();
        } else if (e.getSource() == viewAddPegawai.btnBatal) {
            cancelAddPegawai();
        }
        //event mapping untuk komponen viewListPegawai
        if (e.getSource() == viewListPegawai.btnAdd) {
            this.showViewAddPegawai();
        } else if (e.getSource() == viewListPegawai.btnEdit) {
            this.showViewUpdatePegawai();
        } else if (e.getSource() == viewListPegawai.btnDelete) {
            deletePegawai();
        }
        //event mapping untuk komponen viewUpdatePegawai
        if (e.getSource() == viewUpdatePegawai.btnSimpan) {
            saveUpdatePegawai();
        } else if (e.getSource() == viewUpdatePegawai.btnBatal) {
            cancelUpdatePegawai();
        }
    }
}
