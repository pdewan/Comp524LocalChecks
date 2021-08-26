package gradingTools.comp524f19.assignment4.lazy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ListMToNCarNormalEval.class,
	ListMToNCarLazyEval.class,
	ListMToNCdrLazyEval.class,
	ListMToNCarCdrLazyEval.class

	
})
	
@IsExtra(true)
public class LazinessSensitiveFunSuite {
	
}

