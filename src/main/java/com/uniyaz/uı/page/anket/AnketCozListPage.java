package com.uniyaz.uı.page.anket;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.AnketService;
import com.uniyaz.uı.page.soru.SoruCevapla;
import com.uniyaz.uı.page.soru.SoruListPage;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.*;

import java.util.List;

public class AnketCozListPage extends VerticalLayout {

    private VerticalLayout mainLayout;
    private Table table;
    private Container container;
    private Soru soru;
    private Anket anket;
    private SoruCevapla soruCevapla;

    public AnketCozListPage()
    {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);
    }

    private void buildTable() {

        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "ANKET", "");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("ID", Long.class, null);
        container.addContainerProperty("ANKET", String.class, null);
        container.addContainerProperty("soruCevapla", Button.class, null);

    }

    private void fillTable() {

        AnketService anketService = new AnketService();
        List<Anket> anketList = anketService.findAll();
        for (Anket anket : anketList) {
            Item item = container.addItem(anket);
            item.getItemProperty("ID").setValue(anket.getId());
            item.getItemProperty("ANKET").setValue(anket.getAd());



            Button secim = buildSecimButton(new SoruCevapla(anket.getId()));
            secim.setId(anket.getId().toString());
            item.getItemProperty("soruCevapla").setValue(secim);

        }
    }

    private Button buildSecimButton(SoruCevapla soruCevapla)
    {
        Button secim = new Button("ANKETİ ÇÖZ");
        secim.setIcon(FontAwesome.CHECK);
        secim.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SoruCevapla soruCevapla1 = new SoruCevapla(soruCevapla,Long.parseLong(secim.getId()));
                Window window = new Window();
                window.setCaption("ANKET");
                window.setClosable(true);
                window.setWindowMode(WindowMode.NORMAL);
                window.setWidth(50, Unit.PERCENTAGE);
                window.setHeight(50, Unit.PERCENTAGE);
                window.setResizable(true);
                window.center();
                window.setContent(soruCevapla);

                HbUI syUI = (HbUI) HbUI.getCurrent();
                syUI.addWindow(window);

            }
        });
        return secim;
    }
}
