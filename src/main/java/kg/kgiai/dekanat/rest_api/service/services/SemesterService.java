package kg.kgiai.dekanat.rest_api.service.services;

import kg.kgiai.dekanat.rest_api.model.Semester;
import kg.kgiai.dekanat.rest_api.service.Service;

public interface SemesterService extends Service<Semester, Long> {
    Boolean exist(Semester semester);
}
