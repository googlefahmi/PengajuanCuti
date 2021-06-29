package com.view;
import java.awt.*;
import javax.swing.*;

public class VListPegawai extends JFrame {
    public JTable tblEmployee = new JTable();
    public JButton btnAdd = new JButton("Add");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnDelete = new JButton("Delete");
    
    public VListPegawai(){
        this.setTitle("Daftar Pegawai");
        this.setSize(300, 400);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.initComponent();
    }
    
    public void initComponent(){
        tblEmployee = new JTable();
        JScrollPane scroll = new JScrollPane(tblEmployee);
        this.getContentPane().add(scroll);
        scroll.setBounds(new Rectangle(10,10,265,270));
        
        this.add(this.btnAdd);
        this.add(this.btnEdit);
        this.add(this.btnDelete);
        
        this.btnAdd.setBounds(10, 300, 80, 30);
        this.btnEdit.setBounds(102, 300, 80, 30);
        this.btnDelete.setBounds(195, 300, 80, 30);
    }
        
}
