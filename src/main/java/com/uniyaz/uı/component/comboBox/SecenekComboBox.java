package com.uniyaz.uı.component.comboBox;

import com.uniyaz.core.domain.EnumSoruTuru;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

import java.util.List;

public class SecenekComboBox extends ComboBox
{
    private EnumSoruTuru enumSoruTuru;
    private FormLayout mainLayout;

    public SecenekComboBox()
    {
        mainLayout = new FormLayout();

        fillCombobox();
    }

    private void fillCombobox()
    {
        for (EnumSoruTuru soruTuru : EnumSoruTuru.values()) {
            Item item = addItem(soruTuru);
        }
    }
}
