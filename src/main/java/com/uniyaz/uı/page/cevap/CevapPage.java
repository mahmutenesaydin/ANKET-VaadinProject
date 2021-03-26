package com.uniyaz.uı.page.cevap;

import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Cevap;
import com.uniyaz.core.domain.Kullanici;
import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.service.CevapService;
import com.uniyaz.uı.component.button.HbSaveButton;
import com.uniyaz.uı.page.BasePage;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;


public class CevapPage extends BasePage
{
    private FormLayout mainLayout;

    private BeanItem<Cevap> cevapBeanItem;
    private FieldGroup binder;
    private Soru soru;
    private Cevap cevap;

    public CevapPage(Cevap cevap)
    {
        this.cevap = cevap;
    }

    public CevapPage(Soru soru)
    {
        this.soru = soru;
        Cevap cevap = new Cevap();
        cevap.setSoru(soru);

        buildView(cevap);
    }

    public void buildView(Cevap cevap)
    {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        cevapBeanItem = new BeanItem<Cevap>(cevap);
        binder = new FieldGroup(cevapBeanItem);
        binder.bindMemberFields(this);
    }


    @Override
    public void buildMainLayout() {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        try
        {
            binder.commit();

            Cevap cevap = cevapBeanItem.getBean();
            CevapService cevapService = new CevapService();
            cevapService.save(cevap);
        }
        catch (FieldGroup.CommitException e)
        {
            Notification.show("Geçersiz, lütfen geçerli değerler giriniz", Notification.Type.ERROR_MESSAGE);
        } catch (Exception e)
        {
            Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
        }
    }
}
