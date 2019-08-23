package com.edu.realestate.convert;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
    @Override  //OBJ to DB
    public String convertToDatabaseColumn(Boolean attribute) {
        // TODO Auto-generated method stub
        return (attribute != null && attribute.booleanValue() ? "Y" : "N");
    }
    @Override //DB to OBJ
    public Boolean convertToEntityAttribute(String dbData) {
        char data = (dbData == null ? 'N' : dbData.toUpperCase().charAt(0));
        return data == 'Y' ? true : false;
    }
}