package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.Mark;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by temirlan on 12/4/17.
 */
@Service
public class MarkServiceImpl extends AbstractService<Mark, Long> implements MarkService {
    private float minMarkToPassExam = 2.6f;

    @Autowired
    public MarkServiceImpl(JpaRepository<Mark, Long> repository) {
        super(repository);
    }

    @Override
    public Mark getByName(String name) throws NotSupportedException {
        return null;
    }

    public boolean isChangeableMark(Mark mark) {
        if (mark.getId() == null)
            return true;
        Mark dbMark = repository.getOne(mark.getId());
        List<Float> dbMarkNotes = dbMark.getMarks();
        List<Float> markNotes = mark.getMarks();
        for (int i = 0; i < dbMarkNotes.size(); i++) {
            try {
                if (markNotes.get(i) > minMarkToPassExam && dbMarkNotes.get(i) < minMarkToPassExam) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void save(Mark object) {
        if (isChangeableMark(object)) {
            super.save(object);
        }
    }

    @Override
    public void save(Iterable<Mark> iterable) {
        Iterator<Mark> iterator = iterable.iterator();
        List<Mark> marks = new ArrayList<>();
        while (iterator.hasNext()) {
            Mark mark = iterator.next();
            if (isChangeableMark(mark)) {
                marks.add(mark);
            }
        }
        super.save(marks);
    }
}
