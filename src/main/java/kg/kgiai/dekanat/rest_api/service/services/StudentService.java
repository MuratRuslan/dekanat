package kg.kgiai.dekanat.rest_api.service.services;

import kg.kgiai.dekanat.rest_api.model.Student;
import kg.kgiai.dekanat.rest_api.service.Service;

import java.util.List;

public interface StudentService extends Service<Student, Long> {

    List<Student> getAllByGroupId(Long groupId);
}
