package seedu.address.model.person.timetable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPersons.ALICE;

import org.junit.Test;

public class TimetableDataTest {

    private String timetableString = ALICE.getTimetable().getTimetableDataString();
    private TimetableData timetableData = new TimetableData("horizontal", ALICE.getStoredLocation(),
        timetableString, 1, null, null, null);

    private TimetableData timetableDataWrongSize = new TimetableData("horizontal",
        ALICE.getStoredLocation(),
        "0700,800,900,1000," + timetableString, 1, null, null, null);

    private String wrongTimetableString =
        "aG9yaXpvbnRhbA==,aG9yaXpvbnRhbA==," + timetableString.substring(26);
    private TimetableData timetableDataWrongFirstRow = new TimetableData("horizontal",
        ALICE.getStoredLocation(), wrongTimetableString, 1, null, null,
        null);


    @Test
    public void equals() {
        // same values -> returns true
        assertTrue(timetableData.equals(timetableData));

        // null -> returns false
        assertFalse(timetableData.equals(null));

        // different type -> returns false
        assertFalse(timetableData.equals(5));


    }

    @Test
    public void checkProperties() {

        // check if timetableData has correct size
        assertTrue(timetableData.isCorrectSize());

        // check if timetableData has correct first Rows and Columns
        assertTrue(timetableData.hasCorrectFirstRowsAndColumns());

        // check if timetableData has correct timings for boths
        assertEquals(timetableData.getTimings(), timetableData.getTimings());

        // check if timetableData has correct days for boths
        assertEquals(timetableData.getDaysInLowerCase(), timetableData.getDaysInLowerCase());

        // check wrongtimetableData has incorrect size
        assertFalse(timetableDataWrongSize.isCorrectSize());

        // check  wrongTimetableData has incorrect first Rows and Columns
        assertFalse(timetableDataWrongFirstRow.hasCorrectFirstRowsAndColumns());
    }

}
