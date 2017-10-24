package assignment2;

import org.junit.*;

public class GuestHouseTest {
	Controller controller;
	
	@Before
	public void setUp(){
		controller = new Controller();
		controller.setTotalNumberOfRooms(5);
	}
	
	@Test
	public void testNonPrimeRoomNumber(){
		Assert.assertFalse(controller.isPrimeNumber(18));
	}
	
	@Test
	public void testPrimeRoomNumberCount(){
		Assert.assertTrue(controller.isPrimeNumber(5));
	}
	
	@Test(expected = NullPointerException.class)
	public void testRoomNumberAllotmentToNull() {
		Guest addGuest = null;
		Assert.assertEquals(4, controller.bookRoom(addGuest));
	}
	
	@Test
	public void testRoomNumberAlloted() {
		Guest addGuest = new Guest("Test", 29);
		Assert.assertEquals(4, controller.bookRoom(addGuest));
	}
	
	@Test
	public void testAllAvailableGetRoomDetails() {
		Object[] actual = controller.getRoomDetails();
		
		for(int index = 0; index < 5; index++) {
			Assert.assertEquals(null, actual[index]);
		}
	}
	
	@Test
	public void testFilledRoomDetails() {
		Guest addGuest1 = new Guest("Test1", 29);
		Guest addGuest2 = new Guest("Test2", 31);
		
		int roomNumber1 = controller.bookRoom(addGuest1);
		int roomNumber2 = controller.bookRoom(addGuest2);
		
		Object[] actual = controller.getRoomDetails();
		
		Assert.assertEquals(addGuest1, actual[roomNumber1]);
		Assert.assertEquals(addGuest2, actual[roomNumber2]);
	}
}
