package com.uniyaz.uı.page.soru;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.domain.EnumSoruTuru;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.uı.component.button.HbEditButton;
import com.uniyaz.uı.page.cevap.CevapPage;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.*;

import java.util.List;

public class SoruCevapla extends VerticalLayout
{
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    public Soru soru;
    public Cevap cevap;

    private long _anketId;

    public SoruCevapla(long anketId)
    {
        this._anketId = anketId;

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }

    public SoruCevapla(SoruCevapla soruCevapla, long anketId)
    {
        this._anketId = anketId;
    }


    private void buildTable() {

        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "SORU","SECENEK","");
    }



    private void buildContainer() {
        container = new IndexedContainer();
        container.addContainerProperty("ID", Long.class, null);
        container.addContainerProperty("SORU", String.class, null);
        container.addContainerProperty("CEVAP", EnumSoruTuru.class,null);
        container.addContainerProperty("guncelle", HbEditButton.class,null);

    }

    private void fillTable()
    {
        SoruService soruService = new SoruService();
        List<Soru> soruList = soruService.findAllByAnketId(_anketId);
        container.removeAllItems();
        for (Soru soru : soruList)
        {
            Item item = container.addItem(soru);
            item.getItemProperty("ID").setValue(soru.getId());
            item.getItemProperty("SORU").setValue(soru.getSoru());
            item.getItemProperty("CEVAP").setValue(soru.getEnumSecenek());

            HbEditButton guncelle = buildGuncelleButton(soru,cevap);
            item.getItemProperty("guncelle").setValue(guncelle);
        }
    }


    private void buildMainLayout()
    {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);
    }

    private HbEditButton buildGuncelleButton(final Soru soru,Cevap cevap)
    {
        HbEditButton guncelle = new HbEditButton();
        guncelle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                CevapPage cevapPage = new CevapPage(soru);
                Window window = new Window();
                window.setCaption("CEVAP");
                window.setClosable(true);
                window.setWindowMode(WindowMode.NORMAL);
                window.setWidth(50, Unit.PERCENTAGE);
                window.setHeight(50, Unit.PERCENTAGE);
                window.setResizable(true);
                window.center();
                window.setContent(cevapPage);
             //   cevap();
                HbUI syUI = (HbUI) HbUI.getCurrent();
                syUI.addWindow(window);
            }
        });
        return guncelle;
    }

//    private void cevap()
//    {
//        SoruService soruService = new SoruService();
//        List<Soru> soruList = soruService.findByAnketId(_anketId);
//        container.removeAllItems();
//        for (Soru soru : soruList)
//        {
//            if ("Coktansecmeli".equals(soru.getEnumSecenek()))
//            {
//                ComboBox comboBox = new ComboBox();
//                soruService.findAllHql();
//                addComponent(comboBox);
//            }
//        }
//    }
}
