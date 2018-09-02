package com.principal.uberization.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateMappingDeserialize extends JsonDeserializer<Date>{

    @Override
    public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext) throws IOException, JsonProcessingException {
         SimpleDateFormat format =  new SimpleDateFormat("MM/dd/yyyy");
         format.setLenient(false);
            String date = paramJsonParser.getText();
            try {
                Date formattedDate= format.parse(date);
              return formattedDate;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

    }

}