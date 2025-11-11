/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thori
 */
import java.time.LocalDate;

public class Tugas {
    private String judul;
    private String deskripsi;
    private LocalDate tanggalDeadline;
    private String status;

    public Tugas(String judul, String deskripsi, LocalDate tanggalDeadline, String status) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tanggalDeadline = tanggalDeadline;
        this.status = status;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public LocalDate getTanggalDeadline() {
        return tanggalDeadline;
    }

    public void setTanggalDeadline(LocalDate tanggalDeadline) {
        this.tanggalDeadline = tanggalDeadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
