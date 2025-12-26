@Service
public class MatchServiceImpl implements MatchService {

    private final SkillOfferRepository offerRepo;
    private final SkillRequestRepository requestRepo;
    private final MatchRecordRepository matchRepo;
    private final UserProfileRepository userRepo;
    private final SkillMatchingEngine skillMatchingEngine;

    public MatchServiceImpl(SkillOfferRepository offerRepo,
                            SkillRequestRepository requestRepo,
                            MatchRecordRepository matchRepo,
                            UserProfileRepository userRepo,
                            SkillMatchingEngine skillMatchingEngine) {
        this.offerRepo = offerRepo;
        this.requestRepo = requestRepo;
        this.matchRepo = matchRepo;
        this.userRepo = userRepo;
        this.skillMatchingEngine = skillMatchingEngine;
    }

    // use skillMatchingEngine.calculateMatchScore(...) in your methods
}
