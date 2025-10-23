package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class PersonTest {

    @Test
    public void testPersonAddMeeting() {
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
}
