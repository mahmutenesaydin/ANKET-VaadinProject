package com.uniyaz.uı.page.soru;

import com.uniyaz.HbUI;
import com.uniyaz.core.domain.*;
import com.uniyaz.core.service.AnketService;
import com.uniyaz.core.service.SecenekService;
import com.uniyaz.core.service.SoruService;
import com.uniyaz.uı.page.cevap.CevapPage;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

public class SoruCevapla extends VerticalLayout {

    private VerticalLayout mainLayout;
    List<Soru> soruList;
    List<Secenek> secenekList;
    Secenek secenek;
    Cevap cevap;

    public SoruCevapla(Anket anket) {

        soruList = new ArrayList<Soru>();
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
    }

    private void buildMainLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        HbUI syUI = (HbUI) UI.getCurrent();
        Anket anket = syUI.getAnket();

        if (anket == null) return;
        AnketService anketService = new AnketService();
        anketService.findAll();

        SoruService soruService = new SoruService();
        List<Soru> soruList = soruService.findAllByAnketId(anket.getId());


        for (Soru soru : soruList) {
            Label soruAdi = new Label(soru.getSoru());
            mainLayout.addComponents(soruAdi);

            SecenekService secenekService = new SecenekService();
            secenekList = secenekService.findAllbyAnketID(soru.getId());


            if (soru.getEnumSecenek().name().equals("YaziMetni")) {
                TextField SoruveCevabi = new TextField("SORU:" + soru.getSoru());

                Soru soru1 = new Soru();
                this.soruList.add(soru1);
                mainLayout.addComponents(SoruveCevabi);
            } else if (soru.getEnumSecenek().name().equals("CoktanSecmeli")) {

                ComboBox comboBox = new ComboBox("SORU:" + soru.getSoru(), secenekList);

                Soru soru1 = new Soru();
                this.soruList.add(soru1);
                mainLayout.addComponent(comboBox);
            }
        }
        addComponent(mainLayout);


        Button ekleButton = buildEkleButton(anket);
        mainLayout.addComponents(ekleButton);
    }

    private Button buildEkleButton(Anket anket) {
        Button ekleButton = new Button("ANKET KAYDET");
        ekleButton.setIcon(FontAwesome.PLUS);
        ekleButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent)
            {
                cevap = new Cevap();
                CevapPage cevapPage = new CevapPage(cevap);
                addComponent(cevapPage);

            }
        });
        return ekleButton;
    }
}















