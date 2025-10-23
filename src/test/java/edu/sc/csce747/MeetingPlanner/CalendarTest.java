package edu.sc.csce747.MeetingPlanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CalendarTest {

    @Test
    public void testAddMeeting_noConflict() throws TimeConflictException {
        Calendar calendar = new Calendar();
        Meeting meeting = new Meeting(5, 10, 10, 12, null, new Room(), "Team Meeting");
        calendar.addMeeting(meeting);
        assertTrue(calendar.isBusy(5, 10, 10, 12));
    }

    @Test
    public void testAddMeeting_conflict() {
        Calendar calendar = new Calendar();
        assertThrows(TimeConflictException.class, () -> {
            Meeting m1 = new Meeting(5, 10, 10, 12, null, new Room(), "Meeting1");
            calendar.addMeeting(m1);

            Meeting m2 = new Meeting(5, 10, 11, 13, null, new Room(), "Meeting2");
            calendar.addMeeting(m2);  // Should throw exception
        });
    }

    @Test
    public void testAddMeeting_invalidDate() {
        Calendar calendar = new Calendar();
        assertThrows(TimeConflictException.class, () -> {
            Meeting meeting = new Meeting(2, 30, 10, 12, null, new Room(), "Invalid Date");
            calendar.addMeeting(meeting);
        });
    }
}
