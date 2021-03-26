package com.uniyaz.core.domain;

import com.uniyaz.core.service.SoruService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ANKETCEVAP")
public class AnketCevap extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ADI", nullable = false, length = 100)
    @NotNull
    private String adi;

    @Column(name = "KULLANICI_ADI", nullable = false, length = 100)
    @NotNull
    private String kullanici_adi;

    @Column(name = "TIPI", nullable = false, length = 100)
    @NotNull
    private String tipi;

    @Column(name = "SORU_ID")
    private Long soru_id;

    @Column(name = "SECENEK_ID")
    private Long secenek_id;

    @Column(name = "CEVAP", nullable = false, length = 100)
    @NotNull
    private String cevap;

    @Transient
    private Soru soru;

    @Transient
    private Secenek secenek;

    @Transient
    private Panel panel;

    @Transient
    private Anket anket;

    @Transient
    private com.vaadin.ui.Component component;

    @Transient
    private String componet_tipi;



    public AnketCevap(Secenek secenek , com.vaadin.ui.Component component, String componet_tipi) {
        this.secenek=secenek;
        this.secenek_id=secenek.getId();
        this.soru =secenek.getSoru();
        this.soru_id=secenek.getSoru().getId();
        //this.panel=secenek.getSoru().getPanel();
        //this.anket=secenek.getSoru().getPanel().getAnket();
        this.component=component;
        this.componet_tipi=componet_tipi;
    }


    public AnketCevap(com.uniyaz.core.domain.Soru soru, com.vaadin.ui.Component component, String componet_tipi) {
        SoruService soruService=new SoruService();
        this.soru =soru;
        this.soru_id=soru.getId();
      //  this.panel=soru.getPanel();

        //this.anket=soru.getPanel().getAnket();
        this.component=component;
        this.componet_tipi=componet_tipi;
    }

    public AnketCevap() {
    }
    public Long getSecenek_id() {
        return secenek_id;
    }

    public void setSecenek_id(Long secenek_id) {
        this.secenek_id = secenek_id;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public Secenek getSecenek() {
        return secenek;
    }

    public void setSecenek(Secenek secenek) {
        this.secenek = secenek;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public Anket getAnket() {
        return anket;
    }

    public void setAnket(Anket anket) {
        this.anket = anket;
    }

    public Long getSoru_id() {
        return soru_id;
    }

    public void setSoru_id(Long soru_id) {
        this.soru_id = soru_id;
    }

    public com.vaadin.ui.Component getComponent() {
        return component;
    }

    public void setComponent(com.vaadin.ui.Component component) {
        this.component = component;
    }

    public String getComponet_tipi() {
        return componet_tipi;
    }

    public void setComponet_tipi(String componet_tipi) {
        this.componet_tipi = componet_tipi;
    }
    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public com.uniyaz.core.domain.Soru getSoru() {
        return soru;
    }

    public void setSoru(com.uniyaz.core.domain.Soru Soru) {
        this.soru = Soru;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Override
    public String toString() {
        return adi ;
    }
}

