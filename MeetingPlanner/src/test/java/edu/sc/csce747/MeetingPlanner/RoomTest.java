package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class RoomTest {

    @Test
    public void testRoomAddMeeting() {
        Room room = new Room("R101");
        ArrayList<Person> attendees = new ArrayList<>();
        Meeting meeting = new Meeting(6, 15, 9, 10, attendees, room, "Morning Meeting");
        try {
            room.addMeeting(meeting);
            assertTrue(room.isBusy(6, 15, 9, 10));
        } catch (TimeConflictException e) {
            fail("No conflict expected: " + e.getMessage());
        }
    }
}
