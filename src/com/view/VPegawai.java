/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.entity.Pegawai;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author mutia
 */
public class VPegawai extends JFrame {
    //Deklarasi Komponen Tampilan
    public int idPegawai = 0;
    public JLabel lblNama = new JLabel("Nama:");
    public JLabel lblJK = new JLabel("JK:");
    public JLabel lblPekerjaan = new JLabel("Pekerjaan:");
    public JLabel lblAlamat = new JLabel("Alamat:");
    public JLabel lblAktif = new JLabel("Aktif?");
    public JTextField txtNama = new JTextField();
    public JRadioButton rbL = new JRadioButton("L");
    public JRadioButton rbP = new JRadioButton("P");
    public JComboBox cbPekerjaan = new JComboBox();
    public JTextArea taAlamat = new JTextArea();
    public JCheckBox chkAktif = new JCheckBox("Aktif");
    public JButton btnSimpan = new JButton("Save");
    public JButton btnBatal = new JButton("Batal");

    //Konstruktor Kelas
    public VPegawai() {
        //Inisialisasi JFrame
        //Memberi judul Form
        this.setTitle("Formulir Pegawai");
        //Menentukan ukuran form
        this.setSize(300, 300);
        //Mengosongkan layout form
        this.getContentPane().setLayout(null);
        //Menentukan posisi form/fram di layar
        this.setLocationByPlatform(true);
        //Menentukan aksi ketika tombol close di kanan atas di klik
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        //Memanggil method untuk inisialisai komponen-komponen tampilan
        this.initComponent();
    }

    public void initComponent() {
        //Membuat dan mensetting label
        //Menambahkan komponen labelNama ke Tampilan
        this.getContentPane().add(lblNama);
        //Mensetting Posisi dan ukuran komponen label Nama
        lblNama.setBounds(new Rectangle(20, 20, 150, 30));
        this.getContentPane().add(lblJK);
        lblJK.setBounds(new Rectangle(20, 50, 150, 30));
        this.getContentPane().add(lblPekerjaan);
        lblPekerjaan.setBounds(new Rectangle(20, 80, 150, 30));
        this.getContentPane().add(lblAlamat);
        lblAlamat.setBounds(new Rectangle(20, 110, 150, 30));
        this.getContentPane().add(lblAktif);
        lblAktif.setBounds(new Rectangle(20, 140, 150, 30));
        //Mengelompokan Radio Button Jenis Kelamin
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbL);
        bg.add(rbP);
        //Menambahkan komponen input ke dalam tampilan
        this.getContentPane().add(txtNama);
        this.getContentPane().add(rbL);
        this.getContentPane().add(rbP);
        this.getContentPane().add(cbPekerjaan);
        this.getContentPane().add(taAlamat);
        this.getContentPane().add(chkAktif);
        this.getContentPane().add(btnSimpan);
        this.getContentPane().add(btnBatal);
        //Mengatur tata letak/lokasi dan ukuran komponen input
        txtNama.setBounds(new Rectangle(120, 20, 150, 25));
        rbL.setBounds(new Rectangle(120, 50, 70, 25));
        rbP.setBounds(new Rectangle(190, 50, 70, 25));
        cbPekerjaan.setBounds(new Rectangle(120, 80, 150, 25));
        taAlamat.setBounds(new Rectangle(120, 110, 150, 25));
        chkAktif.setBounds(new Rectangle(120, 140, 150, 25));
        btnSimpan.setBounds(new Rectangle(120, 180, 85, 25));
        btnBatal.setBounds(new Rectangle(205, 180, 65, 25));

        //Menginisialisasi pilihan di Combobox Pekerjaan
        cbPekerjaan.addItem("Mahasiswa");
        cbPekerjaan.addItem("Mahasiswi");
        cbPekerjaan.addItem("Pelajar");
        cbPekerjaan.addItem("Student");

        //Membuat icon dari image di package res
        URL lokasi = VPegawai.class.getResource("/res/icon.png");
        ImageIcon img = new ImageIcon(lokasi);
        //Menambahkan icon ke tombol btnSimpan
        btnSimpan.setIcon(img);

        //Membuat image icon untuk background Frame/form
        URL locBg = VPegawai.class.getResource("/res/icap-bg.jpg");
        ImageIcon BgrImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgrImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 300, 300);
        //Membuat komponen menjadi transparan
        rbP.setOpaque(false);
        rbL.setOpaque(false);
        chkAktif.setOpaque(false);
    }

    public void setPegawai(Pegawai p) {
        if (p == null) {
            this.txtNama.setText(p.getNama());
            this.taAlamat.setText(p.getAlamat());
            this.cbPekerjaan.setSelectedItem(p.getPekerjaan());
            if (p.isActive()) {
                this.chkAktif.setSelected(true);
            }
            if (p.getJenisKelamin().equalsIgnoreCase("L")) {
                this.rbL.setSelected(true);
            }else{
                this.rbP.setSelected(true);
            }
        } else {
            this.txtNama.setText("");
            this.taAlamat.setText("");
            this.cbPekerjaan.setSelectedIndex(0);
            this.chkAktif.setSelected(false);
            this.rbL.setSelected(false);
            this.rbP.setSelected(false);
            
        }
    }
}
