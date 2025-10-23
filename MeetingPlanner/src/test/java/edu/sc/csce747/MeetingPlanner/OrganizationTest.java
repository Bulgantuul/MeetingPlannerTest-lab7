package edu.sc.csce747.MeetingPlanner;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

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

    @Test(expected = Exception.class)
    public void testGetNonExistentEmployee() throws Exception {
        Organization org = new Organization();
        org.getEmployee("No One");  // should throw Exception
    }

    @Test(expected = Exception.class)
    public void testGetNonExistentRoom() throws Exception {
        Organization org = new Organization();
        org.getRoom("99Z");  // should throw Exception
    }
}
