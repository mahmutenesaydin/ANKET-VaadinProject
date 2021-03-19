package com.uniyaz.uı.component.comboBox;

import com.uniyaz.core.dao.SoruDao;
import com.uniyaz.core.domain.Soru;
import com.vaadin.ui.ComboBox;

import java.util.List;

public class SoruComboBox extends ComboBox
{
    private SoruDao soruDao;
    private Soru soru;

    public SoruComboBox()
    {
        this.soruDao = new SoruDao();
        this.setDescription("Soruyu Seçiniz");
        fillComboBox();
    }

    private void fillComboBox()
    {
        this.removeAllItems();
 //      List<Soru> soruList = soruDao.findAllByanketId(soru.getId());
        List<Soru> soruList = soruDao.findAll();
        for (Soru soru : soruList)
        {
            this.addItem(soru);
            setItemCaption(soru,soru.getSoru());
        }
    }
}
