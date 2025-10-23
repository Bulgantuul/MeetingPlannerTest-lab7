package edu.sc.csce747.MeetingPlanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomTest {
    private Room room;
    private Meeting meeting1;
    private Meeting meeting2;

    @BeforeEach
    void setUp() {
        room = new Room("TestRoom");
        meeting1 = new Meeting(10, 23, 9, 10, null, room, "Team Meeting");
        meeting2 = new Meeting(10, 23, 9, 10, null, room, "Conflict Meeting");
    }

    @Test
    void testAddMeeting() throws Exception {
        room.addMeeting(meeting1);
        assertTrue(room.isBusy(10, 23, 9, 10));
    }

    @Test
    void testAddMeetingConflict() {
        assertThrows(TimeConflictException.class, () -> {
            room.addMeeting(meeting1);
            room.addMeeting(meeting2);
        });
    }
}
