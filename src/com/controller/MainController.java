/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.view.VMain;
import com.view.VPegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mutia
 */
public class MainController implements ActionListener {
    //Mendeklarasikan view yang akan dipakai oleh controller
    VMain mainView;
    
    public MainController(){
        mainView = new VMain();
        mainView.btnPegawai.addActionListener(this);
        mainView.btnPengajuanCuti.addActionListener(this);
        mainView.btnExit.addActionListener(this);
    }
    
    public void showMainView(){
        mainView.setVisible(true);
    }
    
    public void showListPegawai(){
        PegawaiController pegawaiCont = new PegawaiController();
        pegawaiCont.showViewListPegawai();
    }
    
    public void showListPengajuanCuti(){
        
    }
    
    public void exitApp(){
        System.exit(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //event mapping untuk komponen mainView
        if(e.getSource()==mainView.btnPegawai){
            showListPegawai();
        }else if(e.getSource()==mainView.btnPengajuanCuti){
            showListPengajuanCuti();
        }else if(e.getSource()==mainView.btnExit){
            exitApp();
        }
        
    }
    
}
