package com.uniyaz.uı.component.button;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class HbDeleteButton extends Button
{
    public HbDeleteButton()
    {
        setIcon(FontAwesome.REFRESH);
        addStyleName(ValoTheme.BUTTON_DANGER);
    }
}
