package com.uniyaz.uı.component.button;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class HbEditButton extends Button
{
    public HbEditButton()
    {
        setIcon(FontAwesome.EDIT);
        addStyleName(ValoTheme.BUTTON_FRIENDLY);
    }
}
