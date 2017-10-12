package kg.kgiai.hackathon.timetable.view;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import kg.kgiai.hackathon.timetable.model.*;
import kg.kgiai.hackathon.timetable.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringView(name = TimetableView.VIEW_NAME)
public class TimetableView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "Timetable";

    private Grid<Timetable> timetableGrid = new Grid<>();
    private ComboBox<Gruppa> gruppaComboBox = new ComboBox<>("Group");
    private ComboBox<Weekday> weekdayComboBox = new ComboBox<>("Weekday");
    private Button add = new Button("add");
    @Autowired private TimetableRepository timetableRepository;
    @Autowired private SubjectRepository subjectRepository;
    @Autowired private TeacherRepository teacherRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private GruppaRepository gruppaRepository;

    @Autowired private AddTimetableView addTimetableView;

    @PostConstruct
    public void init() {

        List<Gruppa> groups = gruppaRepository.findAll();
        timetableGrid.setDataProvider(DataProvider.ofCollection(timetableRepository.findByDayAndGruppaOrderByTime(
                Weekday.MONDAY.name(), groups.get(0))));
        gruppaComboBox.setDataProvider(DataProvider.ofCollection(groups));
        gruppaComboBox.setSelectedItem(groups.get(0));
        weekdayComboBox.setDataProvider(DataProvider.ofItems(Weekday.values()));
        weekdayComboBox.setSelectedItem(Weekday.MONDAY);

        timetableGrid.addComponentColumn(timetable -> {
            ComboBox<Time> timeComboBox = new ComboBox<>("time");
            timeComboBox.setItems(Time.values());
            timeComboBox.setSelectedItem(Time.fifth.getTime(timetable.getTime()));
            timeComboBox.addValueChangeListener(e -> {
                timetable.setTime(timeComboBox.getValue().getTime());
            });
            return timeComboBox;
        }).setCaption("time");

        timetableGrid.addComponentColumn(timetable -> {
            ComboBox<Subject> subjectComboBox = new ComboBox<>("Subject");
            subjectComboBox.setDataProvider(DataProvider.ofCollection(subjectRepository.findAll()));
            subjectComboBox.setSelectedItem(timetable.getSubject());
            subjectComboBox.addValueChangeListener(e -> timetable.setSubject(subjectComboBox.getValue()));
            return subjectComboBox;
        }).setCaption("subject");
        timetableGrid.setSizeFull();

        timetableGrid.addComponentColumn(timetable -> {
            ComboBox<Teacher> teacherComboBox = new ComboBox<>("Teacher");
            teacherComboBox.setDataProvider(DataProvider.ofCollection(teacherRepository.findAll()));
            teacherComboBox.setSelectedItem(timetable.getTeacher());
            teacherComboBox.addValueChangeListener(e -> timetable.setTeacher(teacherComboBox.getValue()));
            return teacherComboBox;
        }).setCaption("teacher");

        timetableGrid.addComponentColumn(timetable -> {
            ComboBox<Room> roomComboBox = new ComboBox<>("Room");
            roomComboBox.setDataProvider(DataProvider.ofCollection(roomRepository.findAll()));
            roomComboBox.setSelectedItem(timetable.getRoom());
            roomComboBox.addValueChangeListener(e -> {
                timetable.setRoom(roomComboBox.getValue());
                showGroupsInRoom(roomComboBox.getValue(), timetable.getTime());
            });
            return roomComboBox;
        }).setCaption("room");

        timetableGrid.addComponentColumn(timetable -> {
            Button saveButton = new Button("save", e -> {
                save(timetable);
                Notification.show("success");
            });
            return saveButton;
        }).setCaption("save");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponents(gruppaComboBox, weekdayComboBox);

        gruppaComboBox.addValueChangeListener( e -> {
            timetableGrid.setItems(timetableRepository.findByDayAndGruppaOrderByTime(
                    weekdayComboBox.getValue().name(), gruppaComboBox.getValue()));
        });

        weekdayComboBox.addValueChangeListener(e -> {
            timetableGrid.setItems(timetableRepository.findByDayAndGruppaOrderByTime(
                    weekdayComboBox.getValue().name(), gruppaComboBox.getValue()));
        });

        add.addClickListener(e -> {
            showAdd(gruppaComboBox.getValue(), weekdayComboBox.getValue());
        });

        addComponents(horizontalLayout, timetableGrid, add);

        setComponentAlignment(add, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    private void save(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    private void showAdd(Gruppa gruppa, Weekday weekday) {
            if (getUI().getWindows().isEmpty()) {
                Window editWindow = new Window("Add");
                editWindow.setContent(addTimetableView);
                getUI().addWindow(editWindow);
                editWindow.center();
                editWindow.setHeight("70%");
                editWindow.addCloseListener(closeEvent -> {
                    timetableGrid.setItems(timetableRepository.findByDayAndGruppaOrderByTime(
                            Weekday.MONDAY.name(), gruppa));
                });
            }
            addTimetableView.setTimetable(gruppa, weekday);
    }

    private void showGroupsInRoom(Room room, Date time) {
        if (getUI().getWindows().isEmpty()) {
            Window editWindow = new Window("Add");
            ListSelect<Gruppa> groups = new ListSelect<>();
            List<Timetable> allByRoomAndTime = timetableRepository.findAllByRoomAndTime(room, time);
            List<Gruppa> gruppas = new ArrayList<>();
            VerticalLayout layout = new VerticalLayout();
            layout.addComponent(groups);
            for(Timetable timetable : allByRoomAndTime) {
                gruppas.add(timetable.getGruppa());
            }

            groups.setDataProvider(DataProvider.ofCollection(gruppas));
            editWindow.setContent(layout);
            getUI().addWindow(editWindow);
            editWindow.center();
            editWindow.addCloseListener(closeEvent -> {
                timetableGrid.setItems(timetableRepository.findByDayAndGruppaOrderByTime(
                        weekdayComboBox.getValue().name(), gruppaComboBox.getValue()));
            });
        }
    }

}
