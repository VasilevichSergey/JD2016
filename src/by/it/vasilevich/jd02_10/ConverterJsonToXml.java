package by.it.vasilevich.jd02_10;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

public class ConverterJsonToXml extends AbstractConverter {


    @Override
    public void buildConverter(String filename) {
        String json = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = "";
            while ((line = reader.readLine()) != null) {
                json = json.concat(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(json, Students.class);

    }

    @Override
    public String getConverterResult() {
        JAXBContext jc = null;
        String res = "";
        try {
            jc = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jc.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, stringWriter);
            res = stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return res;
    }

}