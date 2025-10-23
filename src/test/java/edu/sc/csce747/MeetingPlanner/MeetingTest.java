package edu.sc.csce747.MeetingPlanner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MeetingTest {

    @Test
    public void testMeetingConstructorWithDetails() {
        ArrayList<Person> attendees = new ArrayList<>();
        Room room = new Room("R301");
        Meeting meeting = new Meeting(8, 5, 10, 12, attendees, room, "Design Review");

        assertEquals(8, meeting.getMonth());
        assertEquals(5, meeting.getDay());
        assertEquals(10, meeting.getStartTime());
        assertEquals(12, meeting.getEndTime());
        assertEquals("Design Review", meeting.getDescription());
        assertEquals(room, meeting.getRoom());
    }

    @Test
    public void testMeetingFullDayConstructor() {
        Meeting meeting = new Meeting(6, 15);
        assertEquals(0, meeting.getStartTime());
        assertEquals(23, meeting.getEndTime());
    }

    @Test
    public void testMeetingDescriptionConstructor() {
        Meeting meeting = new Meeting(4, 10, "Vacation");
        assertEquals("Vacation", meeting.getDescription());
        assertEquals(0, meeting.getStartTime());
        assertEquals(23, meeting.getEndTime());
    }
}

