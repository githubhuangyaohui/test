package Game;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellTest {
	public static Cell cell;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCellIntInt() {
		cell=new Cell(1,5);
		 assertEquals(1, cell.getStatus());
		 assertEquals(5, cell.getLiving());
	}
	@Test
	public void testUpdateStatus() {
		cell=new Cell(1,5);
		cell.UpdateStatus();
		 assertEquals(0, cell.getStatus());
	}

}
