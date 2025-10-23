package edu.sc.csce747.MeetingPlanner;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.sc.csce747.MeetingPlanner.Calendar;
import edu.sc.csce747.MeetingPlanner.Meeting;
import edu.sc.csce747.MeetingPlanner.Room;
import edu.sc.csce747.MeetingPlanner.TimeConflictException;


public class CalendarTest {

    @Test
    public void testAddMeeting_noConflict() {
        Calendar calendar = new Calendar();
        try {
            Meeting meeting = new Meeting(5, 10, 10, 12, null, new Room(), "Team Meeting");
            calendar.addMeeting(meeting);
            assertTrue(calendar.isBusy(5, 10, 10, 12));
        } catch (TimeConflictException e) {
            fail("No conflict expected: " + e.getMessage());
        }
    }

    @Test
    public void testAddMeeting_conflict() {
        Calendar calendar = new Calendar();
        try {
            Meeting m1 = new Meeting(5, 10, 10, 12, null, new Room(), "Meeting1");
            calendar.addMeeting(m1);
            Meeting m2 = new Meeting(5, 10, 11, 13, null, new Room(), "Meeting2");
            calendar.addMeeting(m2);
            fail("Expected TimeConflictException for overlapping meeting");
        } catch (TimeConflictException e) {
            assertTrue(e.getMessage().contains("Overlap"));
        }
    }
}
