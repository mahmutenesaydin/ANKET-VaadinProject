package com.uniyaz.core.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PANEL")
public class Panel extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PANEL_ADI", nullable = false, length = 100)
    @NotNull
    private String ad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANKET", foreignKey = @ForeignKey(name = "FK_PANEL_ANKET"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Anket anket;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Anket getAnket() {
        return anket;
    }

    public void setAnket(Anket anket) {
        this.anket = anket;
    }
}
