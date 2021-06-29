/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author mutia
 */
public class VMain extends JFrame {
    //Deklarasi Komponen Tampilan
    public JButton btnPegawai = new JButton("Pegawai");
    public JButton btnPengajuanCuti = new JButton("Pengajuan Cuti");
    public JButton btnExit = new JButton("Keluar");
    //Konstruktor Kelas
    public VMain() {
        //Inisialisasi JFrame
        //Memberi judul Form
        this.setTitle("Formulir Pegawai");
        //Menentukan ukuran form
        this.setSize(300, 300);
        this.setLocationByPlatform(true);
        this.setLayout(new GridLayout(3,1));
        //Menentukan aksi ketika tombol close di kanan atas di klik
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Memanggil method untuk inisialisai komponen-komponen tampilan
        this.initComponent();
    }

    public void initComponent() {
        this.getContentPane().add(btnPegawai);
        this.getContentPane().add(btnPengajuanCuti);
        this.getContentPane().add(btnExit);
        
    }
}
