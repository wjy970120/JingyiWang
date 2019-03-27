import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PhDTest {

	@Test
	void testGroupA() {
		PhD p= new PhD(1, 1997, "Jingyi Wang");

		assertEquals("Jingyi Wang", p.name());
		assertEquals(1997, p.year());
		assertEquals(1, p.month());
		assertEquals(null, p.advisor1());
		assertEquals(null, p.advisor2());
		assertEquals(0, p.advisees());
	}

	@Test
	void testGroupB() {
		PhD p1= new PhD(1, 1997, "Jingyi Wang");
		PhD p2= new PhD(10, 1997, "Haoran Liu");
		PhD p3= new PhD(10, 1993, "Jingting Bai");

		p1.setAdvisor1(p2);
		assertEquals(p2, p1.advisor1());
		assertEquals(1, p2.advisees());

		p1.setAdvisor2(p3);
		assertEquals(p3, p1.advisor2());
		assertEquals(1, p3.advisees());
	}

	@Test
	void testGroupC() {
		PhD p1= new PhD(11, 2000, "Jackson Yi");
		PhD p2= new PhD(4, 1988, "Yilong Zhu");

		PhD p3= new PhD(1, 1997, "Jingyi Wang", p1);
		assertEquals("Jingyi Wang", p3.name());
		assertEquals(1997, p3.year());
		assertEquals(1, p3.month());
		assertEquals(p1, p3.advisor1());
		assertEquals(null, p3.advisor2());
		assertEquals(0, p3.advisees());
		assertEquals(1, p1.advisees());

		PhD p4= new PhD(12, 1995, "Yuanfan Bao", p1, p2);
		assertEquals("Yuanfan Bao", p4.name());
		assertEquals(1995, p4.year());
		assertEquals(12, p4.month());
		assertEquals(p1, p4.advisor1());
		assertEquals(p2, p4.advisor2());
		assertEquals(0, p4.advisees());
		assertEquals(2, p1.advisees());
		assertEquals(1, p2.advisees());
	}

	@Test
	void testGroupD() {
		PhD feb771= new PhD(2, 1977, "feb77");
		PhD feb772= new PhD(2, 1977, "feb77");
		assertEquals(false, feb771.gotAfter(feb772));

		PhD feb77= new PhD(2, 1977, "feb77");
		PhD aug77= new PhD(8, 1977, "aug77");
		assertEquals(false, feb77.gotAfter(aug77));

		PhD jun78= new PhD(6, 1978, "jun77");
		PhD feb78= new PhD(2, 1978, "feb77");
		assertEquals(true, jun78.gotAfter(feb78));

		PhD mar80= new PhD(3, 1980, "mar80");
		PhD mar83= new PhD(3, 1983, "mar83");
		assertEquals(false, mar80.gotAfter(mar83));

		PhD feb81= new PhD(2, 1981, "feb81");
		PhD jun86= new PhD(6, 1986, "jun86");
		assertEquals(false, feb81.gotAfter(jun86));

		PhD aug80= new PhD(8, 1980, "aug80");
		PhD mar82= new PhD(3, 1982, "mar82");
		assertEquals(false, aug80.gotAfter(mar82));

		PhD jan88= new PhD(1, 1988, "jan88");
		PhD jan84= new PhD(1, 1984, "jan84");
		assertEquals(true, jan88.gotAfter(jan84));

		PhD mar85= new PhD(3, 1985, "mar85");
		PhD aug84= new PhD(8, 1984, "aug84");
		assertEquals(true, mar85.gotAfter(aug84));

		PhD aug87= new PhD(8, 1987, "aug87");
		PhD apr81= new PhD(4, 1981, "apr81");
		assertEquals(true, aug87.gotAfter(apr81));

		PhD A1= new PhD(6, 1985, "jun85");
		PhD B1= new PhD(6, 1985, "jun85");
		assertEquals(false, A1.areSiblings(B1));

		PhD A2= new PhD(2, 1988, "feb88");
		PhD B2= new PhD(4, 1982, "apr82");
		assertEquals(false, A2.areSiblings(B2));

		PhD mar70= new PhD(3, 1970, "mar70");
		PhD aug70= new PhD(8, 1970, "aug70");
		PhD mar71= new PhD(3, 1971, "mar71");
		PhD aug71= new PhD(8, 1971, "aug71");

		PhD A3= new PhD(3, 1988, "mar88", mar70, aug70);
		PhD B31= new PhD(8, 1988, "aug88", mar70, aug71);
		assertEquals(true, A3.areSiblings(B31));

		PhD B32= new PhD(6, 1988, "jun88", aug71, mar70);
		assertEquals(true, A3.areSiblings(B32));

		PhD A4= new PhD(8, 1990, "aug90", mar71, aug71);
		PhD B41= new PhD(7, 1990, "jul90", aug71, mar70);
		assertEquals(true, A4.areSiblings(B41));

		PhD B42= new PhD(2, 1990, "feb90", mar70, aug71);
		assertEquals(true, A4.areSiblings(B42));
	}

	@Test
	void testAssert() {
		PhD p1= new PhD(10, 1997, "Haoran Liu");
		PhD p2= new PhD(10, 1993, "Jingting Bai");

		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, null); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, ""); });
		assertThrows(AssertionError.class, () -> { new PhD(0, 1997, "Jingyi Wang"); });
		assertThrows(AssertionError.class, () -> { new PhD(13, 1997, "Jingyi Wang"); });

		assertThrows(AssertionError.class, () -> { new PhD(0, 1997, "Jingyi Wang", p1); });
		assertThrows(AssertionError.class, () -> { new PhD(13, 1997, "Jingyi Wang", p1); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, null, p1); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, "", p1); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, "Jingyi Wang", null); });

		assertThrows(AssertionError.class, () -> { new PhD(0, 1997, "Jingyi Wang", p1, p2); });
		assertThrows(AssertionError.class, () -> { new PhD(13, 1997, "Jingyi Wang", p1, p2); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, null, p1, p2); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, "", p1, p2); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, "Jingyi Wang", null, p2); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, "Jingyi Wang", p1, null); });
		assertThrows(AssertionError.class, () -> { new PhD(1, 1997, "Jingyi Wang", p1, p1); });

		PhD p3= new PhD(11, 2000, "Jackson Yi", p1);
		PhD p4= new PhD(4, 1988, "Yilong Zhu", p1, p2);

		assertThrows(AssertionError.class, () -> { p3.setAdvisor1(p2); });
		assertThrows(AssertionError.class, () -> { p1.setAdvisor1(null); });

		assertThrows(AssertionError.class, () -> { p1.setAdvisor2(p2); });
		assertThrows(AssertionError.class, () -> { p4.setAdvisor2(p2); });
		assertThrows(AssertionError.class, () -> { p3.setAdvisor2(null); });
		assertThrows(AssertionError.class, () -> { p3.setAdvisor2(p1); });

		assertThrows(AssertionError.class, () -> { p1.gotAfter(null); });
	}
}
