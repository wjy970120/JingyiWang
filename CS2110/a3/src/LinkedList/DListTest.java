package LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DListTest {

	@Test
	public void testConstructor() {
		DList<Integer> b= new DList<>();
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringR());
		assertEquals(0, b.size());

		DList<String> d= new DList<>();
		assertEquals("[]", d.toString());
		assertEquals("[]", d.toStringR());
		assertEquals(0, d.size());
	}

	@Test
	public void testPrepend() {
		DList<String> ll= new DList<>();
		ll.prepend("Sampson");
		assertEquals("[Sampson]", ll.toString());
		assertEquals("[Sampson]", ll.toStringR());
		assertEquals(1, ll.size());
		ll.prepend("Tom");
		assertEquals("[Tom, Sampson]", ll.toString());
		assertEquals("[Sampson, Tom]", ll.toStringR());
		assertEquals(2, ll.size());
		ll.prepend("Jerry");
		assertEquals("[Jerry, Tom, Sampson]", ll.toString());
		assertEquals("[Sampson, Tom, Jerry]", ll.toStringR());
		assertEquals(3, ll.size());

		DList<String> kk= new DList<>();
		kk.prepend("");
		kk.prepend("");
		assertEquals("[, ]", kk.toString());
		assertEquals("[, ]", kk.toStringR());
		assertEquals(2, kk.size());
		kk.prepend("Tom");
		assertEquals("[Tom, , ]", kk.toString());
		assertEquals("[, , Tom]", kk.toStringR());
		assertEquals(3, kk.size());

		DList<Integer> hh= new DList<>();
		hh.prepend(8);
		hh.prepend(7);
		hh.prepend(4);
		assertEquals("[4, 7, 8]", hh.toString());
		assertEquals("[8, 7, 4]", hh.toStringR());
		assertEquals(3, hh.size());
	}

	@Test
	public void testAppend() {
		DList<String> ll= new DList<>();
		ll.append("Sampson");
		assertEquals("[Sampson]", ll.toString());
		assertEquals("[Sampson]", ll.toStringR());
		assertEquals(1, ll.size());
		ll.append("Tom");
		assertEquals("[Sampson, Tom]", ll.toString());
		assertEquals("[Tom, Sampson]", ll.toStringR());
		assertEquals(2, ll.size());
		ll.append("Jerry");
		assertEquals("[Sampson, Tom, Jerry]", ll.toString());
		assertEquals("[Jerry, Tom, Sampson]", ll.toStringR());
		assertEquals(3, ll.size());

		DList<String> kk= new DList<>();
		kk.append("");
		kk.append("");
		assertEquals("[, ]", kk.toString());
		assertEquals("[, ]", kk.toStringR());
		assertEquals(2, kk.size());
		kk.append("Tom");
		assertEquals("[, , Tom]", kk.toString());
		assertEquals("[Tom, , ]", kk.toStringR());
		assertEquals(3, kk.size());

		DList<Integer> hh= new DList<>();
		hh.append(8);
		hh.append(7);
		hh.append(4);
		assertEquals("[8, 7, 4]", hh.toString());
		assertEquals("[4, 7, 8]", hh.toStringR());
		assertEquals(3, hh.size());
	}

	@Test
	public void testGetNode() {
		DList<Integer> ll= new DList<>();
		ll.append(728);
		ll.append(531);
		ll.append(313);
		ll.append(214);
		ll.append(889);
		assertEquals(728, (int) ll.getNode(0).value());
		assertEquals(531, (int) ll.getNode(1).value());
		assertEquals(313, (int) ll.getNode(2).value());
		assertEquals(214, (int) ll.getNode(3).value());
		assertEquals(889, (int) ll.getNode(4).value());

		DList<String> kk= new DList<>();
		kk.append("Tom");
		kk.append("Jerry");
		kk.append("Anne");
		kk.append("Peter");
		kk.append("Sally");
		assertEquals("Tom", kk.getNode(0).value());
		assertEquals("Jerry", kk.getNode(1).value());
		assertEquals("Anne", kk.getNode(2).value());
		assertEquals("Peter", kk.getNode(3).value());
		assertEquals("Sally", kk.getNode(4).value());
	}

	@Test
	public void testDelete() {
		DList<Integer> ll= new DList<>();
		ll.append(9);
		ll.append(3);
		ll.append(8);
		ll.append(2);
		ll.append(6);
		assertEquals("[9, 3, 8, 2, 6]", ll.toString());
		assertEquals("[6, 2, 8, 3, 9]", ll.toStringR());
		assertEquals(5, ll.size());

		ll.delete(ll.getNode(0));
		assertEquals("[3, 8, 2, 6]", ll.toString());
		assertEquals("[6, 2, 8, 3]", ll.toStringR());
		assertEquals(4, ll.size());

		ll.delete(ll.getNode(3));
		assertEquals("[3, 8, 2]", ll.toString());
		assertEquals("[2, 8, 3]", ll.toStringR());
		assertEquals(3, ll.size());

		ll.delete(ll.getNode(1));
		assertEquals("[3, 2]", ll.toString());
		assertEquals("[2, 3]", ll.toStringR());
		assertEquals(2, ll.size());

		ll.delete(ll.getNode(0));
		ll.delete(ll.getNode(0));
		assertEquals("[]", ll.toString());
		assertEquals("[]", ll.toStringR());
		assertEquals(0, ll.size());
	}

	@Test
	public void testInsertBefore() {
		DList<Integer> ll= new DList<>();
		ll.append(2);
		ll.append(4);
		ll.append(8);
		assertEquals("[2, 4, 8]", ll.toString());
		assertEquals("[8, 4, 2]", ll.toStringR());
		assertEquals(3, ll.size());

		ll.insertBefore(3, ll.getNode(0));
		assertEquals("[3, 2, 4, 8]", ll.toString());
		assertEquals("[8, 4, 2, 3]", ll.toStringR());
		assertEquals(4, ll.size());

		ll.insertBefore(7, ll.getNode(1));
		assertEquals("[3, 7, 2, 4, 8]", ll.toString());
		assertEquals("[8, 4, 2, 7, 3]", ll.toStringR());
		assertEquals(5, ll.size());
	}
}
