package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class MeetingTest {

    @Test
    public void testMeetingConstructor() {
        ArrayList<Person> attendees = new ArrayList<>();
        Room room = new Room("R301");
        Meeting meeting = new Meeting(8, 5, 10, 12, attendees, room, "Design Review");

        assertEquals(8, meeting.getMonth());
        assertEquals(5, meeting.getDay());
        assertEquals("Design Review", meeting.getDescription());
        assertEquals(room, meeting.getRoom());
    }
}
