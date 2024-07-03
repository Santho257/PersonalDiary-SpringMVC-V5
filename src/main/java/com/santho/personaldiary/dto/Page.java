package com.santho.personaldiary.dto;

import com.santho.personaldiary.annotations.DiaryDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Page {
    @DiaryDate
    @NotNull(message = "required")
    private LocalDate date;

    @NotBlank(message = "required")
    private String title;

    @NotBlank(message = "required")
    private String content;

    private int dairyId;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        if(date.isEmpty())  return;
        this.date = LocalDate.parse(date);
    }

//    public void setDate(LocalDate date) {
//        this.date = date;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDairyId() {
        return dairyId;
    }

    public void setDairyId(int dairyId) {
        this.dairyId = dairyId;
    }
}
