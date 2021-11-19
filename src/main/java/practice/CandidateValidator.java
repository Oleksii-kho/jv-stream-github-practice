package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int INDEX_YEAR_FROM = 0;
    private static final int INDEX_YEAR_TO = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && countYearsFromPeriod(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private int countYearsFromPeriod(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[INDEX_YEAR_TO]) - Integer.parseInt(years[INDEX_YEAR_FROM]);
    }
}
