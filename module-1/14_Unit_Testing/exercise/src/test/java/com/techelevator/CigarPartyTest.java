package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;

public class CigarPartyTest {

    CigarParty cigar = new CigarParty();

    @Test
    public void testWeekendFalse() {
        Assert.assertEquals(false, cigar.haveParty(35, false));
        Assert.assertEquals(false, cigar.haveParty(65, false));
        Assert.assertEquals(true, cigar.haveParty(50, false));
        Assert.assertEquals(true, cigar.haveParty(60, false));
        Assert.assertEquals(true, cigar.haveParty(40, false));
    }

    @Test
    public void testWeekendTrue() {
        Assert.assertEquals(true, cigar.haveParty(40, true));
        Assert.assertEquals(true, cigar.haveParty(65, true));
        Assert.assertEquals(false, cigar.haveParty(35, true));
        Assert.assertEquals(false, cigar.haveParty(25, true));
        Assert.assertEquals(true, cigar.haveParty(90, true));
    }
}
