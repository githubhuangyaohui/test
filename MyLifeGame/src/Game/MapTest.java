package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MapTest {
	public static Cell cell[][]=new Cell[16][16];
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cell=Map.Create();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@Test
	void testGetLivings() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(1);
			}
		}
		Map.getLivings(cell);
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				if(i>0&&i<15&&j>0&&j<15) assertEquals(8,cell[i][j].getLiving());
				else if((i==0||i==15)&&(j>0&&j<15)||(j==0||j==15)&&(i>0&&i<15)) assertEquals(5,cell[i][j].getLiving());
				else assertEquals(3,cell[i][j].getLiving());
			}
		}
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		Map.getLivings(cell);
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				assertEquals(0,cell[i][j].getLiving());
			}
		}
	}

	@Test
	void test	() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(1);
			}
		}
		Map.getLivings(cell);
		assertEquals(4,Map.Update(cell));
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				cell[i][j].setStatus(0);
			}
		}
		Map.getLivings(cell);
		assertEquals(256,Map.Update(cell));
	}
}


