package com.santho.personaldiary.collections;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("pages")
public class DairyPage {
    public String userEmail;
    
}
