package gradingTools.comp524f19.assignment4.distributed.collaborative;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({	
	DistributedCollaborativeClient2Input.class,
	DistributedCollaborativeClient2AndServerInput.class,
	DistributedCollaborativeClient2ServerAndClient1Input.class
})
	
@IsExtra(true)
public class DistributedCollaborativeSuite {
	
}
