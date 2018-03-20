package kg.kgiai.dekanat.rest_api.json.custom;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import kg.kgiai.dekanat.rest_api.model.Student;
import kg.kgiai.dekanat.rest_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by temirlan on 12/4/17.
 */
@Component
public class CustomMarkDeserializer extends StdDeserializer<Student> {
    @Autowired
    private StudentRepository studentRepository;

    public CustomMarkDeserializer() {
        this(null);
    }

    protected CustomMarkDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Student deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        Student student = studentRepository.getOne(Long.valueOf(jsonParser.getText()));
        return student;
    }
}
