package rauan.ferreira.gasstation.daos;

import java.util.ArrayList;
import java.util.List;

import rauan.ferreira.gasstation.entities.Supply;

public class SupplyDao {
    private static List<Supply> supplies = new ArrayList();

    public static Supply getByPosition (int position) {
        return supplies.get(position);
    }

    public static void create(Supply supply) {
        supplies.add(supply);
    }

    public static void update(int position, Supply newSupply) {
        delete(position);
        supplies.add(newSupply);
    }

    public static void delete(int position) {
        supplies.remove(position);
    }

    public static int total() {
        return supplies.size();
    }
}
