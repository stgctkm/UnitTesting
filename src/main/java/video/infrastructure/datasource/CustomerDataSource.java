package video.infrastructure.datasource;

import java.util.HashMap;
import java.util.Map;

public class CustomerDataSource {

    static Map<String, Integer> rentalPoints = new HashMap<>();

    /**
     * ポイントの記録
     */
    public void registerRentalPoint(String customerName, int point) {
        rentalPoints.merge(customerName, point, Integer::sum);
    }

    /**
     * ポイントの取得
     */
    public int pointOf(String customerName) {
        return rentalPoints.get(customerName);
    }

}
