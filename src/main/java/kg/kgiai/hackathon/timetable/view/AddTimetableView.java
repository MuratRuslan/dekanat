package kg.kgiai.hackathon.timetable.view;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import kg.kgiai.hackathon.timetable.model.*;
import kg.kgiai.hackathon.timetable.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView()
public class AddTimetableView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "AddITemTable";



    private ComboBox<Time> timeComboBox = new ComboBox<>("time");
    private ComboBox<Room> roomComboBox = new ComboBox<>("room");
    private ComboBox<Subject> subjectComboBox = new ComboBox<>("subject");
    private ComboBox<Teacher> teacherComboBox = new ComboBox<>("teacher");
    private Gruppa gruppa;
    private Weekday weekday;
    private Button save = new Button("save");

    @Autowired private TimetableRepository timetableRepository;
    @Autowired private SubjectRepository subjectRepository;
    @Autowired private TeacherRepository teacherRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private GruppaRepository gruppaRepository;

    @PostConstruct
    void init() {
        addComponents(timeComboBox, roomComboBox, subjectComboBox, teacherComboBox,
                save);
        save.addClickListener(e -> save());
        timeComboBox.setDataProvider(DataProvider.ofItems(Time.values()));
        roomComboBox.setItems(roomRepository.findAll());
        subjectComboBox.setItems(subjectRepository.findAll());
        teacherComboBox.setItems(teacherRepository.findAll());
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        timeComboBox.setDataProvider(DataProvider.ofItems(Time.values()));
        roomComboBox.setItems(roomRepository.findAll());
        subjectComboBox.setItems(subjectRepository.findAll());
        teacherComboBox.setItems(teacherRepository.findAll());
    }

    public void setTimetable(Gruppa gruppa, Weekday weekday) {
        this.gruppa = gruppa;
        this.weekday = weekday;
    }

    private void save() {
        Timetable timetable = new Timetable();
        timetable.setTime(timeComboBox.getValue().getTime());
        timetable.setGruppa(gruppa);
        timetable.setTeacher(teacherComboBox.getValue());
        timetable.setRoom(roomComboBox.getValue());
        timetable.setSubject(subjectComboBox.getValue());
        timetable.setDay(weekday.name());
        timetableRepository.save(timetable);

        if (getParent() instanceof Window) {
            ((Window) getParent()).close();
        } else {
            getUI().getNavigator().navigateTo(TimetableView.VIEW_NAME);
        }
    }
}
