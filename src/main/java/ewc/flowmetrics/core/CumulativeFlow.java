package ewc.flowmetrics.core;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

/**
 * The CumulativeFlow class is designed to process and analyze time-series data points, each
 * associated with a LocalDate, to compute cumulative metrics such as throughput, flow time, and
 * work-in-progress (WIP) over time. It uses a Clock for date calculations, and its main data
 * structure is a list of DataPoint objects.
 */
public class CumulativeFlow {
    /**
     * The clock used for time-related operations, allowing for flexible date handling in tests.
     */
    private final Clock clock;

    /**
     * Main data structure holding the existing flow data points. This data is provided as is
     * by the calling code and is not modified by the CumulativeFlow class. It is stored for
     * reference and should be used to initialize the cumulative flow calculations.
     */
    private final List<DataPoint> rawData;

    /**
     * Creates a CumulativeFlow instance with a predefined set of data points for testing purposes.
     *
     * @param clock The clock to use for time-related operations.
     * @return A CumulativeFlow instance with test data points.
     */
    public static CumulativeFlow createTestable(Clock clock) {
        return new CumulativeFlow(clock, (List.of(
                new DataPoint(LocalDate.of(2023, 12, 31), 0, 0, -1, -1),
                new DataPoint(LocalDate.of(2024, 1, 1), 1, 0, -1, -1),
                new DataPoint(LocalDate.of(2024, 1, 7), 6, 0, -1, -1),
                new DataPoint(LocalDate.of(2024, 1, 12), 5, 6, -1, -1),
                new DataPoint(LocalDate.of(2024, 1, 24), 12, 6, -1, -1),
                new DataPoint(LocalDate.of(2024, 1, 28), 4, 2, -1, -1)
        )));
    }

    private CumulativeFlow(Clock clock, List<DataPoint> rawData) {
        this.clock = clock;
        this.rawData = rawData;
    }

    public record DataPoint(LocalDate date, int in, int out, double flowTime, double throughput) {

    }
}
