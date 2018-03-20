package kg.kgiai.dekanat.rest_api.json.custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import kg.kgiai.dekanat.rest_api.model.Student;

import java.io.IOException;

/**
 * Created by temirlan on 12/4/17.
 */
public class CustomMarkSerializer extends StdSerializer<Student> {


    public CustomMarkSerializer() {
        this(null);
    }

    protected CustomMarkSerializer(Class<Student> t) {
        super(t);
    }

    @Override
    public void serialize(Student student, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(String.valueOf(student.getId()));
    }
}