//    private VerticalLayout mainLayout;
//    private Table table;
//    private Container container;
//    public Soru soru;
//    public Cevap cevap;
//
//    private long _anketId;
//
//    public SoruCevapla(long anketId)
//    {
//        this._anketId = anketId;
//
//        setSizeFull();
//        buildMainLayout();
//        addComponent(mainLayout);
//
//        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
//
//        fillTable();
//    }
//
//    public SoruCevapla(SoruCevapla soruCevapla, long anketId)
//    {
//        this._anketId = anketId;
//    }
//
//
//    private void buildTable() {
//
//        table = new Table();
//
//        buildContainer();
//        table.setContainerDataSource(container);
//        table.setColumnHeaders("ID", "SORU","SECENEK","");
//    }
//
//
//
//    private void buildContainer()
//    {
//        container = new IndexedContainer();
//        container.addContainerProperty("ID", Long.class, null);
//        container.addContainerProperty("SORU", String.class, null);
//        container.addContainerProperty("CEVAP", EnumSoruTuru.class,null);
//        container.addContainerProperty("guncelle", HbEditButton.class,null);
//
//    }
//
//    private void fillTable()
//    {
//        SoruService soruService = new SoruService();
//        List<Soru> soruList = soruService.findAllByAnketId(_anketId);
//        container.removeAllItems();
//        for (Soru soru : soruList)
//        {
//            Item item = container.addItem(soru);
//            item.getItemProperty("ID").setValue(soru.getId());
//            item.getItemProperty("SORU").setValue(soru.getSoru());
//            item.getItemProperty("CEVAP").setValue(soru.getEnumSecenek());
//
//            HbEditButton guncelle = buildGuncelleButton(soru,cevap);
//            item.getItemProperty("guncelle").setValue(guncelle);
//        }
//    }
//
//
//    private void buildMainLayout()
//    {
//        mainLayout = new VerticalLayout();
//        mainLayout.setSizeUndefined();
//
//        buildTable();
//        mainLayout.addComponent(table);
//    }
//
//    private HbEditButton buildGuncelleButton(final Soru soru,Cevap cevap)
//    {
//        HbEditButton guncelle = new HbEditButton();
//        guncelle.addClickListener(new Button.ClickListener() {
//            @Override
//            public void buttonClick(Button.ClickEvent clickEvent) {
//                CevapPage cevapPage = new CevapPage(soru);
//                Window window = new Window();
//                window.setCaption("CEVAP");
//                window.setClosable(true);
//                window.setWindowMode(WindowMode.NORMAL);
//                window.setWidth(50, Unit.PERCENTAGE);
//                window.setHeight(50, Unit.PERCENTAGE);
//                window.setResizable(true);
//                window.center();
//                window.setContent(cevapPage);
//                //   cevap();
//                HbUI syUI = (HbUI) HbUI.getCurrent();
//                syUI.addWindow(window);
//            }
//        });
//        return guncelle;
//  }
//}
//    private VerticalLayout mainLayout;
//
//    List<AnketCevap> hepsi;
//
//    public SoruCevapla() {
//        hepsi = new ArrayList<AnketCevap>();
//        setSizeFull();
//        buildMainLayout();
//        addComponent(mainLayout);
//
//        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
//
//        // fillTable();
//
//        //Button button=buildAnketButton();
//        //addComponents(button);
//    }
//
//    private void buildMainLayout()
//    {
//        mainLayout = new VerticalLayout();
//        mainLayout.setSizeUndefined();
//
//        HbUI syUI = (HbUI) UI.getCurrent();
//        Anket anket = syUI.getAnket();
//
//        if (anket == null) return;
//        AnketService anketService = new AnketService();
//        anketService.findAll();
//
//        SoruService soruService = new SoruService();
//        List<Soru> soruList = soruService.findAllByAnketId(anket.getId());
//
//
//        //panelici.removeAllComponents();
//        for (Soru soru : soruList) {
//            Label soruAdi = new Label(soru.getSoru());
//            mainLayout.addComponents(soruAdi);
//
//            SecenekService secenekService = new SecenekService();
//            List<Secenek> secenekList = secenekService.findAllbyAnketID(soru.getId());
//
//
//            if (soru.getEnumSecenek().equals("YaziMetni")) {
//                TextField SoruveCevabi = new TextField("SORU:" + soru.getSoru());
//
//                AnketCevap anketCevap = new AnketCevap(soru, SoruveCevabi, "T");
//                hepsi.add(anketCevap);
//                mainLayout.addComponents(SoruveCevabi);
//            }
//
//            if (soru.getEnumSecenek().equals("CoktanSecmeli")) {
//
//                OptionGroup radios = new OptionGroup("SORU:" + soru.getSoru(), secenekList);
//                radios.setImmediate(true);
//
//                radios.addValueChangeListener((Property.ValueChangeEvent event) -> {
//                    Secenek vitalStatus = (Secenek) event.getProperty().getValue();
//                    System.out.println("User selected a vital status name: " + vitalStatus.getSecenek() + ", labeled: " + vitalStatus.toString());
//                });
//                AnketCevap anketCevap = new AnketCevap(soru, radios, "R");
//                hepsi.add(anketCevap);
//                mainLayout.addComponents(radios);
//            }
//        }
//        addComponent(mainLayout);
//        // addComponent(mainLayout);
//
//    }
////
////
////        Button ekleButton = buildEkleButton( anket );
////        mainLayout.addComponents( ekleButton );
//
//
//}
//
////    private Button buildEkleButton(Anket anket) {
////        Button ekleButton = new Button("ANKET KAYDET");
////        ekleButton.setIcon( FontAwesome.PLUS );
////        ekleButton.addClickListener( new Button.ClickListener() {
////            @Override
////            public void buttonClick(Button.ClickEvent clickEvent) {
////
////                //  SyUI syUI = (SyUI) SyUI.getCurrent();
////                //  ContentComponent contentComponent = syUI.getContentComponent();
////                for (AnketCevap anketCevap:hepsi) {
////                    //anketCevap.getAnket();
////                    // anketCevap.getPanel();
////                    Soru soru = anketCevap.getSoru();
////
////
////                    if (soru.getSecenek_tipi().equals( "Tekli" )) {
////                        TextField textField = (TextField) anketCevap.getComponent();
////                        String cevap = textField.getValue();
////                        anketCevap.setAdi( anket.getAdi() );
////                        anketCevap.setTipi(soru.getSecenek_tipi());
////                        anketCevap.setCevap( cevap );
////                        AnketCevapService anketCevapService = new AnketCevapService();
////                        anketCevapService.saveAnketCevap( anketCevap );
////                    }
////
////                    if (soru.getSecenek_tipi().equals( "CoktanRadio" )) {
////                        //anketCevap.getSecenek();
////                        OptionGroup radios = (OptionGroup) anketCevap.getComponent();
////                        Secenek secenek = (Secenek) radios.getValue();
////
////                        //  Secenek vitalStatus = (Secenek) radios.getPropertyDataSource().getValue();
////                        anketCevap.setAdi( anket.getAdi() );
////                        anketCevap.setTipi(soru.getSecenek_tipi());
////                        anketCevap.setSecenek_id( secenek.getId() );
////                        anketCevap.setCevap( secenek.getAdi() );
////                        AnketCevapService anketCevapService = new AnketCevapService();
////                        anketCevapService.saveAnketCevap( anketCevap );
////
////                    }
////                    if (soru.getSecenek_tipi().equals( "CoktanCheckbox" )) {
////                        //anketCevap.getSecenek();
////                        CheckBox radios = (CheckBox) anketCevap.getComponent();
////                        Secenek secenek = (Secenek) radios.getData();
////                        if(radios.getValue()) {
////                            //  Secenek vitalStatus = (Secenek) radios.getPropertyDataSource().getValue();
////                            anketCevap.setAdi( anket.getAdi() );
////                            anketCevap.setTipi( secenek.getTipi() );
////                            anketCevap.setSecenek_id( secenek.getId() );
////                            anketCevap.setCevap( secenek.getAdi() );
////                            AnketCevapService anketCevapService = new AnketCevapService();
////                            anketCevapService.saveAnketCevap( anketCevap );
////                        }
////                    }
////                }}
////
////        } );
////        return ekleButton;
////    }
