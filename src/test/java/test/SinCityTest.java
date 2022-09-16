package test;

import base.TestBase;
import enumerators.SinType;
import models.sin;
import org.apache.commons.math3.analysis.function.Sin;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SinCityPage;
import pages.SpartaPage;

import java.util.ArrayList;
import java.util.List;

public class SinCityTest extends TestBase {


    @Test
    public void testNewSin() {

        sin flySin = new sin("zabil som poliaka", "MaceMat", "zabil som muchu peknou cervenou mucholapkou");
        //flySin.setTitle("zabil som dve muchy"); (Setter for new title)
        SinCityPage sinCityPage = new SinCityPage();
        List<SinType> spiderSinTags = new ArrayList<SinType>();
        spiderSinTags.add(SinType.MURDER);
        spiderSinTags.add(SinType.ROBBERY);
        spiderSinTags.add(SinType.CAR_ACCIDENT);
        spiderSinTags.add(SinType.BLACKMAIL);
        flySin.setTags(spiderSinTags);

        sinCityPage.openPage();
        sinCityPage.fillSinInformation(flySin);
        sinCityPage.markTag(flySin.getTags());
        sinCityPage.confessSin();
        sinCityPage.checkSinStatus(flySin);
        sinCityPage.openSinDetail(flySin);
        sinCityPage.checkSinDetail(flySin);

    }

    @Test
    public void testForgive(){
        sin evaspieva = new sin("spievame vsetci", "dusan.p a eva m.", "spievame stale");
        SinCityPage sinCityPage = new SinCityPage();

        sinCityPage.openPage();
        sinCityPage.fillSinInformation(evaspieva);
        sinCityPage.confessSin();

        SpartaPage spartaPage = new SpartaPage();
        spartaPage.openpage();
        spartaPage.forgiveSin(evaspieva);

        sinCityPage.openPage();
        sinCityPage.checkSinStatus(evaspieva);
    }

}
