package kg.kgiai.hackathon.timetable.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.*;
import kg.kgiai.hackathon.timetable.model.Weekday;
import kg.kgiai.hackathon.timetable.view.TimetableView;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/")
public class MainUI extends UI {

    @Autowired
    private SpringViewProvider springViewProvider;
    private Panel groupViewDisplay;
    private Panel timeTableDisplay;
    private Navigator groupNavigator;
    private Navigator timetableNavigator;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        amqpTemplate.convertAndSend("simple-message","hi iam murat");

        timeTableDisplay = new Panel();

        timetableNavigator = new Navigator(this, timeTableDisplay);
        timetableNavigator.addProvider(springViewProvider);
        timetableNavigator.navigateTo(TimetableView.VIEW_NAME);
        timeTableDisplay.setWidth("1000");

        layout.addComponent(timeTableDisplay);
    }
}
