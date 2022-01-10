package at.aau.ue4.bsp1;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({BaseTest.class, FullCoverageTest.class, FullMutationScoreTest.class})
@RunWith(JUnitPlatform.class)
@SelectClasses( {BaseTest.class, FullCoverageTest.class, FullMutationScoreTest.class})
public class RingBufferTest {

}
