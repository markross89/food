package pl.coderslab.web._helpers;

import pl.coderslab.model.RecipePlanDetails;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class PlanDetailsHelper {
    public static Map<String, List<RecipePlanDetails>> groupByDay(List<RecipePlanDetails> recipePlanDetails) {
        return recipePlanDetails.stream().collect(groupingBy(RecipePlanDetails::getDayName,
                        LinkedHashMap::new, Collectors.toList()));
    }
}
