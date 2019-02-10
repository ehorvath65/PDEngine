package org.rulez.demokracia.pdengine;

import java.util.List;

public class VoteRegistry extends ChoiceManager implements IVoteManager {
	public VoteRegistry() {
		super();
	}
	
	@Override
	public String obtainBallot(String id, String adminKey) {
		Vote vote = getVote(id);
		vote.checkAdminKey(adminKey);
		String ballot = RandomUtils.createRandomKey();
		vote.ballots.add(ballot);
		return ballot;
	}

	@Override
	public void castVote(String voteId, String ballot, List<RankedChoice> theVote) {
		Vote vote = getVote(voteId);
		vote.ballots.remove(ballot);
	}

}
