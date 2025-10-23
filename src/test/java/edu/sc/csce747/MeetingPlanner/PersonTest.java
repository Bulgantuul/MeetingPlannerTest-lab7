package edu.sc.csce747.MeetingPlanner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testPersonAddMeeting_noConflict() {
        Person person = new Person("Alice");
        Room room = new Room("R201");
        ArrayList<Person> attendees = new ArrayList<>();
        attendees.add(person);

        Meeting meeting = new Meeting(7, 20, 14, 16, attendees, room, "Project Meeting");

        try {
            person.addMeeting(meeting);
            assertTrue(person.isBusy(7, 20, 14, 16));
        } catch (TimeConflictException e) {
            fail("No conflict expected: " + e.getMessage());
        }
    }

    @Test
    public void testPersonAddMeeting_conflict() throws TimeConflictException {
        Person person = new Person("Alice");
        Room room = new Room("R201");
        ArrayList<Person> attendees = new ArrayList<>();
        attendees.add(person);

        Meeting m1 = new Meeting(7, 20, 14, 16, attendees, room, "Meeting1");
        person.addMeeting(m1);

        Meeting m2 = new Meeting(7, 20, 15, 17, attendees, room, "Meeting2");
        assertThrows(TimeConflictException.class, () -> person.addMeeting(m2));
    }
}
