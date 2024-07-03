package com.santho.personaldiary.propeditors;

import java.beans.PropertyEditorSupport;

public class SmallCasePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toLowerCase());
    }
}
