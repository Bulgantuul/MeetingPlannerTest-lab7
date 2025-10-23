package edu.sc.csce747.MeetingPlanner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class OrganizationTest {

    @Test
    public void testGetEmployees() throws Exception {
        Organization org = new Organization();
        ArrayList<Person> employees = org.getEmployees();

        assertEquals(5, employees.size());
        assertEquals("Greg Gay", employees.get(0).getName());

        Person p = org.getEmployee("Ryan Austin");
        assertEquals("Ryan Austin", p.getName());
    }

    @Test
    public void testGetRooms() throws Exception {
        Organization org = new Organization();
        ArrayList<Room> rooms = org.getRooms();

        assertEquals(5, rooms.size());
        assertEquals("2A01", rooms.get(0).getID());

        Room r = org.getRoom("2A03");
        assertEquals("2A03", r.getID());
    }

    @Test
    public void testGetNonExistentEmployee() {
        Organization org = new Organization();

        Exception ex = assertThrows(Exception.class, () -> org.getEmployee("No One"));
        assertTrue(ex.getMessage().contains("No One"));
    }

    @Test
    public void testGetNonExistentRoom() {
        Organization org = new Organization();

        Exception ex = assertThrows(Exception.class, () -> org.getRoom("99Z"));
        assertTrue(ex.getMessage().contains("99Z"));
    }
}
