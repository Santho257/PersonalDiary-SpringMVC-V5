package com.santho.personaldiary.propeditors;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class DatePropertyEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        LocalDate date = (LocalDate) getValue();
        if(date == null)    return "";
        return date.toString();
    }
}
