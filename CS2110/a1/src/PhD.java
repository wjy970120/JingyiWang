/** NetId:jw2527(Jingyi Wang), js3439(Junyi Shen). Time spent: 6 hours, 20 minutes. */
/** An instance maintains info about the PhD of a person. */

public class PhD {

	/** month PhD was awarded. In range 1 .. 12, with 1 being January,etc. */
	private int month;

	/** year PhD was awarded. Can be any integer. */
	private int year;

	/** Name of the person with a PhD, a String of length > 0. */
	private String name;

	/** The first PhD advisor of this person, null if unknown. */
	private PhD advisor1;

	/** The second advisor of this person, null if unknown or if the person has less than two
	 * advisors. */
	private PhD advisor2;

	/** The number of PhD advisees of this person. */
	private int advisees;

	/** Constructor: a PhD with PhD month m, PhD year y, and name n.<br>
	 * The advisors are unknown, and there are 0 advisees.<br>
	 * Precondition: n has at least 1 char and m is in 1..12. */
	public PhD(int m, int y, String n) {
		assert m >= 1 && m <= 12;
		month= m;
		year= y;
		assert n != null && n.length() >= 1;
		name= n;
		advisor1= null;
		advisor2= null;
		advisees= 0;
	}

	/** Constructor: a PhD with PhD month m, PhD year y, name n, <br>
	 * first advisor adv1, and no second advisor.<br>
	 * Precondition: n has at least 1 char, m is in 1..12, and adv1 is not null. */
	public PhD(int m, int y, String n, PhD adv1) {
		assert m >= 1 && m <= 12;
		month= m;
		year= y;
		assert n != null && n.length() >= 1;
		name= n;
		assert adv1 != null;
		advisor1= adv1;
		adv1.advisees++ ;
		advisor2= null;
		advisees= 0;
	}

	/** Constructor: a PhD with PhD month m, PhD year y, name n, <br>
	 * first advisor adv1, and second advisor adv2.<br>
	 * Precondition: n has at least 1 char, m is in 1..12,<br>
	 * adv1 and adv2 are not null, and adv1 and adv2 are different. */
	public PhD(int m, int y, String n, PhD adv1, PhD adv2) {
		assert m >= 1 && m <= 12;
		month= m;
		year= y;
		assert n != null && n.length() >= 1;
		name= n;
		assert adv1 != null && adv2 != null && adv1 != adv2;
		advisor1= adv1;
		adv1.advisees++ ;
		advisor2= adv2;
		adv2.advisees++ ;
		advisees= 0;
	}

	/** Return the name of this person. */
	public String name() {
		return name;
	}

	/** Return the year this person got their PhD. */
	public int year() {
		return year;
	}

	/** Return the month this person got their PhD. */
	public int month() {
		return month;
	}

	/** Return the first advisor of this PhD (null if unknown). */
	public PhD advisor1() {
		return advisor1;
	}

	/** Return the second advisor of this PhD (null if unknown or non-existent). */
	public PhD advisor2() {
		return advisor2;
	}

	/** Return the number of PhD advisees of this person. */
	public int advisees() {
		return advisees;
	}

	/** Make p the first advisor of this person.<br>
	 * Precondition: the first advisor is unknown and p is not null. */
	public void setAdvisor1(PhD p) {
		assert advisor1 == null && p != null;
		advisor1= p;
		p.advisees= p.advisees + 1;
	}

	/** Make p the second advisor of this PhD. <br>
	 * Precondition: The first advisor is known, the second advisor is unknown, <br>
	 * p is not null, and p is different from the first advisor. */
	public void setAdvisor2(PhD p) {
		assert advisor1 != null && advisor2 == null && p != null && p != advisor1;
		advisor2= p;
		p.advisees= p.advisees + 1;
	}

	/** Return value of: this PhD got the PhD after p.<br>
	 * Precondition: p is not null. */
	public boolean gotAfter(PhD p) {
		assert p != null;
		/** If date p1 comes after date p2,<br>
		 * then p1's > p2's year,<br>
		 * or p1's year = p2's year, and p1's month > p2's month. */
		return year > p.year() || year == p.year() && month > p.month();
	}

	/** Return value of: p is not null and this PhD and p are intellectual siblings. */
	public boolean areSiblings(PhD p) {
		return p != null && this != p &&
			advisor1 != null && (advisor1 == p.advisor1() || advisor1 == p.advisor2()) ||
			advisor2 != null && (advisor2 == p.advisor1() || advisor2 == p.advisor2());
	}
}
