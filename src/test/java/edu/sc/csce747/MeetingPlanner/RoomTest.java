package edu.sc.csce747.MeetingPlanner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class RoomTest {

    @Test
    public void testRoomAddMeeting_noConflict() {
        Room room = new Room("R101");
        Meeting meeting = new Meeting(6, 15, 9, 10, new ArrayList<>(), room, "Morning Meeting");
        try {
            room.addMeeting(meeting);
            assertTrue(room.isBusy(6, 15, 9, 10));
        } catch (TimeConflictException e) {
            fail("No conflict expected: " + e.getMessage());
        }
    }

    @Test
    public void testRoomAddMeeting_conflict() throws TimeConflictException {
        Room room = new Room("R101");
        Meeting m1 = new Meeting(6, 15, 9, 11, new ArrayList<>(), room, "Meeting1");
        room.addMeeting(m1);
        Meeting m2 = new Meeting(6, 15, 10, 12, new ArrayList<>(), room, "Meeting2");
        assertThrows(TimeConflictException.class, () -> room.addMeeting(m2));
    }
}
