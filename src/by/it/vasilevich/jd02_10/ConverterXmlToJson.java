package by.it.vasilevich.jd02_10;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConverterXmlToJson extends AbstractConverter {
    @Override
    public void buildConverter(String filename) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Students.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(filename);
            bean = (Students) u.unmarshal(reader);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getConverterResult() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(bean);
    }
}
